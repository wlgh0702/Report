package com.domaji.jwt.jwt;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TokenDTO {

    private String grantType;       // 토큰 타입
    private String memberCode;      // 인증받은 회원코드
    private String accessToken;     // 엑세스 토큰
    private String refreshToken;    // 리프레시 토큰
    private Long accessTokenExpiresIn;  // Long형의 만료 시간
}
