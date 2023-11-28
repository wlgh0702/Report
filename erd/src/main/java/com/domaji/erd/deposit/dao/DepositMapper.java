package com.domaji.erd.deposit.dao;

import com.domaji.erd.deposit.dto.DepositDTO;
import com.domaji.erd.deposit.dto.DepositDetailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepositMapper {
    int insertDeposit(DepositDTO deposit);

    void createDeposit(DepositDetailDTO depositDetail);
}
