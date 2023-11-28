package com.domaji.erd.customer.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private String customerCode;
    private String customerName;
    private char gender;
    private String customerDob;
    private String address;
    private String phone;
    private String email;
    private Date customerRegDate;
    private String rrn;
    private String id;
    private String pwd;
}
