package com.auticuro.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("balance_change_events")
public class BalanceChangeEvent {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String accountNumber;
    
    private String transactionId;
    
    private BigDecimal amount;
    
    private BigDecimal balanceAfter;
    
    private String eventType;
    
    private Integer accountVersion;
    
    private LocalDateTime eventTime;
    
    private String metadata;
}
