package com.laoliu.spring5.test;

import com.laoliu.spring5.aopanno.User;
import com.laoliu.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");

        User user = context.getBean("user",User.class);
        user.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigAop.class);

        User user = context.getBean("user",User.class);
        user.add();
    }
}
