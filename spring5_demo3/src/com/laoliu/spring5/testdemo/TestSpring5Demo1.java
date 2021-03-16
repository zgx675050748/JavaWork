package com.laoliu.spring5.testdemo;

import com.laoliu.spring5.config.Spring5Config1;
import com.laoliu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Demo1 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    @Test
    public void test3(){
        //加载配置类
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Spring5Config1.class);

        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }
}
