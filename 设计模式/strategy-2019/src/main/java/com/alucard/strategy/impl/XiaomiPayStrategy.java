package com.alucard.strategy.impl;

import com.alucard.strategy.PayStrategy;
import org.springframework.stereotype.Component;


@Component
public class XiaomiPayStrategy implements PayStrategy {

    @Override
    public String toPayHtml() {
        return "调用小米接口...XiaomiPayStrategy";
    }
}
