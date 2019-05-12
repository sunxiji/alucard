package com.alucard.strategy.impl;

import com.alucard.strategy.PayStrategy;
import org.springframework.stereotype.Component;


@Component
public class AliPayStrategy implements PayStrategy {
    // <bean id="aliPayStrategy" class="com.alucard.strategy.impl.AliPayStrategy">
    // 使用类名小写名称 从spring容器中获取具体策略对象

    @Override
    public String toPayHtml() {
        return "调用支付宝接口...AliPayStrategy";
    }
}
