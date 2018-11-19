package com.alucard.config;

import com.alucard.interceptor.MyPageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfiguration {
    @Bean
    public MyPageInterceptor sqlStatsInterceptor() {
        MyPageInterceptor sqlStatsInterceptor = new MyPageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        sqlStatsInterceptor.setProperties(properties);
        return sqlStatsInterceptor;
    }
}  