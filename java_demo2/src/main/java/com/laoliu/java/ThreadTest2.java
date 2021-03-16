package com.laoliu.java;

/**
 * 多线程创建，方式一：继承Thread类
 * 1.创建继承于Thread类的子类
 * 2.重写Thread类的run()  -->将此线程执行的操作生命在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * 例子：遍历100内的偶数
 *
 * @author LaoLiu
 * @create 2021-03-06 11:07
 */
public class ThreadTest2 extends Thread {
    //重写run()方法
    @Override
    public void run() {
        super.run();
        for (int i=0;i<=100;i++){
            if (i%2 == 0) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //创建Thread子类对象
        ThreadTest2 thread = new ThreadTest2();

        //开启线程
        //1.启动当前线程
        //2.调用当前现成的run()
        thread.start();
    }
}
