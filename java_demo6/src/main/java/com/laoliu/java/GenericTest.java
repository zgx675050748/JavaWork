package com.laoliu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author laoliu
 * @create 2021 03 25 下午4:07
 */
public class GenericTest {
    
    //在集合中使用泛型的情况：ArrayList
    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i : list) {
            System.out.println(i);
        }
    }

    //HashMap
    @Test
    public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("jack",18);
        map.put("jerry",19);
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+"----"+integer);
            }
        });
    }

    @Test
    public void test3(){
        //如果定义了泛型，但实例化时没有使用，默认是Object类型
        Order<String> order = new Order("zgx",19,"666");
        System.out.println(order);
        Integer integer = order.get(1);
        String s = order.get("123");
        System.out.println(integer);
        System.out.println(s);
    }


    //通配符:?
    @Test
    public void test4(){
        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<?> list3 = new ArrayList<>();
        list3 = list1;
        list3 = list2;
        //list2 = list1;  //报错
    }
}

/*
    泛型类、泛型接口、泛型方法
 */
class Order<T>{
    private String name;
    private int orderId;
    private T user;

    public Order(){

    }

    public Order(String name, int orderId, T user) {
        this.name = name;
        this.orderId = orderId;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", user=" + user +
                '}';
    }

    //泛型方法
    public  <E>  E get(E num){
        return num;
    }
}