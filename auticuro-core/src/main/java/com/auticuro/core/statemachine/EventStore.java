package com.auticuro.core.statemachine;

import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.core.mapper.BalanceChangeEventMapper;
import com.auticuro.proto.TransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class EventStore {
    private final BalanceChangeEventMapper eventMapper;
    private final ObjectMapper objectMapper;

    public EventStore(BalanceChangeEventMapper eventMapper, ObjectMapper objectMapper) {
        this.eventMapper = eventMapper;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public void recordTransfer(TransferRequest request, boolean success) {
        // Record debit event
        BalanceChangeEvent debitEvent = new BalanceChangeEvent();
        debitEvent.setAccountNumber(request.getFromAccount());
        debitEvent.setTransactionId(request.getTransactionId());
        debitEvent.setAmount(new BigDecimal(request.getAmount()).negate());
        debitEvent.setEventType("DEBIT");
        debitEvent.setEventTime(LocalDateTime.now());
        try {
            debitEvent.setMetadata(objectMapper.writeValueAsString(request));
        } catch (Exception e) {
            debitEvent.setMetadata("{}");
        }
        eventMapper.insert(debitEvent);

        // Record credit event
        BalanceChangeEvent creditEvent = new BalanceChangeEvent();
        creditEvent.setAccountNumber(request.getToAccount());
        creditEvent.setTransactionId(request.getTransactionId());
        creditEvent.setAmount(new BigDecimal(request.getAmount()));
        creditEvent.setEventType("CREDIT");
        creditEvent.setEventTime(LocalDateTime.now());
        try {
            creditEvent.setMetadata(objectMapper.writeValueAsString(request));
        } catch (Exception e) {
            creditEvent.setMetadata("{}");
        }
        eventMapper.insert(creditEvent);
    }
}
