package com.auticuro.server.controller;

import com.auticuro.core.entity.Account;
import com.auticuro.core.service.AccountService;
import com.auticuro.core.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransferService transferService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccount(accountNumber));
    }

    @PostMapping("/accounts/{accountNumber}/lock")
    public ResponseEntity<Void> lockAccount(@PathVariable String accountNumber) {
        accountService.lockAccount(accountNumber);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/accounts/{accountNumber}/unlock")
    public ResponseEntity<Void> unlockAccount(@PathVariable String accountNumber) {
        accountService.unlockAccount(accountNumber);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/accounts/{accountNumber}/limits")
    public ResponseEntity<Account> updateLimits(
            @PathVariable String accountNumber,
            @RequestParam(required = false) BigDecimal upperLimit,
            @RequestParam(required = false) BigDecimal lowerLimit) {
        return ResponseEntity.ok(accountService.updateLimits(accountNumber, upperLimit, lowerLimit));
    }

    @PostMapping("/transfers")
    public ResponseEntity<Map<String, Object>> transfer(@RequestBody Map<String, Object> request) {
        String transactionId = (String) request.get("transactionId");
        String fromAccount = (String) request.get("fromAccount");
        String toAccount = (String) request.get("toAccount");
        BigDecimal amount = new BigDecimal(request.get("amount").toString());
        String assetType = (String) request.get("assetType");
        @SuppressWarnings("unchecked")
        Map<String, String> metadata = (Map<String, String>) request.get("metadata");

        transferService.transfer(transactionId, fromAccount, toAccount, amount, assetType, metadata);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("transactionId", transactionId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/transfers/batch")
    public ResponseEntity<Map<String, Object>> batchTransfer(@RequestBody Map<String, Object> request) {
        String batchId = (String) request.get("batchId");
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> transfers = (List<Map<String, Object>>) request.get("transfers");

        List<Map<String, Object>> results = new ArrayList<>();
        for (Map<String, Object> transfer : transfers) {
            Map<String, Object> result = new HashMap<>();
            try {
                transferService.transfer(
                    (String) transfer.get("transactionId"),
                    (String) transfer.get("fromAccount"),
                    (String) transfer.get("toAccount"),
                    new BigDecimal(transfer.get("amount").toString()),
                    (String) transfer.get("assetType"),
                    (Map<String, String>) transfer.get("metadata")
                );
                result.put("success", true);
                result.put("transactionId", transfer.get("transactionId"));
            } catch (Exception e) {
                result.put("success", false);
                result.put("transactionId", transfer.get("transactionId"));
                result.put("error", e.getMessage());
            }
            results.add(result);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("batchId", batchId);
        response.put("results", results);
        return ResponseEntity.ok(response);
    }
}
