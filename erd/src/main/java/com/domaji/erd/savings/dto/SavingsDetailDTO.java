package com.domaji.erd.savings.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SavingsDetailDTO {
    
    private int balance;
    private Date openingDate;
    private String accountStatus;
    private String customerCode;
    private String accountType;
    private String accountNumber;
    private int savingsAmount;
    private Date savingsStartDate;
    private Date savingsExpiryDate;
    private String savingsStatus;
    private String accountCode;
    private String savingsCode;
}
