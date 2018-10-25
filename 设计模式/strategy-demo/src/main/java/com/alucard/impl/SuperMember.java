package com.alucard.impl;

import com.alucard.intf.Strategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:33 2018/10/17
 */
@Component("superMember")
public class SuperMember implements Strategy {
    @Override
    public BigDecimal calculatePrice() {
        // 超级会员打1折
        return new BigDecimal("10");
    }
}
