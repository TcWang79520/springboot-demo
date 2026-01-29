package com.example.demo;

import com.example.demo.component.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("canonPrinter") // First need to be lowercase word
    private Printer printer;

    @RequestMapping("/test")
    public String test(){
        printer.print("Hello Autowired");
        return "Hello World";
    }
}
