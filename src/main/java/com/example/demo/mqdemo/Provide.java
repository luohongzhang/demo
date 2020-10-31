package com.example.demo.mqdemo;

import com.example.demo.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: 消息发送者
 * @author: luohz
 * @create: 2020-10-31 21:59
 **/
@RestController
public class Provide {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("send")
    public void sendMessage() {

        String message = "hello ,我是luohz";
        rabbitTemplate.convertAndSend(RabbitMqConfig.fanoutName, null, message);
    }
}
