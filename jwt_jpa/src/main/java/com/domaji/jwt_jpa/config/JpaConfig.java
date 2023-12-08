package com.domaji.jwt_jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.domaji.jwt_jpa")
@EnableJpaRepositories(basePackages = "com.domaji.jwt_jpa")
public class JpaConfig {
}
