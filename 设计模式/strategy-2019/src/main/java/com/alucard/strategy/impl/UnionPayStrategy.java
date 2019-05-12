package com.alucard.strategy.impl;

import com.alucard.strategy.PayStrategy;
import org.springframework.stereotype.Component;


@Component
public class UnionPayStrategy implements PayStrategy {

    @Override
    public String toPayHtml() {
        return "调用银联接口...UnionPayStrategy";
    }
}
