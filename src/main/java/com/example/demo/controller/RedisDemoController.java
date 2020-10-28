package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: redis练习
 * @author: luohz
 * @create: 2020-10-28 22:11
 **/
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisDemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/setValue")
    public void setRedisTemplate(String str) {
        redisTemplate.opsForValue().set("name", "yuanyuan");
    }

    @GetMapping("/setStringValue")
    public void setStringRedisTemplate(String str1) {
        redisTemplate.opsForValue().set("name", "tuantuan");
    }


}
