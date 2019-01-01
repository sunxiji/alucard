package com.alucard;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableApolloConfig
@EnableEurekaClient
@SpringBootApplication
public class ApolloDemoApplication {
    /**
     * server.properties
     * #这里是取得哪个环境
     * env=DEV
     * #这里是指使用哪个集群文件
     * idc=alu1
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ApolloDemoApplication.class, args);
    }

}

