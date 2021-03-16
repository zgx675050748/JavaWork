package com.laoliu.communication;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LaoLiu
 * @create 2021-03-06 21:27
 */

class Number implements Runnable{
    private int num = 1;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (num<=100) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                }
                else break;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class ConmmunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
