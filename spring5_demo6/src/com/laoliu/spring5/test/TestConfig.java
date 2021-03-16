package com.laoliu.spring5.test;

import com.laoliu.spring5.config.Config;
import com.laoliu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestConfig {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");

        UserService userService = context.getBean("userService",
                UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                Config.class);

        UserService userService = context.getBean("userService",
                UserService.class);
        userService.accountMoney();
    }


}
