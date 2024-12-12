package com.auticuro.server.query.controller;

import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.server.query.model.AccountBalanceView;
import com.auticuro.server.query.repository.AccountBalanceViewRepository;
import com.auticuro.server.query.service.BalanceHistoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/query")
public class QueryController {

    @Autowired
    private BalanceHistoryService balanceHistoryService;

    @Autowired
    private AccountBalanceViewRepository balanceViewRepository;

    @GetMapping("/accounts/{accountNumber}/balance")
    public ResponseEntity<AccountBalanceView> getBalance(@PathVariable String accountNumber) {
        return ResponseEntity.ok(
            balanceViewRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found: " + accountNumber))
        );
    }

    @GetMapping("/accounts/{accountNumber}/balance/history")
    public ResponseEntity<Page<BalanceChangeEvent>> getBalanceHistory(
            @PathVariable String accountNumber,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize) {
        
        return ResponseEntity.ok(
            balanceHistoryService.getBalanceHistory(accountNumber, startTime, endTime, pageNum, pageSize)
        );
    }

    @GetMapping("/transactions/{transactionId}")
    public ResponseEntity<List<BalanceChangeEvent>> getTransactionEvents(@PathVariable String transactionId) {
        return ResponseEntity.ok(
            balanceHistoryService.getTransactionEvents(transactionId)
        );
    }

    @GetMapping("/accounts/{accountNumber}/balance/at")
    public ResponseEntity<AccountBalanceView> getBalanceAtVersion(
            @PathVariable String accountNumber,
            @RequestParam Integer version) {
        
        return ResponseEntity.ok(
            balanceViewRepository.findByAccountNumberAndVersion(accountNumber, version)
                .orElseThrow(() -> new RuntimeException(
                    String.format("Balance not found for account %s at version %d", accountNumber, version)))
        );
    }
}
