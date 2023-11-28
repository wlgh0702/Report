package com.domaji.erd.account.controller;

import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.dto.TransactionDTO;
import com.domaji.erd.account.service.AccountService;
import com.domaji.erd.common.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertAccount(@RequestBody AccountDTO account) {

        ResponseDTO responseDTO = accountService.insertAccount(account);

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/myAccount/{customerCode}")
    public ResponseEntity<?> myAccount(@PathVariable String customerCode) {

        List<AccountDTO> accountList = accountService.myAccount(customerCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "내 계좌", accountList));
    }

    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody TransactionDTO transaction) {

        ResponseDTO response = accountService.payment(transaction);

        return ResponseEntity.ok().body(response);
    }

}
