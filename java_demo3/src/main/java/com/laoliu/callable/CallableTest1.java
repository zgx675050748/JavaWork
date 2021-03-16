package com.laoliu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口相较于实现Runnable接口有什么优点？
 * 1.Callable接口可以有返回值
 * 2.Callable接口可以抛异常
 * 3.Callable接口可以指定泛型
 *
 * @author LaoLiu
 * @create 2021-03-08 18:18
 */
class CreateThread1 implements Callable{
    private int mount = 0;

    @Override
    public Object call() throws Exception {
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            mount += i;
        }
        return mount;
    }
}

public class CallableTest1{
    public static void main(String[] args) {
        CreateThread1 createThread1 = new CreateThread1();
        FutureTask futureTask = new FutureTask(createThread1);
        Thread t1 = new Thread(futureTask);
        t1.setName("线程一");
        t1.start();
        try {
            System.out.println("总和："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}