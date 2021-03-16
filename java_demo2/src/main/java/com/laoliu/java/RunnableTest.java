package com.laoliu.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个类实现Runnable接口
 * 2.实现类实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类对象
 * 5.通过Thread类对象调用start()
 *
 * 比较两种创建线程的方式
 * 开发中优先选择：实现Runnable接口的方式
 * 原因：1.实现接口的方式没有类单继承的局限性
 *      2.实现接口方式更适合来处理多个线程有共享数据的情况
 *
 * @author LaoLiu
 * @create 2021-03-06 13:32
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("接口方式实现多线程的创建");
    }
}

class RunnableJunit{

    public static void main(String[] args) {
        Runnable runnableTest = new RunnableTest();
        Thread t1 = new Thread(runnableTest);
        t1.start();
    }
}
