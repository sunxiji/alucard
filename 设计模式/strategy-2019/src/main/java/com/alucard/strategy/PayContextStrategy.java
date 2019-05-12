package com.alucard.strategy;

import com.alucard.entity.PaymentChannelEntity;
import com.alucard.mapper.PaymentChannelMapper;
import com.alucard.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PayContextStrategy {
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    /**
     * 获取具体策略实现
     *
     * @return
     */
    public String toPayHtml(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return "payCode不能为空!.....";
        }
        // 1.查询数据库获取具体策略实现
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        if (paymentChannel == null) {
            return "没有查询支付渠道";
        }
        // 获取spring注入的bean的id
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if (StringUtils.isEmpty(strategyBeanId)) {
            return "数据库没有配置strategyBeanId";
        }
        PayStrategy payStrategy = SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        return payStrategy.toPayHtml();
    }
    // 工厂负责对象初始化
}
