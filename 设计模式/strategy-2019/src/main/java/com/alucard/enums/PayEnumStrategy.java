package com.alucard.enums;

/**
 * 策略枚举类 能够所有策略的实现
 */
public enum PayEnumStrategy {

    /**
     * 支付宝支付
     */
    ALI_PAY("com.alucard.strategy.impl.AliPayStrategy"),
    /**
     * 银联支付
     */
    UNION_PAY("com.alucard.strategy.impl.UnionPayStrategy"),
    /**
     * 小米
     */
    XIAOMI_PAY("com.alucard.strategy.impl.XiaomiPayStrategy"),
    /**
     * 微信支付
     */
    WECHAT_PAY("com.mayikt.strategy.impl.WeChatPayStrategy");

    PayEnumStrategy(String className) {
        this.setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * class完整地址
     */
    private String className;

}
