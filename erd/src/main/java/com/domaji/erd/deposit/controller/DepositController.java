package com.domaji.erd.deposit.controller;

import com.domaji.erd.account.dto.AccountDTO;
import com.domaji.erd.account.service.AccountService;
import com.domaji.erd.common.ResponseDTO;
import com.domaji.erd.deposit.dto.DepositDTO;
import com.domaji.erd.deposit.dto.DepositDetailDTO;
import com.domaji.erd.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    // 예금 생성
    @PostMapping("/insert")
    public ResponseEntity<?> insertDeposit(@RequestBody DepositDTO deposit) {

        depositService.insertDeposit(deposit);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "insert 성공", null));
    }

    // 회원이 예금 생성
    @PostMapping("/create")
    public ResponseEntity<?> createDeposit(@RequestBody DepositDetailDTO depositDetail) {

        ResponseDTO response = depositService.createDeposit(depositDetail);

        return ResponseEntity.ok().body(response);
    }
}
