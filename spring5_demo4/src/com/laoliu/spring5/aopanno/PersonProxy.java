package com.laoliu.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class PersonProxy {

    //相同切入点抽取
    @Pointcut("execution(* com.laoliu.spring5.aopanno.User.add(..))")
    public void pointut(){

    }

    //@Before注解表示该方法作为被增强方法的前置通知
    @Before("pointut()")
    public void before(){
        System.out.println("person before++++++");
    }

    //最终通知
    @After("pointut()")
    public void after(){
        System.out.println("person after++++++");
    }

    //后置通知
    @AfterReturning("pointut()")
    public void afterReturning(){
        System.out.println("person afterReturning++++++");
    }

    //异常通知
    @AfterThrowing("pointut()")
    public void afterThrowing(){
        System.out.println("person afterThrowing++++++");
    }

    //环绕通知
    @Around("pointut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("person around before++++++");
        proceedingJoinPoint.proceed();
        System.out.println("person around after++++++");
    }
}
