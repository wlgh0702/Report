package com.domaji.erd.deposit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepositDetailDTO {

    private int balance;
    private Date openingDate;
    private String accountStatus;
    private String customerCode;
    private String accountType;
    private String accountNumber;
    private String depositCode;
    private String accountCode;
    private int depositAmount;
    private Date depositStartDate;
    private Date depositExpiryDate;
    private String depositStatus;
}
