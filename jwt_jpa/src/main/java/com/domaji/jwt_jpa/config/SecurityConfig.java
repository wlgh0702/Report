package com.domaji.jwt_jpa.config;

import com.domaji.jwt_jpa.jwt.JwtAccessDeniedHandler;
import com.domaji.jwt_jpa.jwt.JwtAuthenticationEntryPoint;
import com.domaji.jwt_jpa.jwt.TokenProvider;

public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint
                        , JwtAccessDeniedHandler jwtAccessDeniedHandler) {

        this.tokenProvider = tokenProvider;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }
}
