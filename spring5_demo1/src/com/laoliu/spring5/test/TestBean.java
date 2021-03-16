package com.laoliu.spring5.test;

import com.laoliu.spring5.User;
import com.laoliu.spring5.dept.Emp;
import com.laoliu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {


    @Test
    public void test1(){
        //1。加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
        user.showStr();
    }

    @Test
    public void test2(){
        //1。加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        //2.获取配置创建的对象
        UserService userService = context.getBean("service", UserService.class);

        userService.showService();
    }

    @Test
    public void test3(){
        //1。加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        //2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.showEmp();
    }
}
