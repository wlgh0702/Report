package com.domaji.erd.account.service;

import com.domaji.erd.account.dao.AccountMapper;
import com.domaji.erd.account.dao.TransactionMapper;
import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.dto.TransactionDTO;
import com.domaji.erd.common.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public ResponseDTO insertAccount(AccountDTO account) {

        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.BAD_REQUEST, "insert 실패", null);

        // 계좌번호 생성
        StringBuilder sb = new StringBuilder();

        sb.append(((int) (Math.random() * 999999)));
        sb.append("-");
        sb.append(((int) (Math.random() * 99)));
        sb.append("-");
        sb.append(((int) (Math.random() * 999999)));
        String accNum = sb.toString();
        int count = accountMapper.countAccountNum(accNum);

        // 계좌번호가 중복되지 않았을 때
        if(count == 0) {
            account.setAccountNumber(String.valueOf(sb));
            accountMapper.insertAccount(account);
            responseDTO.setStatus(HttpStatus.CREATED.value());
            responseDTO.setMessage("insert 성공");
        }

        return responseDTO;
    }

    @Override
    public List<AccountDTO> myAccount(String customerCode) {

        List<AccountDTO> accountList = accountMapper.myAccount(customerCode);

        return accountList;
    }

    @Override
    @Transactional
    public ResponseDTO payment(TransactionDTO transaction) {

        int amount = transaction.getTransactionAmount();
        String accountCode = transaction.getAccountCode();

        int balance = accountMapper.getBalance(accountCode);
        if(balance >= amount) {
            Map<String, Object> map = new HashMap<>();
            map.put("amount", amount);
            map.put("accountCode", accountCode);
            transactionMapper.payment(transaction);
            accountMapper.payment(map);
            return new ResponseDTO(HttpStatus.CREATED, "결제 성공", null);
        } else {
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "잔액 부족", null);
        }

    }
}
