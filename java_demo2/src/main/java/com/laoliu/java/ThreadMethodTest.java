package com.laoliu.java;

/**
 * 测试Thread中的常用方法
 * 1.start()：启动当前线程；调用当前线程的run();
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权，但执行权可能还会分配回该线程
 * 7.join():在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行后，线程a才结束阻塞状态
 * 8.stop():强制结束线程生命周期，不推荐使用
 * 9.sleep(long milltime):让当前线程“睡眠”指定的milltime毫秒。在指定的milltime毫秒的时间内，当前线程处于阻塞状态
 * 10.isAlive():判断当前线程是否存活
 *
 * @author LaoLiu
 * @create 2021-03-06 12:38
 */
public class ThreadMethodTest extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0;i<=100;i++){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%2==0) System.out.println(Thread.currentThread().getName()+
                    ":"+i);

            //if (i%20==0) yield();
        }
    }
}


class Test{
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        ThreadMethodTest thread1 = new ThreadMethodTest();
        thread1.setName("线程1");
        thread1.start();

        for (int i=0;i<=100;i++){
            if (i%2!=0) System.out.println(Thread.currentThread().getName()+
                    ":"+i);

            if (i==19) {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
