package com.alucard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@MapperScan({"com.alucard.mapper"})
@SpringBootApplication
public class ShardingJdbcDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcDemo2Application.class, args);
    }
}
