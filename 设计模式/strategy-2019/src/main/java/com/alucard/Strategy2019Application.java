package com.alucard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alucard.mapper")
public class Strategy2019Application {

    public static void main(String[] args) {
        SpringApplication.run(Strategy2019Application.class, args);
    }

}
