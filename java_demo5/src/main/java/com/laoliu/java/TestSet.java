package com.laoliu.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1. Set接口的框架
 * /----Collection接口：单列集合，用来存储一个一个的对象
 *          /----Set接口：存储无序的、不可重复的数据
 *              /----HashSet：作为Set接口的主要实现类：线程不安全；可以存储null
 *                  /----LinkedHashSet：作为Hashset的子类，遍历内部数据时，可以按照添加的顺序遍历
 *              /----TreeSet：可以按照添加对象的指定属性，进行排序
 */
public class TestSet {

    private String name;
    private int age;

    /*
    1.无序性：存储的数据在底层数组中不按照数组索引顺序添加，而是根据数据的哈希值添加

    2.不可重复性：保证添加的元素按照equals方法判断时，不能返回true，即相同的元素只能添加一个。

    添加元素的过程：以HashSet为例：
        向HashSet中添加元素a，首先调用元素a所在类的HashCode()方法，计算元素a的哈希值，
        此哈希值通过某种算法计算出在HashSet底层数组中的存放位置（即为索引位置），
        判断数组此位置上是否已经有元素：
            如果此位置上没有其他元素，则元素a添加成功 --->情况1
            如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素的hash值：
                如果hash值不同，则元素a添加成功  --->情况2
                如果hash值相同，进而调用元素a所在类的equals()方法：
                    equals()返回true，元素a添加失败
                    equals()返回false，则元素添加成功。 --->情况3

    对于添加成功的情况2和情况3而言：元素a与已经存在指定位置上的数据以链表形式存储。
    jdk 7：元素a放到数组中，指向原来的元素。
    jdk 8：原来的元素在数组中，指向元素a。

    重写hashCode和equals方法，尽量保证一致性，即equals相同的数据，hashCode也相同

    HashSet底层：数组+链表
     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("123456");
        set.add("123456");
        set.add(new Object());
        set.add(new Object());
        System.out.println(set);
    }

    /*
        LinkedHashSet的使用
        在添加数据的同时，每个书库还维护了两个引用，记录此数据的前驱和后继
        优点：对于频繁的便利操作，效率高于HashSet
     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("123456");
        set.add("123456");
        set.add(new Object());
        set.add(new Object());
        System.out.println(set);
    }

}