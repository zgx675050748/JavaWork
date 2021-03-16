package com.laoliu.spring5.collectiontype.testdemo;

import com.laoliu.spring5.collectiontype.Course;
import com.laoliu.spring5.collectiontype.Stu;
import com.laoliu.spring5.order.Orders;
import com.laoliu.spring5.order.OrdersPlus;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Demo1 {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config1.xml");

        Stu stu = applicationContext.getBean("stu", Stu.class);

        stu.test();
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config2.xml");

        Stu stu = applicationContext.getBean("stu", Stu.class);

        stu.test();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config3.xml");

        Course courser1 = applicationContext.getBean("courser1", Course.class);
        Course courser2 = applicationContext.getBean("courser1", Course.class);

        System.out.println(courser1);
        System.out.println(courser2);
    }

    @Test
    public void test4(){
        //        bean生命周期测试
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config4.xml");

        Orders order = context.getBean("order1", Orders.class);
        System.out.println("第四步 获取创建bean实例对象");

        ((ClassPathXmlApplicationContext)context).close();

    }
}
