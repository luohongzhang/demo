package com.example.demo;

import org.assertj.core.api.Assert;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    StringEncryptor encryptor;

    @Test
    void contextLoads() {
    }

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://8.131.77.104:3306/yuanyuan?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&useAffectedRows=true&allowPublicKeyRetrieval=true");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("root");
        System.out.println(url+"----------------");
        System.out.println(name+"----------------");
        System.out.println(password+"----------------");
    }

}
