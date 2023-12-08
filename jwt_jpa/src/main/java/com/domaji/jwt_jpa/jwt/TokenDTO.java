package com.domaji.jwt_jpa.jwt;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TokenDTO {

    private String grantType;
    private String memberName;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}
