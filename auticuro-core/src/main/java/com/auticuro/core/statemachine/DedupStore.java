package com.auticuro.core.statemachine;

import com.auticuro.core.entity.DedupRecord;
import com.auticuro.core.mapper.DedupRecordMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DedupStore {
    private final Set<String> dedupCache;
    private final DedupRecordMapper dedupRecordMapper;

    public DedupStore(DedupRecordMapper dedupRecordMapper) {
        this.dedupRecordMapper = dedupRecordMapper;
        this.dedupCache = ConcurrentHashMap.newKeySet();
        initializeCache();
    }

    private void initializeCache() {
        // Load recent dedup records (e.g., last 24 hours)
        LocalDateTime cutoff = LocalDateTime.now().minusHours(24);
        QueryWrapper<DedupRecord> wrapper = new QueryWrapper<>();
        wrapper.ge("create_time", cutoff);
        
        dedupRecordMapper.selectList(wrapper)
            .forEach(record -> dedupCache.add(record.getTransactionId()));
    }

    public boolean isDuplicate(String transactionId) {
        return dedupCache.contains(transactionId);
    }

    @Transactional
    public void record(String transactionId) {
        // Add to database
        DedupRecord record = new DedupRecord();
        record.setTransactionId(transactionId);
        record.setCreateTime(LocalDateTime.now());
        dedupRecordMapper.insert(record);

        // Add to cache
        dedupCache.add(transactionId);
    }

    public void cleanup() {
        // Remove old records (e.g., older than 24 hours)
        LocalDateTime cutoff = LocalDateTime.now().minusHours(24);
        QueryWrapper<DedupRecord> wrapper = new QueryWrapper<>();
        wrapper.lt("create_time", cutoff);
        dedupRecordMapper.delete(wrapper);

        // Refresh cache
        dedupCache.clear();
        initializeCache();
    }
}
