package com.domaji.erd.deposit.service;

import com.domaji.erd.common.ResponseDTO;
import com.domaji.erd.deposit.dto.DepositDTO;
import com.domaji.erd.deposit.dto.DepositDetailDTO;

public interface DepositService {
    int insertDeposit(DepositDTO deposit);

    ResponseDTO createDeposit(DepositDetailDTO depositDetail);
}
