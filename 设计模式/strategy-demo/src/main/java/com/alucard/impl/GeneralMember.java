package com.alucard.impl;

import com.alucard.intf.Strategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:31 2018/10/17
 */
@Component("generalMember")
public class GeneralMember implements Strategy {

    @Override
    public BigDecimal calculatePrice() {
        // 普通会员没有折扣，直接返回原价
        return new BigDecimal("100");
    }
}
