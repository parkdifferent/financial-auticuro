package com.auticuro.server.query.service;

import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.core.mapper.BalanceChangeEventMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BalanceHistoryService {
    
    @Autowired
    private BalanceChangeEventMapper eventMapper;

    public Page<BalanceChangeEvent> getBalanceHistory(
            String accountNumber,
            LocalDateTime startTime,
            LocalDateTime endTime,
            int pageNum,
            int pageSize) {
        
        QueryWrapper<BalanceChangeEvent> wrapper = new QueryWrapper<>();
        wrapper.eq("account_number", accountNumber)
              .ge(startTime != null, "event_time", startTime)
              .le(endTime != null, "event_time", endTime)
              .orderByDesc("event_time");

        return eventMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    public List<BalanceChangeEvent> getTransactionEvents(String transactionId) {
        QueryWrapper<BalanceChangeEvent> wrapper = new QueryWrapper<>();
        wrapper.eq("transaction_id", transactionId)
              .orderByAsc("event_time");

        return eventMapper.selectList(wrapper);
    }
}
