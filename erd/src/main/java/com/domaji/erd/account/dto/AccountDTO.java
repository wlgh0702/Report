package com.domaji.erd.account.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AccountDTO {

    private String accountCode;
    private int balance;
    private Date openingDate;
    private String accountStatus;
    private String customerCode;
    private String accountType;
    private String accountNumber;
}
