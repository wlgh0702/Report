package com.domaji.erd.savings.controller;

import com.domaji.erd.common.ResponseDTO;
import com.domaji.erd.savings.dto.SavingDTO;
import com.domaji.erd.savings.dto.SavingsDetailDTO;
import com.domaji.erd.savings.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final SavingsService savingsService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertSavings(@RequestBody SavingDTO saving) {

        int result = savingsService.insertSavings(saving);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "insert 성공", null));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSavings(@RequestBody SavingsDetailDTO detail) {

        savingsService.createSavings(detail);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "create 성공", null));
    }
}
