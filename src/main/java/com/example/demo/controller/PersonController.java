package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.po.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户接口")
@RestController
@Slf4j
@RequestMapping("/person")
public class PersonController {

    @ApiOperation(value = "获取用户列表", notes = "根据name获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String", required = true),
            @ApiImplicitParam(name = "int", value = "用户年龄", dataType = "int", required = true)
    })
    @GetMapping("{name}")
    public R<PersonDTO> getPerson(@PathVariable("name") String name, @RequestParam int age){
        PersonDTO personDTO = null;
        personDTO = new PersonDTO(name, age);
        return new R<>().fillData(personDTO);
    }

}
