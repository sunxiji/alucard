package com.alucard;

import com.alucard.filter.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class, args);
    }

    // 开启过滤器方式
//    @Bean
    public FilterRegistrationBean registerFilter(){
        System.out.println("registerFilter-------->");
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.addUrlPatterns("/*");

        bean.setFilter(new CrosFilter());
        return bean;
    }
}
