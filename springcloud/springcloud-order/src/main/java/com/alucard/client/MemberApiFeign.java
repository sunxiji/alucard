package com.alucard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:13 2018/9/18
 */
// name 指定服务名称
@FeignClient(name = "alucard-member")
public interface MemberApiFeign {
    @GetMapping("/getMember")
    String getMember();
}
