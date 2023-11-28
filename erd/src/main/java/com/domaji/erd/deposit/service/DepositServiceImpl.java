package com.domaji.erd.deposit.service;

import com.domaji.erd.account.dao.AccountMapper;
import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.service.AccountService;
import com.domaji.erd.common.ResponseDTO;
import com.domaji.erd.deposit.dao.DepositMapper;
import com.domaji.erd.deposit.dto.DepositDTO;
import com.domaji.erd.deposit.dto.DepositDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService{

    private final DepositMapper depositMapper;
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Override
    @Transactional
    public int insertDeposit(DepositDTO deposit) {

        int result = depositMapper.insertDeposit(deposit);

        return result;
    }

    @Override
    @Transactional
    public ResponseDTO createDeposit(DepositDetailDTO depositDetail) {

        AccountDTO account = new AccountDTO();
        account.setBalance(depositDetail.getBalance());
        account.setCustomerCode(depositDetail.getCustomerCode());
        account.setAccountType(depositDetail.getAccountType());

        accountService.insertAccount(account);
        int sequence = accountMapper.getSequence();
        String accountCode = "ACC" + sequence;
        depositDetail.setAccountCode(accountCode);
        depositMapper.createDeposit(depositDetail);

        return new ResponseDTO(HttpStatus.CREATED, "예금 생성", null);
    }
}
