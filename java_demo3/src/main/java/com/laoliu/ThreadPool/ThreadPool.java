package com.laoliu.ThreadPool;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四 使用线程池
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用了线程池中的线程，不需要每次都创建）
 * 3.便于管理线程
 *          corePoolSize：核心池的大小
 *          maximumPoolSize：最大线程数
 *          keepAliveTime：线程没有任务时最多保持多长时间终止
 *
 * 总结：
 * 1.现成的生命周期，以及各状态切换使用到的方法。
 * （唤醒 notify、notifyAll）-- 阻塞 <--（wait、sleep）
 *                         |        |
 *                创建 --> 就绪 --> 运行 --> 消亡
 *
 * 2.同步代码块中涉及到同步监视器和共享数据的理解和注意点
 *  共享数据：多个线程都需要对其进行操作的数据
 *  同步监视器：可以是任意对象，对于多个线程来说，它是唯一的，多个线程共用
 *            可以保证共享数据的安全性
 *            synchronized 同步代码块和同步方法包含操作共享数据的代码，不能多包代码，也不能少包代码
 *            普通同步方法的同步监视器是本类的对象
 *            静态同步方法的同步监视器是本类
 *
 * 3.sleep()和wait()的区别
 *      sleep设定一段时间阻塞，到时间后自动唤醒，不会释放同步监视器
 *      wait设定阻塞后需要手动使用notify或notifyAll唤醒，并且会释放同步监视器
 *      sleep方法可以用在任何位置，wait方法只能使用在同步方法和同步代码块中
 *      sleep方法是Thread类中生命的静态方法，wait方法是Object中声明的方法
 *
 * 4.自己编写一个懒汉式
 *
 * 5.创建多线程有几种方式，都是如何实现的
 *
 * @author LaoLiu
 * @create 2021-03-09 14:55
 */

class NumberOut implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i<=100;i++){
            if (i % 2 == 0) System.out.println(i);
        }
    }
}

class NumberOut1 implements Callable{

    @Override
    public Object call() throws Exception {
        for (int i = 1;i<100;i++){
            if (i % 2 != 0) System.out.println(i);
        }
        return null;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
        service.submit(new NumberOut());
        service.submit(new NumberOut1());
        service.shutdown();
    }
}
