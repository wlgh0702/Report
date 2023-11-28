package com.domaji.erd.customer.controller;

import com.domaji.erd.common.ResponseDTO;
import com.domaji.erd.customer.dto.CustomerDTO;
import com.domaji.erd.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertCustomer(@RequestBody CustomerDTO customer) {

        int result = customerService.insertCustomer(customer);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "insert 성공", null));
    }

    @GetMapping("/list")
    public ResponseEntity<?> customerList() {

        List<CustomerDTO> customerList = customerService.getCustomerList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 리스트 출력", customerList));
    }

}
