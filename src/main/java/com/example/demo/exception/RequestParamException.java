package com.example.demo.exception;

import com.example.demo.enums.CodeEnum;
import lombok.Data;

@Data
public class RequestParamException extends RuntimeException{

    private int code;

    private String message;

    public RequestParamException(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }
}
