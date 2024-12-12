package com.auticuro.server.query.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("account_balance_views")
public class AccountBalanceView {
    private String accountNumber;
    private BigDecimal balance;
    private Integer version;
    private LocalDateTime lastUpdated;
}
