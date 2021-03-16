package com.laoliu.java;

/**
 * 线程安全问题
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.原因：某个线程进行操作时，其他线程参与进来，同时操作相同的数据
 * 3.如何解决线程安全问题：当一个线程a在操作共享数据的时候，其他线程不能参与进来，
 * 直到线程a操作完成，其他线程才可以开始操作，这种情况即使线程a出现了阻塞，也不能被改变。
 * 4.Java中，通过同步机制，解决线程安全问题。
 *
 *      方式一：同步代码块
 *      synchronized( 同步监视器 ){
 *          //需要被同步的代码
 *      }
 *      说明:操作共享数据的代码，即为需要被同步的代码
 *          共享数据：多个线程同时操作的数据
 *          同步监视器，俗称：锁，任何一个类的对象都可以充当锁
 *          要求多个线程必须用同一把锁
 *      补充：在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
 *      方式二：
 *
 *      优点：同步方式，解决了线程的安全问题。
 *      缺点：操作同步代码的同时，只能有一个线程参与，相当于单线程，效率低。
 * @author LaoLiu
 * @create 2021-03-06 13:59
 */
class Window implements Runnable{

    //线程共享数据
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket>0){
            synchronized( this ){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+
                        "：卖票，票序号为："+ticket);
                ticket--;
            }
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
