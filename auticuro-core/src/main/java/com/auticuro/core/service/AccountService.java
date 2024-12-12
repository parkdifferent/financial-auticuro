package com.auticuro.core.service;

import com.auticuro.core.entity.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccount(String accountNumber);
    void lockAccount(String accountNumber);
    void unlockAccount(String accountNumber);
    Account updateLimits(String accountNumber, BigDecimal upperLimit, BigDecimal lowerLimit);
}
