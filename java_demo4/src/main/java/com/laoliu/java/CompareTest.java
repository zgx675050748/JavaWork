package com.laoliu.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LaoLiu <br/>
 * @Description Java对象，正常情况，只能进行比较：== 或 != ，不能使用> 或 <。
 *                  需要实现Comparable或Comparator<br/>
 * @create 2021-03-16 13:21 <br/>
 * @since JDK 1.8
 *
 * Comparable接口的使用
 * 1.像String、包装类等实现了Comparable接口。重写了compareTo(obj)方法，给出了比较两个对象大小
 * 2.像String、包装类重写compareTo()方法以后，进行了从小到大的排序。
 * 3.重写compareTo()的规则：
 *      如果当前对象this大于形参对象obj，则返回正整数；
 *      如果当前对象this小于形参对象obj，则返回负整数；
 *      如果当前对象this等于形参对象obj，则返回零；
 * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()方法
 *   在compareTo(obj)方法中指明如何排序
 */
public class CompareTest {
    /*
    Comparable接口的使用举例
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"CC","AA","DD","JJ","QQ","EE"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    自定义排序
     */
    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",24);
        arr[3] = new Goods("huaweiMouse",60);
        arr[4] = new Goods("Mouse",60);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
