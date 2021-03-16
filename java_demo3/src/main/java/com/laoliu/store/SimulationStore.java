package com.laoliu.store;

/**
 * 一个店铺卖产品，产品最多库存20件，少于20件时生产者则开始生产，反之则等待；
 * 消费者购买产品，产品库存为0时，消费者等待。（注：假设每次生产和消费都是一件）
 *
 * wait(),notify(),notifyAll()都只能在同步代码块和同步方法中使用，被同步监视器调用
 * 这三个方法都声明在Object类中
 *
 * sleep():使线程进入到阻塞状态指定时间，但不会释放同步监视器
 * wait():使线程进入阻塞状态，直到被唤醒，并自动释放同步监视器
 * notify():唤醒一条被wait()的线程，多条线程被wait()时，唤醒优先级高的一条
 * notifyAll():唤醒所有线程
 *
 * 面试题：sleep和wait的异同？
 * 相同点：都能使线程进入阻塞状态
 * 不同点：1.sleep和wait的使用位置不同，sleep可以使用在任何位置，而wait只能在同步块和同步方法中被同步监视器调用
 *        2.sleep不会释放同步监视器，wait会释放同步监视器
 *        3.sleep会指定阻塞时间，wait则需要手动唤醒
 *        4.sleep生命在Thread类中，wait生命在Object类中
 *
 * @author LaoLiu
 * @create 2021-03-07 10:52
 */

class Clerk{
    private int productCount = 0;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}

class Producer implements Runnable{
    private Clerk clerk;

    Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            production();
        }
    }

    private void production(){
        synchronized (clerk) {
            if (clerk.getProductCount() < 20) {
                clerk.setProductCount(clerk.getProductCount() + 1);
                System.out.println(Thread.currentThread().getName() + "制造了" + clerk.getProductCount() + "号产品");
                clerk.notify();
            } else {
                try {
                    clerk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consume();
        }
    }

    private void consume(){
        synchronized (clerk) {
            if (clerk.getProductCount()>0) {
                System.out.println(Thread.currentThread().getName() + "消费了" + clerk.getProductCount() + "号产品");
                clerk.setProductCount(clerk.getProductCount() - 1);
                clerk.notify();
            }
            else{
                try {
                    clerk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class SimulationStore {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread pro1 = new Thread(producer);
        Thread con1 = new Thread(consumer);
        Thread con2 = new Thread(consumer);
        pro1.setName("生产者1");
        con1.setName("消费者1");
        con2.setName("消费者2");
        pro1.start();
        con1.start();
        con2.start();
    }

}
