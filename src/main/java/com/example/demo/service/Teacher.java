package com.example.demo.service;

import com.example.demo.component.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component // Classes using @Autowired must be defined as Beans.
public class Teacher {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;

    public void teach() {
        printer.print("I'm a Teacher");
    }
}
