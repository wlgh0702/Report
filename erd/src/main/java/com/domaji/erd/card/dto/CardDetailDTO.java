package com.domaji.erd.card.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CardDetailDTO {

    private String cardNumber;
    private Date expirationDate;
    private int cvc;
    private Date issuanceDate;
    private String cardStatus;
    private int creditLimit;
    private int totalAmountUsed;
    private Date paymentDate;
    private String accountCode;
    private String customerCode;
    private String cardCode;
}
