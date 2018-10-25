package com.alucard.intf;

import java.math.BigDecimal;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:30 2018/10/17
 */
public interface Strategy {
    /**
     * 计算价格
     * @return
     */
    BigDecimal calculatePrice();
}
