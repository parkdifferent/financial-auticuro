package com.auticuro.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("dedup_records")
public class DedupRecord {
    @TableId
    private String transactionId;
    private LocalDateTime createTime;
}
