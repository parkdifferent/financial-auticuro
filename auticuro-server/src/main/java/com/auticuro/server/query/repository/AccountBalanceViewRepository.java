package com.auticuro.server.query.repository;

import com.auticuro.server.query.model.AccountBalanceView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface AccountBalanceViewRepository extends BaseMapper<AccountBalanceView> {
    
    @Select("SELECT * FROM account_balance_views WHERE account_number = #{accountNumber}")
    Optional<AccountBalanceView> findByAccountNumber(String accountNumber);
    
    @Select("SELECT * FROM account_balance_views WHERE account_number = #{accountNumber} AND version <= #{version} ORDER BY version DESC LIMIT 1")
    Optional<AccountBalanceView> findByAccountNumberAndVersion(String accountNumber, Integer version);
}
