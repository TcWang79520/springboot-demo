package com.example.demo;

import com.example.demo.component.Printer;
import com.example.demo.vo.Store;
import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    @Qualifier("hpPrinter") // First need to be lowercase word
    private Printer printer;

    @RequestMapping("/test")
    public String test(@RequestParam Integer id) {
        printer.print("Hello Autowired : " + id);
        return "Get ID Success : " + id;
    }

    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        store.setProductList(list);
        return store;
    }


    @RequestMapping("/student")
    public Student student(){
        Student student = new Student();
        student.setId("123");
        student.setName("Judy");
        return student;

    }

    @RequestMapping("/student/enroll")
    public String studentEnroll(@RequestBody Student student, @RequestHeader String info) {

        System.out.println(student.toString());
        System.out.println("Header Value : " + info);
        return "Enroll Success : " + student.toString();

    }

}
