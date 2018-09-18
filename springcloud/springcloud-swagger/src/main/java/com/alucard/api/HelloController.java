package com.alucard.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:44 2018/9/18
 */
@Api(value = "微服务API", tags = "微服务API")
@RestController
public class HelloController {

    @ApiOperation(value = "hello 方法", notes = "hello 方法")
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
