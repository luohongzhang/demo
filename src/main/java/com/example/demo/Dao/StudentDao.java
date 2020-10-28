package com.example.demo.Dao;

import com.example.demo.domain.StudentBean;

import java.util.List;

public interface StudentDao {

    public List<StudentBean> getStudents();

    public int batchAddStudent();

    public int delStudent(int status);

    public int updStudent(int studentId, String name);
}
