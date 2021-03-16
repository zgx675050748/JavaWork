package com.laoliu.java;

/**
 *例：创建三个窗口卖票，总票数为100
 * 使用同不代码块解决线程安全问题
 * 说明：在继承Thread类创建多线程时，慎用this充当同步监视器，可以使用当前类充当同步监视器
 *
 * @author LaoLiu
 * @create 2021-03-06 13:12
 */
public class WindowTest extends Thread{
    private static int ticket = 10000;

    @Override
    public void run() {
        while (ticket>0){
            synchronized(WindowTest.class) {
                //类也是一个对象，每个类只会加载一次
                System.out.println(getName() + "：卖票，票序号为：" + ticket);
                ticket--;
            }
        }
    }
}

class TestWindow{
    public static void main(String[] args) {
        WindowTest w1 = new WindowTest();
        WindowTest w2 = new WindowTest();
        WindowTest w3 = new WindowTest();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
