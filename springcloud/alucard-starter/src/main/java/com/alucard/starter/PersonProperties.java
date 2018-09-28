package com.alucard.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "spring.person")
public class PersonProperties {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private String sex = "M";

} 
