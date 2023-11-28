package com.domaji.erd.deposit.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepositDTO {

    private String depositCode;
    private String depositName;
    private float interestRate;
}
