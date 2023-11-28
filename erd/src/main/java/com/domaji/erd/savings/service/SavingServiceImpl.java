package com.domaji.erd.savings.service;

import com.domaji.erd.account.dao.AccountMapper;
import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.service.AccountService;
import com.domaji.erd.savings.dao.SavingsMapper;
import com.domaji.erd.savings.dto.SavingDTO;
import com.domaji.erd.savings.dto.SavingsDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SavingServiceImpl implements SavingsService{

    private final SavingsMapper savingsMapper;
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public int insertSavings(SavingDTO saving) {

        int result = savingsMapper.insertSavings(saving);

        return result;
    }

    @Override
    @Transactional
    public void createSavings(SavingsDetailDTO detail) {

        AccountDTO account = new AccountDTO();
        account.setCustomerCode(detail.getCustomerCode());
        account.setAccountType(detail.getAccountType());
        account.setBalance(detail.getBalance());

        accountService.insertAccount(account);
        int sequence = accountMapper.getSequence();
        detail.setAccountCode("ACC" + sequence);

        savingsMapper.createSavings(detail);
    }
}
