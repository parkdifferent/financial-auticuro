package com.auticuro.core.service.impl;

import com.auticuro.core.entity.Account;
import com.auticuro.core.mapper.AccountMapper;
import com.auticuro.core.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public Account createAccount(Account account) {
        // Validate account number uniqueness
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("account_number", account.getAccountNumber());
        if (accountMapper.selectCount(wrapper) > 0) {
            throw new RuntimeException("Account already exists: " + account.getAccountNumber());
        }

        // Set default values
        account.setBalance(BigDecimal.ZERO);
        account.setLocked(false);
        account.setVersion(0);
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());

        accountMapper.insert(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("account_number", accountNumber);
        Account account = accountMapper.selectOne(wrapper);
        if (account == null) {
            throw new RuntimeException("Account not found: " + accountNumber);
        }
        return account;
    }

    @Override
    @Transactional
    public void lockAccount(String accountNumber) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("account_number", accountNumber)
               .set("locked", true)
               .set("update_time", LocalDateTime.now());
        if (accountMapper.update(null, wrapper) == 0) {
            throw new RuntimeException("Account not found: " + accountNumber);
        }
    }

    @Override
    @Transactional
    public void unlockAccount(String accountNumber) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("account_number", accountNumber)
               .set("locked", false)
               .set("update_time", LocalDateTime.now());
        if (accountMapper.update(null, wrapper) == 0) {
            throw new RuntimeException("Account not found: " + accountNumber);
        }
    }

    @Override
    @Transactional
    public Account updateLimits(String accountNumber, BigDecimal upperLimit, BigDecimal lowerLimit) {
        Account account = getAccount(accountNumber);
        
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("account_number", accountNumber)
               .set(upperLimit != null, "upper_limit", upperLimit)
               .set(lowerLimit != null, "lower_limit", lowerLimit)
               .set("update_time", LocalDateTime.now());
        
        accountMapper.update(null, wrapper);
        return getAccount(accountNumber);
    }
}
