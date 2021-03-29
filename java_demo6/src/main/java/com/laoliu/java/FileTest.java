package com.laoliu.java;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录
 * 2.File类声明在java.io包下
 *
 * @author laoliu
 * @create 2021 03 25 下午6:06
 */
public class FileTest {
    /*
        1.如何创建File类实例
        2.路径
            相对路径：
            绝对路径：

        3.路径分隔符：/
     */
    @Test
    public void test1() {
        //构造器1
        File file = new File("src/main/resources/hello.txt");

        //构造器2
        File file1 = new File("src/main","resources");
        System.out.println(file1);

        //构造器3
        File file2 = new File(file1,"hi.txt");
    }
    
    /*
        常用方法
     */
    @Test
    public void test2(){
        File file = new File("src/main/resources/hello.txt");
        File file1 = new File("/home/zhangguixuan/DevelopmentTools/Java/Work","JavaWork");
        for (String s : file1.list()) {
            System.out.println(s);
        }
    }


    /*
    重命名file1.renameTo(file2)
    要想保证true需要保证file1存在且file2不存在

    isDirectory:判断是否是文件目录
    isFile:判断是否是文件
    exists:判断是否存在
    canRead:判断是否可度
    canWrite:判断是否可写
    isHidden:判断是否隐藏

    创建功能
    createNewFile:创建文件，若文件存在，则不创建，返回false
    mkdir：创建文件目录，如果存在，则不创建，上层目录不存在，则不创建
    mkmir：创建文件目录，如果上层文件不存在，可以一并创建
     */
    @Test
    public void test3(){
        File file1 = new File("src/main/resources/hello.txt");
        File file2 = new File("hi.txt");
        boolean flag = file1.renameTo(file2);
        System.out.println(flag);
    }
}
