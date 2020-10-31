package com.example.demo.mqdemo;

import com.example.demo.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 消费者A
 * @author: luohz
 * @create: 2020-10-31 21:56
 **/
@RabbitListener(queues = RabbitMqConfig.queueA)
@Component
@Slf4j
public class ConsumeA {

    @RabbitHandler
    public void receive(String message) {

        log.info("消费者A接受到的消息：{0}", message);
    }

}
