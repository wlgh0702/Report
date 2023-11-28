package com.domaji.erd.account.service;

import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.dto.TransactionDTO;
import com.domaji.erd.common.ResponseDTO;

import java.util.List;

public interface AccountService {
    ResponseDTO insertAccount(AccountDTO account);

    List<AccountDTO> myAccount(String customerCode);

    ResponseDTO payment(TransactionDTO transaction);
}
