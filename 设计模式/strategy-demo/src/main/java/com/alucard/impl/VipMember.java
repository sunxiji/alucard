package com.alucard.impl;

import com.alucard.intf.Strategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:32 2018/10/17
 */
@Component("vipMember")
public class VipMember implements Strategy {
    @Override
    public BigDecimal calculatePrice() {
        // VIP会员打8折
        return new BigDecimal("80");
    }
}
