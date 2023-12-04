package com.domaji.jwt.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AuthorityDTO {

    private int authorityCode;
    private String authorityName;
    private String authorityDesc;
}
