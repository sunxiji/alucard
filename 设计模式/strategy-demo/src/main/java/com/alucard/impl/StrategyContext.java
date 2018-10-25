package com.alucard.impl;

import com.alucard.intf.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author alucard
 * @Description 相当于是一个缓存,在项目启动的时候将实现策略接口的实现类注入到ConcurrentHashMap里面
 * @Date Create in 14:35 2018/10/17
 */
@Service
public class StrategyContext {
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    /**
     * 注入所以实现了Strategy接口的Bean
     * @param strategyMap
     */
    @Autowired
    public StrategyContext(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    /**
     * 计算价格,这里根据get获取对应的实现类,实现了策略,然后去自己对应的类里面调用自己的计算价格的方法
     * @param memberLevel   会员等级
     * @return              价格
     */
    public BigDecimal calculatePrice(String memberLevel) {
        return strategyMap.get(memberLevel).calculatePrice();
    }
}
