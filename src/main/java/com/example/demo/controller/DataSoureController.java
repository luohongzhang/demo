package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/dataSource")
public class DataSoureController {

    @Autowired
    @Qualifier("jdbc1Template")
    private JdbcTemplate db1JdbcTemplate;

    @Autowired
    @Qualifier("jdbc2Template")
    private JdbcTemplate db2JdbcTemplate;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @GetMapping("testData1")
    public String testData1(){
        int update = db1JdbcTemplate.update("insert into student(student_id,name,age) values(?,?,?)", new Object[]{1,"luohz", 18});
        return "testData1更改行数：" + update;
    }

    @GetMapping("testData2")
    public String testData2(){
        int update = db2JdbcTemplate.update("insert into student(student_id,name,age) values(?,?,?)", new Object[]{3,"lalala", 18});
        return "testData2更改行数：" + update;
    }



}
