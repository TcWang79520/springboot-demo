package com.example.demo.controller;

import com.example.demo.dao.StudentRowMapper;
import com.example.demo.service.StudentService;
import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.service.StudentService.*;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String create(@RequestBody Student student) {

        int insertRet = studentService.add(student);

        if(insertRet>0){
            return "Success Create Student";
        } else {
            return "Fail Create Student";
        }

    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents(){
        String sql = "SELECT id, name FROM student";

        Map<String,Object> map = new HashMap<>();

        StudentRowMapper rowMapper = new StudentRowMapper();
        List<Student> studentsList = namedParameterJdbcTemplate.query(
                sql,map,rowMapper);

        return studentService.getAll();
    }


    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId, @RequestBody Student student) {
        return "DB Update Action";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "DB Delete Action";
    }

}
