package com.example.demo.dto;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

@Data
public class PersonDTO {

    private String name;

    private int age;


    public PersonDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
