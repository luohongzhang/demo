package com.example.demo.Dao;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentJpa extends JpaRepository<Student,Integer> {


    List<Student> findStudentByName(String name);
}
