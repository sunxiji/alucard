package com.alucard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.alucard.mapper"})
@SpringBootApplication
public class MybatisPluginSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPluginSpringbootApplication.class, args);
    }
}
