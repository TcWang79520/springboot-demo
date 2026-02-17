package com.example.demo.controller;

import com.example.demo.dao.StudentRowMapper;
import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String create(@RequestBody Student student) {

        String sql = "INSERT INTO student (id,name ) VALUES (:studentId, :studentName)";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql,map);


        return "DB Create Action";
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents(){
        String sql = "SELECT id, name FROM student";

        Map<String,Object> map = new HashMap<>();

        StudentRowMapper rowMapper = new StudentRowMapper();
        List<Student> studentsList = namedParameterJdbcTemplate.query(
                sql,map,rowMapper);

        return studentsList;
    }


    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "DB Get Action";
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
