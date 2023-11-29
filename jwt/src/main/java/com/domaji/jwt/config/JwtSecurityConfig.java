package com.domaji.jwt.config;

import com.domaji.jwt.jwt.JwtFilter;
import com.domaji.jwt.jwt.TokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;

    public JwtSecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtFilter customFilter = new JwtFilter(tokenProvider);      // JwtFilter를 jwt패키지에 추가
        builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);  // JwtFilter를 FilterChain 상에 추가
    }
}
