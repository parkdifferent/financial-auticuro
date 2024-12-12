package com.auticuro.core.statemachine;

import com.auticuro.core.exception.AccountLockedException;
import com.auticuro.core.exception.BalanceLimitException;
import com.auticuro.core.exception.InsufficientBalanceException;
import com.auticuro.proto.TransferRequest;
import com.auticuro.proto.TransferResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ratis.proto.RaftProtos.LogEntryProto;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.statemachine.TransactionContext;
import org.apache.ratis.statemachine.impl.BaseStateMachine;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.thirdparty.com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Component
public class WalletStateMachine extends BaseStateMachine {

    @Autowired
    private BalanceMap balanceMap;

    @Autowired
    private DedupStore dedupStore;

    @Autowired
    private EventStore eventStore;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {
        try {
            LogEntryProto entry = trx.getLogEntry();
            ByteString logData = entry.getStateMachineLogEntry().getLogData();
            TransferRequest request = TransferRequest.parseFrom(logData.toByteArray());
            
            // Check for duplicates
            if (dedupStore.isDuplicate(request.getTransactionId())) {
                return CompletableFuture.completedFuture(
                    Message.valueOf("Duplicate transaction: " + request.getTransactionId()));
            }

            // Get current balances
            String fromAccount = request.getFromAccount();
            String toAccount = request.getToAccount();
            BigDecimal amount = new BigDecimal(request.getAmount());

            // Check if accounts are locked
            if (balanceMap.isLocked(fromAccount) || balanceMap.isLocked(toAccount)) {
                throw new AccountLockedException("One or both accounts are locked");
            }

            // Check if sufficient balance
            BigDecimal fromBalance = balanceMap.getBalance(fromAccount);
            if (fromBalance.compareTo(amount) < 0) {
                throw new InsufficientBalanceException("Insufficient balance in source account");
            }

            // Check balance limits
            BigDecimal fromLimit = balanceMap.getLowerLimit(fromAccount);
            BigDecimal toLimit = balanceMap.getUpperLimit(toAccount);
            BigDecimal toBalance = balanceMap.getBalance(toAccount);
            
            if (fromLimit != null && fromBalance.subtract(amount).compareTo(fromLimit) < 0) {
                throw new BalanceLimitException("Transfer would breach lower limit of source account");
            }
            
            if (toLimit != null && toBalance.add(amount).compareTo(toLimit) > 0) {
                throw new BalanceLimitException("Transfer would breach upper limit of target account");
            }

            // Update balances
            balanceMap.transfer(fromAccount, toAccount, amount);

            // Record events
            eventStore.recordTransfer(request, true);

            // Record dedup
            dedupStore.record(request.getTransactionId());

            TransferResponse response = TransferResponse.newBuilder()
                .setSuccess(true)
                .setTransactionId(request.getTransactionId())
                .build();

            return CompletableFuture.completedFuture(Message.valueOf(String.valueOf(response.toByteString())));

        } catch (Exception e) {
            TransferResponse response = TransferResponse.newBuilder()
                .setSuccess(false)
                .setError(e.getMessage())
                .build();
            return CompletableFuture.completedFuture(
                    Message.valueOf(String.valueOf(response.toByteString())));
        }
    }
}
