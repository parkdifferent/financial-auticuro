package com.auticuro.server.query;

import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.server.query.model.AccountBalanceView;
import com.auticuro.server.query.repository.AccountBalanceViewRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class MaterializedViewUpdater {
    
    @Autowired
    private AccountBalanceViewRepository viewRepository;

    @Transactional
    public void processEvent(BalanceChangeEvent event) {
        QueryWrapper<AccountBalanceView> wrapper = new QueryWrapper<>();
        wrapper.eq("account_number", event.getAccountNumber());
        
        AccountBalanceView view = viewRepository.selectOne(wrapper);
        if (view == null) {
            view = new AccountBalanceView();
            view.setAccountNumber(event.getAccountNumber());
            view.setBalance(BigDecimal.ZERO);
            view.setVersion(0);
        }

        // Update balance based on event type
        if ("CREDIT".equals(event.getEventType())) {
            view.setBalance(view.getBalance().add(event.getAmount()));
        } else if ("DEBIT".equals(event.getEventType())) {
            view.setBalance(view.getBalance().subtract(event.getAmount().abs()));
        }

        // Update version and save
        view.setVersion(event.getAccountVersion());
        view.setLastUpdated(event.getEventTime());
        
        if (view.getVersion() == 0) {
            viewRepository.insert(view);
        } else {
            viewRepository.updateById(view);
        }
    }
}
