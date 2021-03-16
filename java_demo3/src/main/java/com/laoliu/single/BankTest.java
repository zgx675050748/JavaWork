package com.laoliu.single;

/**
 * 线程同步解决单例模式（懒汉式）线程安全问题
 * @author LaoLiu
 * @create 2021-03-06 16:59
 */

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率低 每个线程都要等待锁
//        synchronized (Bank.class) {
//            if (instance == null) instance = new Bank();
//            return instance;
//        }

        //方式二：第一批进入的线程需要等待锁，以后的线程则不需要等待，直接取对象
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) instance = new Bank();
            }
        }
        return instance;
    }
}

public class BankTest {
}
