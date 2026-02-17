package com.example.demo.dao;


import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Student getById(Integer studentId){
        System.out.print("~~~~~~~~~~~~");
        String sql = "select id, name from student where id=:studentId";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId",studentId);

        List<Student> list = namedParameterJdbcTemplate.query(
                sql,map,new StudentRowMapper()
        );
        if(list.size()>0){
            return list.get(0);
        } else {
            return null;
        }

    }

    public  List<Student> getAll(){
        String sql = "SELECT id, name FROM student";

        Map<String,Object> map = new HashMap<>();

        StudentRowMapper rowMapper = new StudentRowMapper();
        List<Student> studentsList = namedParameterJdbcTemplate.query(
                sql,map,rowMapper);

        if(studentsList.size()>0){
            return studentsList;
        } else {
            return null;
        }
    }

    public int insert(Student student){
        try {
            String sql = "INSERT INTO student (id,name ) VALUES (:studentId, :studentName)";

            Map<String,Object> map = new HashMap<>();
            map.put("studentId", student.getId());
            map.put("studentName", student.getName());

            int ret = namedParameterJdbcTemplate.update(sql,map);

            if(ret>0){
                return ret;
            } else  {
                return 0;
            }

        } catch (Exception e){
            return -1;
        }
    }

}
