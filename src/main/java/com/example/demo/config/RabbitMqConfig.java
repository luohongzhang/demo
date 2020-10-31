package com.example.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 消息队列
 * @author: luohz
 * @create: 2020-10-31 21:38
 **/
@Configuration
public class RabbitMqConfig {

    public final static String queueA = "first-queue";

    public final static String queueB = "second-queue";

    public final static String fanoutName = "fanout";

    /**
     * 定义一个队列，并完善属性
     *
     * @return
     */
    @Bean("queueA")
    public Queue queueA() {
        Map<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 10000);
        map.put("x-max-length", 10);
        Queue queue = new Queue(queueA, true, false, false, map);
        return queue;
    }

    /**
     * 定义一个队列，并完善属性
     *
     * @return
     */
    @Bean("queueB")
    public Queue queueB() {
        Map<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 10000);
        map.put("x-max-length", 10);
        Queue queue = new Queue(queueB, true, false, false, map);
        return queue;
    }

    /**
     * 定义扇形交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        /**
         * param1 : 交换机名称
         * param2 : 是否持久化
         * param3 : 是否自动删除
         */
        FanoutExchange fanoutExchange = new FanoutExchange(fanoutName, true, false);
        return fanoutExchange;
    }

    @Bean
    public Binding bindingA(@Qualifier("queueA") Queue queueA, FanoutExchange fanoutExchange) {
        Binding binding = BindingBuilder.bind(queueA).to(fanoutExchange);
        return binding;
    }

    @Bean
    public Binding bindingB(@Qualifier("queueB") Queue queueB, FanoutExchange fanoutExchange) {
        Binding binding = BindingBuilder.bind(queueB).to(fanoutExchange);
        return binding;
    }

}

