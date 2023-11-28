package com.domaji.erd.savings.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SavingDTO {

    private String savingsCode;
    private String savingsName;
    private float interestRate;
}
