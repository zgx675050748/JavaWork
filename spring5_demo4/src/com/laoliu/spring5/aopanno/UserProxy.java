package com.laoliu.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Order(3)
@Component
@Aspect  //生成代理对象
public class UserProxy {

    //相同切入点抽取
    @Pointcut("execution(* com.laoliu.spring5.aopanno.User.add(..))")
    public void pointut(){

    }

    //@Before注解表示该方法作为被增强方法的前置通知
    @Before("pointut()")
    public void before(){
        System.out.println("before++++++");
    }

    //最终通知
    @After("pointut()")
    public void after(){
        System.out.println("after++++++");
    }

    //后置通知
    @AfterReturning("pointut()")
    public void afterReturning(){
        System.out.println("afterReturning++++++");
    }

    //异常通知
    @AfterThrowing("pointut()")
    public void afterThrowing(){
        System.out.println("afterThrowing++++++");
    }

    //环绕通知
    @Around("pointut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before++++++");
        proceedingJoinPoint.proceed();
        System.out.println("around after++++++");
    }
}
