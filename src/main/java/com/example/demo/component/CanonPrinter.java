package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("Canon印表機 : "+message);
    }

}
