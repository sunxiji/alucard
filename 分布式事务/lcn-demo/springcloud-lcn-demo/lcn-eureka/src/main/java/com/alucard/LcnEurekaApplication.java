package com.alucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LcnEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcnEurekaApplication.class, args);
    }
}
