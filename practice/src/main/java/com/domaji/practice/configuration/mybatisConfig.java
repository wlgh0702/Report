package com.domaji.practice.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.domaji.practice", annotationClass = Mapper.class)
public class mybatisConfig {
}
