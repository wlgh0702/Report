package com.domaji.erd.card.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CardDTO {

    private String cardCode;
    private String cardName;
    private int annualFee;
    private String cardType;
    private String benefit;
}
