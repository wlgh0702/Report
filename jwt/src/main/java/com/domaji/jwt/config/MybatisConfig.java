package com.domaji.jwt.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.domaji.jwt", annotationClass = Mapper.class)
public class MybatisConfig {
}
