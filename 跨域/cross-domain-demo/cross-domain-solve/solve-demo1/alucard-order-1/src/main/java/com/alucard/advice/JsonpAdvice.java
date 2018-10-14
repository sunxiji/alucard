package com.alucard.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/web.html#mvc-cors
 * As of Spring Framework 5.0.7,
 * JSONP support is deprecated and will be removed as of
 * Spring Framework 5.1, CORS should be used instead.
 */
// 开启jsonp方式
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice(){
        super("callback");
        System.out.println("JsonpAdvice--------->");
    }
}
