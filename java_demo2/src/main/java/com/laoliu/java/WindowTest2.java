package com.laoliu.java;

/**
 * @author LaoLiu
 * @create 2021-03-06 13:59
 */
class Window implements Runnable{
    private int ticket = 10000;
    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+
                    "：卖票，票序号为："+ticket);
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Runnable window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }
}
