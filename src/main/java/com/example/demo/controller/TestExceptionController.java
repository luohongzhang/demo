package com.example.demo.controller;

import com.example.demo.enums.CodeEnum;
import com.example.demo.exception.EmptyException;
import com.example.demo.exception.RequestParamException;
import com.example.demo.po.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.swing.StringUIClientPropertyKey;

@RestController
@Slf4j
public class TestExceptionController {

    @GetMapping("/getException")
    public R getException(String param) {
        if (StringUtils.isEmpty(param)) {
            throw new EmptyException(CodeEnum.ERROR_INCOMPLETE_RESULT);
        } else if (param.equals("luohz")) {
            throw new RequestParamException(CodeEnum.ERROR_EMPTY_RESULT);
        }
        int num = 1 / 0;
        return new R().fillData(param);
    }
}
