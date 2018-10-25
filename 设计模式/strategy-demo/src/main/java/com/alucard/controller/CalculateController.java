package com.alucard.controller;

import com.alucard.impl.StrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:40 2018/10/17
 */
@RestController
public class CalculateController {
    @Autowired
    private StrategyContext strategyContext;

    @GetMapping("calculatePrice")
    public BigDecimal calculatePrice(String memberLevel){
        return strategyContext.calculatePrice(memberLevel);
    }
}
