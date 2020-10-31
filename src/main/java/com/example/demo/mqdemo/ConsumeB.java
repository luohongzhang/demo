package com.example.demo.mqdemo;

import com.example.demo.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 消费者B
 * @author: luohz
 * @create: 2020-10-31 21:56
 **/
@RabbitListener(queues = RabbitMqConfig.queueB)
@Component
@Slf4j
public class ConsumeB {

    @RabbitHandler
    public void receive(String message) {

        log.info("消费者B接受到的消息：{0}", message);
    }

}
