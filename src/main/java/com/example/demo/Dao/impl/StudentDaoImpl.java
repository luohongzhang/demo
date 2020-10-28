package com.example.demo.Dao.impl;

import com.example.demo.Dao.StudentDao;
import com.example.demo.domain.StudentBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao {


    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StudentBean> getStudents() {
        String sql = "select * from student";
//        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StudentBean.class));
        return null;
    }

    @Override
    public int batchAddStudent() {
        List<StudentBean> studentBeans = new ArrayList<>(10);
        StudentBean studentBean = new StudentBean(31, 31, "tuantuan", 1, new Date(), 1);
        StudentBean studentBean1 = new StudentBean(32, 32, "yuanyuan", 1, new Date(), 1);
        studentBeans.add(studentBean);
        studentBeans.add(studentBean1);
        String sql = "insert into student values(?,?,?,?,?,?)";
//        int [] data = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                StudentBean student = studentBeans.get(i);
//                ps.setInt(1, student.getStudentId());
//                ps.setInt(2, student.getAge());
//                ps.setString(3, student.getName());
//                ps.setInt(4, student.getSex());
//                ps.setDate(5,new java.sql.Date(System.currentTimeMillis()));
//                ps.setInt(6, student.getStatus());
//
//            }
//
//            @Override
//            public int getBatchSize() {
//                return studentBeans.size();
//            }
//        });

//        return data.length;
        return 1;
    }

    @Override
    public int delStudent(int status) {
        String sql = "delete from student where status =1";
//        return jdbcTemplate.update(sql);
        return 1;
    }

    @Override
    public int updStudent(int studentId, String name) {
        String sql = "update student set name = ? where student_id = ?";
//        return jdbcTemplate.update(sql,new Object[]{name,studentId});
        return 1;
    }
}
