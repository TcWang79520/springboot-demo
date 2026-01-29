package com.example.demo.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {

    private int count;

    @PostConstruct
    public void initialize(){
        count = 5;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println("HP印表機 : "+message);
        System.out.print("剩餘使用次數 : "+ count);
    }

}
