package com.alucard.api.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alucard.api.service.MemberService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:34 2018/9/21
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getMemberInfo(String name) {
        return "当前端口号是:[" + serverPort + "],会员名是:[" + name+"]";
    }
}
