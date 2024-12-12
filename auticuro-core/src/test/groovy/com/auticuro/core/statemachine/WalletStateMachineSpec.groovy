package com.auticuro.core.statemachine

import com.auticuro.core.exception.AccountLockedException
import com.auticuro.core.exception.BalanceLimitException
import com.auticuro.core.exception.InsufficientBalanceException
import com.auticuro.proto.TransferRequest
import com.auticuro.proto.TransferResponse
import org.apache.ratis.protocol.Message
import org.apache.ratis.statemachine.TransactionContext
import spock.lang.Specification

import java.math.BigDecimal
import java.util.concurrent.CompletableFuture

class WalletStateMachineSpec extends Specification {

    WalletStateMachine walletStateMachine = new WalletStateMachine()

    def setup() {
        walletStateMachine.dedupStore = Mock(DedupStore)
        walletStateMachine.balanceMap = Mock(BalanceMap)
        walletStateMachine.eventStore = Mock(EventStore)
    }

    def "test duplicate transaction"() {
        given: "A duplicate transaction request"
        TransferRequest request = TransferRequest.newBuilder()
            .setTransactionId("duplicate-id")
            .setFromAccount("account1")
            .setToAccount("account2")
            .setAmount("100.00")
            .build()

        walletStateMachine.dedupStore.record("duplicate-id")

        when: "The transaction is applied"
        CompletableFuture<Message> result = walletStateMachine.applyTransaction(Mock(TransactionContext) {
            getLogEntry() >> Mock(LogEntryProto) {
                getStateMachineLogEntry() >> Mock(LogEntryProto.StateMachineLogEntryProto) {
                    getLogData() >> request.toByteString()
                }
            }
        })

        then: "A duplicate transaction message is returned"
        result.get().toString().contains("Duplicate transaction")
    }

    def "test locked account"() {
        given: "A transaction request with a locked account"
        TransferRequest request = TransferRequest.newBuilder()
            .setTransactionId("trans-id")
            .setFromAccount("locked-account")
            .setToAccount("account2")
            .setAmount("100.00")
            .build()

        walletStateMachine.balanceMap.lock("locked-account")

        when: "The transaction is applied"
        CompletableFuture<Message> result = walletStateMachine.applyTransaction(Mock(TransactionContext) {
            getLogEntry() >> Mock(LogEntryProto) {
                getStateMachineLogEntry() >> Mock(LogEntryProto.StateMachineLogEntryProto) {
                    getLogData() >> request.toByteString()
                }
            }
        })

        then: "An AccountLockedException is thrown"
        thrown(AccountLockedException)
    }

    def "test insufficient balance"() {
        given: "A transaction request with insufficient balance"
        TransferRequest request = TransferRequest.newBuilder()
            .setTransactionId("trans-id")
            .setFromAccount("account1")
            .setToAccount("account2")
            .setAmount("1000.00")
            .build()

        walletStateMachine.balanceMap.setBalance("account1", new BigDecimal("100.00"))

        when: "The transaction is applied"
        CompletableFuture<Message> result = walletStateMachine.applyTransaction(Mock(TransactionContext) {
            getLogEntry() >> Mock(LogEntryProto) {
                getStateMachineLogEntry() >> Mock(LogEntryProto.StateMachineLogEntryProto) {
                    getLogData() >> request.toByteString()
                }
            }
        })

        then: "An InsufficientBalanceException is thrown"
        thrown(InsufficientBalanceException)
    }

    def "test successful transfer"() {
        given: "A valid transaction request"
        TransferRequest request = TransferRequest.newBuilder()
            .setTransactionId("trans-id")
            .setFromAccount("account1")
            .setToAccount("account2")
            .setAmount("100.00")
            .build()

        walletStateMachine.balanceMap.setBalance("account1", new BigDecimal("200.00"))
        walletStateMachine.balanceMap.setBalance("account2", new BigDecimal("50.00"))

        when: "The transaction is applied"
        CompletableFuture<Message> result = walletStateMachine.applyTransaction(Mock(TransactionContext) {
            getLogEntry() >> Mock(LogEntryProto) {
                getStateMachineLogEntry() >> Mock(LogEntryProto.StateMachineLogEntryProto) {
                    getLogData() >> request.toByteString()
                }
            }
        })

        then: "The transfer is successful"
        result.get().toString().contains("Success")
    }
}
