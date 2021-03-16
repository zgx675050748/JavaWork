package com.laoliu.spring5.test;

import com.laoliu.spring5.config.Config;
import com.laoliu.spring5.entity.UserDb;
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
        UserService userService = context.getBean("userService",UserService.class);
        UserDb userDb = new UserDb();
        userDb.setUserId("20202204011020");
        userDb.setUserName("张贵轩");
        userDb.setUstatus("登录成功");
        userService.addUser(userDb);
        int count = userService.count();
        System.out.println(count);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        UserDb userDb = new UserDb();
        userDb.setUserId("20202204011019");
        userDb.setUserName("张贵轩1");
        userDb.setUstatus("登录成功1");
        userService.updateUser(userDb);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        UserDb userDb = new UserDb();
        userDb.setUserId("20202204011019");
        userService.deleteUser(userDb);
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        UserDb userDb = userService.findOne("20202204011019");
        System.out.println(userDb);
        List<UserDb> list = userService.findList();
        for (UserDb user:list
             ) {
            System.out.println(user.getUserId());
            System.out.println(user.getUserName());
            System.out.println(user.getUstatus());
        }
    }

    @Test
    public void test5(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                Config.class);
        UserService userService = context.getBean("userService",UserService.class);
        List<Object[]>  list = new ArrayList<>();
        Object[] o1 = {"1","1","1"};
        Object[] o2 = {"2","2","2"};
        Object[] o3 = {"3","3","3"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.batchAdd(list);
    }

    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        List<Object[]>  list = new ArrayList<>();
        Object[] o1 = {"9","9","1"};
        Object[] o2 = {"9","9","2"};
        Object[] o3 = {"9","9","3"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.batchUpdate(list);
    }

    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        List<Object[]>  list = new ArrayList<>();
        Object[] o1 = {"1"};
        Object[] o2 = {"2"};
        Object[] o3 = {"3"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        userService.batchDelete(list);
    }
}
