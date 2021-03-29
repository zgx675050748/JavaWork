package com.laoliu.java;

import org.junit.Test;

import java.util.*;


/*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序（实现comparable接口）和定制排序
    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()方法

 */
public class TreeSetTest {
    //自然排序
    @Test
    public void test1(){
        Set set = new TreeSet();
//        set.add(11);
//        set.add(12);
//        set.add(1);
//        set.add(0);
//        set.add(-1);
//        System.out.println(set);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",13));
        set.add(new User("Jack",18));
        set.add(new User("Jack", 19));
        //添加的是对象，则需要对象所在类实现Comparable接口，重写compareTo()方法
        System.out.println(set);

    }

    //定制排序
    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof User && t1 instanceof User){
                    User user1 = (User) o;
                    User user2 = (User) t1;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }
                else {
                    throw new RuntimeException("类型不符");
                }
            }
        };
        Set set = new TreeSet(comparator);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",13));
        set.add(new User("Icey",13));
        set.add(new User("Jack",18));
        set.add(new User("Jack", 19));
        System.out.println(set);

    }
}
