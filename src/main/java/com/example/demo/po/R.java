package com.example.demo.po;

import com.example.demo.enums.CodeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class R<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public R fillCode(int code, String message){
        this.code = code;
        this.message = message;
        return this;
    }
    /**
     * 放入响应码并返回
     * @param codeEnum
     * @return
     */
    public R fillCode(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        return this;
    }

    /**
     * 放入数据并响应成功状态
     * @param data
     * @return
     */
    public R fillData(T data){
        this.code = CodeEnum.SUCCESS.getCode();
        this.message = CodeEnum.SUCCESS.getMessage();
        this.data = data;
        return this;
    }


}
