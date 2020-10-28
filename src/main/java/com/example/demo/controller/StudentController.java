package com.example.demo.controller;

import com.example.demo.Dao.StudentDao;
import com.example.demo.Dao.StudentJpa;
import com.example.demo.domain.Student;
import com.example.demo.domain.StudentBean;
import com.example.demo.po.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentJpa studentJpa;

    @GetMapping("/batchAddStu")
    public R<String> batchAddStu() {
        R<String> r = new R<>();
        log.info("####begin batch");
        int i = studentDao.batchAddStudent();
        log.info("####end batch");
        r.setData("结果" + i);
        return r;
    }


    @GetMapping("/getAll")
    public R<List<StudentBean>> getAll() {
        R<List<StudentBean>> r = new R<>();
        List<StudentBean> i = studentDao.getStudents();
        r.setData(i);
        return r;
    }

    @GetMapping("/getAllJpa")
    public R<List<Student>> getAllJpa() {
        R<List<Student>> r = new R<>();
        List<Student> i = studentJpa.findAll();
        r.setData(i);
        return r;
    }

    @GetMapping("/getAllJpaByName/{name}")
    public R<List<Student>> getAllJpaByName(@PathVariable String name){
        R<List<Student>> r = new R<>();
        List<Student> i = studentJpa.findStudentByName(name);
        r.setData(i);
        return r;
    }
}
