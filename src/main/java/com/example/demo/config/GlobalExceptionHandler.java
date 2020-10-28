package com.example.demo.config;

import com.example.demo.enums.CodeEnum;
import com.example.demo.exception.EmptyException;
import com.example.demo.exception.RequestParamException;
import com.example.demo.po.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyException.class)
    public R emptyResultExceptionHandler(EmptyException ee) {
        log.info("查询结果为空，{}", ee.getMessage());
        R result = new R();
        result.fillCode(ee.getCode(), ee.getMessage());
        return result;
    }

    @ExceptionHandler(RequestParamException.class)
    public R requestParamExceptionHandler(RequestParamException rr){
        log.info("查询结果为空，{}", rr.getMessage());
        R result = new R();
        result.fillCode(rr.getCode(), rr.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHander(Exception rr){
        log.info("查询结果为空，{}", rr.getMessage());
        R result = new R();
        result.fillCode(CodeEnum.ERROR);
        return result;
    }
}
