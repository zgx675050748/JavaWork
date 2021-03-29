package com.laoliu.java.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author laoliu
 * @create 2021 03 24 下午5:42
 */
public class PropertiesTest {
    //Properties：常用来处理配置文件，key-value都是String类型
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
        properties.load(fileInputStream);
        String property = properties.getProperty("jdbc.url");
        System.out.println(property);
        String property1 = properties.getProperty("jdbc.driverClass");
        System.out.println(property1);
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);

        System.out.println(list.size());
        List list1 = Arrays.asList(new Object[list.size()]);

        Collections.copy(list1,list);
        System.out.println(list1);
    }
}