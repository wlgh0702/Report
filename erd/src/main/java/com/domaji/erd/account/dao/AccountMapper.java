package com.domaji.erd.account.dao;

import com.domaji.erd.account.dto.AccountDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountMapper {
    int countAccountNum(String accNum);

    void insertAccount(AccountDTO account);

    int getSequence();

    List<AccountDTO> myAccount(String customerCode);

    int getBalance(String accountCode);

    void payment(Map<String, Object> map);
}
