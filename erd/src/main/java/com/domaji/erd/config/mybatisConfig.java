package com.domaji.erd.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.domaji.erd", annotationClass = Mapper.class)
public class mybatisConfig {
}
