package com.auticuro.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("accounts")
public class Account {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String accountNumber;
    
    private String assetType;
    
    private BigDecimal balance;
    
    private BigDecimal upperLimit;
    
    private BigDecimal lowerLimit;
    
    private Boolean locked;
    
    @Version
    private Integer version;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}
