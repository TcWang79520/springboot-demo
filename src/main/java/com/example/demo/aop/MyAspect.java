package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    // 此切入點 表示 HpPrinter 的所有方法
    @Before("execution(* com.example.demo.component.HpPrinter.*(..))")
    public void before(){
        System.out.println("\nI'm before");
    }

    @After("execution(* com.example.demo.component.HpPrinter.*(..))")
    public void after(){
        System.out.println("I'm after");
    }


    @Around("execution(* com.example.demo.component.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("I'm around before");
        // 執行切入點的方法 , obj 為切入方法執行的結果
        Object obj = joinPoint.proceed();
        long end = System.currentTimeMillis();
        
        System.out.println("耗時：" + (end - start));
        System.out.println("I'm around after");
        return obj;
    }
}
