package com.auticuro.core.service.impl;

import com.auticuro.core.entity.Account;
import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.core.mapper.AccountMapper;
import com.auticuro.core.mapper.BalanceChangeEventMapper;
import com.auticuro.core.service.AccountService;
import com.auticuro.core.service.TransferService;
import com.auticuro.core.statemachine.DedupStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BalanceChangeEventMapper eventMapper;

    @Autowired
    private DedupStore dedupStore;

    @Override
    @Transactional
    public void transfer(String transactionId, String fromAccount, String toAccount,
                        BigDecimal amount, String assetType, Map<String, String> metadata) {
        // Check for duplicate transaction
        if (dedupStore.isDuplicate(transactionId)) {
            throw new RuntimeException("Duplicate transaction: " + transactionId);
        }

        // Get and validate accounts
        Account from = accountService.getAccount(fromAccount);
        Account to = accountService.getAccount(toAccount);

        // Validate asset type
        if (!from.getAssetType().equals(assetType) || !to.getAssetType().equals(assetType)) {
            throw new RuntimeException("Asset type mismatch");
        }

        // Validate account status
        if (from.getLocked() || to.getLocked()) {
            throw new RuntimeException("One or both accounts are locked");
        }

        // Validate balance and limits
        BigDecimal newFromBalance = from.getBalance().subtract(amount);
        BigDecimal newToBalance = to.getBalance().add(amount);

        if (newFromBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient balance in source account");
        }

        if (from.getLowerLimit() != null && newFromBalance.compareTo(from.getLowerLimit()) < 0) {
            throw new RuntimeException("Transfer would breach lower limit of source account");
        }

        if (to.getUpperLimit() != null && newToBalance.compareTo(to.getUpperLimit()) > 0) {
            throw new RuntimeException("Transfer would breach upper limit of target account");
        }

        // Update balances
        from.setBalance(newFromBalance);
        to.setBalance(newToBalance);
        from.setVersion(from.getVersion() + 1);
        to.setVersion(to.getVersion() + 1);

        accountMapper.updateById(from);
        accountMapper.updateById(to);

        // Record events
        LocalDateTime now = LocalDateTime.now();
        
        BalanceChangeEvent debitEvent = new BalanceChangeEvent();
        debitEvent.setAccountNumber(fromAccount);
        debitEvent.setTransactionId(transactionId);
        debitEvent.setAmount(amount.negate());
        debitEvent.setBalanceAfter(newFromBalance);
        debitEvent.setEventType("DEBIT");
        debitEvent.setAccountVersion(from.getVersion());
        debitEvent.setEventTime(now);
        eventMapper.insert(debitEvent);

        BalanceChangeEvent creditEvent = new BalanceChangeEvent();
        creditEvent.setAccountNumber(toAccount);
        creditEvent.setTransactionId(transactionId);
        creditEvent.setAmount(amount);
        creditEvent.setBalanceAfter(newToBalance);
        creditEvent.setEventType("CREDIT");
        creditEvent.setAccountVersion(to.getVersion());
        creditEvent.setEventTime(now);
        eventMapper.insert(creditEvent);

        // Record dedup
        dedupStore.record(transactionId);
    }
}
