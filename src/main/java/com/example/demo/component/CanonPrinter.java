package com.example.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer {

    @Value("${canon.count:100}") // :100 , this means : Without Key , value will be 100
    private int count;

    @Value("${my.name}")
    private String name;

    @Override
    public void print(String message) {
        count--;
        System.out.println("Canon印表機 : "+message);
        System.out.println(name + " 剩餘使用次數: "+count);
    }

}
