package com.alucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnnotationRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationRedisApplication.class, args);
    }
}
