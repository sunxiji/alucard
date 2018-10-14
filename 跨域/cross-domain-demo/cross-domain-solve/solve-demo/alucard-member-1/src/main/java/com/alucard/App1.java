package com.alucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }


}
