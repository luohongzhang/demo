package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean implements Serializable {

    private Integer studentId;

    private Integer age;

    private String name;

    private Integer sex;

    private Date createTime;

    private Integer status;
}
