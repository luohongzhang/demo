package com.example.demo.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public enum CodeEnum {

    SUCCESS(0,"请求成功"),
    ERROR(500,"未知异常"),
    ERROR_EMPTY_RESULT(1001,"查询结果为空"),
    ERROR_INCOMPLETE_RESULT(1002,"请求参数不全");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;
    CodeEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
}
