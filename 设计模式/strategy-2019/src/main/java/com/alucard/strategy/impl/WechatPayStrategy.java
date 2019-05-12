package com.alucard.strategy.impl;

import com.alucard.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: AliPayStrategy
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/821:08
 */
@Component
public class WechatPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用微信支付接口...WechatPayStrategy";
    }
}
