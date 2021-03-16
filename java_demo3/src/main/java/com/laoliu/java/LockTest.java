package com.laoliu.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁    --- JDK5.0新增
 *
 * 1.面试题：synchronized 与 lock的异同？
 *      相同点：都能解决线程安全问题
 *      不同点：synchronized机制执行完相应代码逻辑后自动释放同步监视器
 *             lock需要手动启动和关闭同步，lock更加灵活，方便调优
 *
 * 2.优先使用顺序：
 *      Lock->同步代码块->同步方法
 *
 * @author LaoLiu
 * @create 2021-03-06 20:15
 */

class Window3 implements Runnable{

    private int ticket = 100;
//    1.实例化Lock
//    fair公平 先进先执行
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                //2.调用lock锁定资源
                lock.lock();

                if (ticket>0){
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+
                            "：售票，票序号为："+ticket--);
                }
                else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //3.执行完解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Runnable w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }
}
