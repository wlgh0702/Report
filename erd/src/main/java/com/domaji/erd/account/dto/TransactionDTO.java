package com.domaji.erd.account.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TransactionDTO {

    private String transactionCode;
    private String transactionType;
    private int transactionAmount;
    private String transactionDate;
    private String transactionDescript;
    private String accountCode;

}
