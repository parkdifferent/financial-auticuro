package com.auticuro.core.statemachine;

import com.auticuro.core.entity.Account;
import com.auticuro.core.exception.InsufficientBalanceException;
import com.auticuro.core.exception.AccountLockedException;
import com.auticuro.core.exception.BalanceLimitException;
import com.auticuro.core.mapper.AccountMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceMap {
    private final ConcurrentHashMap<String, Account> accountCache;
    private final AccountMapper accountMapper;

    public BalanceMap(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
        this.accountCache = new ConcurrentHashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountCache.computeIfAbsent(accountNumber, key -> {
            QueryWrapper<Account> wrapper = new QueryWrapper<>();
            wrapper.eq("account_number", key);
            return accountMapper.selectOne(wrapper);
        });
    }

    public boolean isLocked(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account != null && account.getLocked();
    }

    public BigDecimal getBalance(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account != null ? account.getBalance() : BigDecimal.ZERO;
    }

    public BigDecimal getLowerLimit(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account != null ? account.getLowerLimit() : null;
    }

    public BigDecimal getUpperLimit(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account != null ? account.getUpperLimit() : null;
    }

    @Transactional
    public void updateBalance(String accountNumber, BigDecimal newBalance) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            validateAccount(account, newBalance.subtract(account.getBalance()));
            account.setBalance(newBalance);
            accountMapper.updateById(account);
            accountCache.put(accountNumber, account);
        }
    }

    @Transactional
    public void transfer(String fromAccount, String toAccount, BigDecimal amount) {
        Account from = getAccount(fromAccount);
        Account to = getAccount(toAccount);

        // Validate accounts
        validateAccount(from, amount.negate());
        validateAccount(to, amount);

        // Update balances
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        // Update in database
        accountMapper.updateById(from);
        accountMapper.updateById(to);

        // Update cache
        accountCache.put(fromAccount, from);
        accountCache.put(toAccount, to);
    }

    private void validateAccount(Account account, BigDecimal changeAmount) {
        if (account.getLocked()) {
            throw new AccountLockedException("Account is locked: " + account.getAccountNumber());
        }

        BigDecimal newBalance = account.getBalance().add(changeAmount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Insufficient balance in account: " + account.getAccountNumber());
        }

        if (account.getUpperLimit() != null && newBalance.compareTo(account.getUpperLimit()) > 0) {
            throw new BalanceLimitException("Balance would exceed upper limit for account: " + account.getAccountNumber());
        }

        if (account.getLowerLimit() != null && newBalance.compareTo(account.getLowerLimit()) < 0) {
            throw new BalanceLimitException("Balance would fall below lower limit for account: " + account.getAccountNumber());
        }
    }
}
