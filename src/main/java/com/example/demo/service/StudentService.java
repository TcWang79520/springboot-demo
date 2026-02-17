package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student getById(Integer studentId){
        return studentDao.getById(studentId);

    }

    public List<Student> getAll(){
        return studentDao.getAll();
    }

    public int add(Student student){
        return studentDao.insert(student);
    }

}
