package com.alucard.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:11 2018/11/6
 */
@Configuration
public class RabbitmqConfig {

    // 邮件队列
    private String FANOUT_EMAIL_QUEUE = "fanout_eamil_queue";

    // 短信队列
    private String FANOUT_SMS_QUEUE = "fanout_sms_queue";

    // 交换机
    private String EXCHANGE_NAME = "fanoutExchange";

    /**
     * 定义邮件队列
     *
     * @return
     */
    @Bean
    public Queue fanOutEamilQueue() {
        return new Queue(FANOUT_EMAIL_QUEUE);
    }

    /**
     * 定义短信队列
     *
     * @return
     */
    @Bean
    public Queue fanOutSmsQueue() {
        return new Queue(FANOUT_SMS_QUEUE);
    }

    /**
     * 定义交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    /**
     * 队列与交换机绑定邮件队列
     * @param fanOutEamilQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeEamil(Queue fanOutEamilQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutEamilQueue).to(fanoutExchange);
    }

    /**
     * 队列与交换机绑定短信队列
     * @param fanOutSmsQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeSms(Queue fanOutSmsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutSmsQueue).to(fanoutExchange);
    }
}
