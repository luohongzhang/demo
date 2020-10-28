package com.example.demo.exception;

import com.example.demo.enums.CodeEnum;
import lombok.Data;

@Data
public class EmptyException extends  RuntimeException{

    private int code;

    private String message;

    public EmptyException(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }
}
