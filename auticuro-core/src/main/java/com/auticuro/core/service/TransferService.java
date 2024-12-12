package com.auticuro.core.service;

import java.math.BigDecimal;
import java.util.Map;

public interface TransferService {
    void transfer(String transactionId, String fromAccount, String toAccount, 
                 BigDecimal amount, String assetType, Map<String, String> metadata);
}
