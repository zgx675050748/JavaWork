package com.laoliu.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户，有两个储户分别向同一个账户存3000元，每次存1000，存3次。
 * 每次存完打印账户余额
 *
 *
 *
 * @author LaoLiu
 * @create 2021-03-06 20:39
 */
class Account{
    private double amt=0;

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public void deposit(double amt){
        if (amt > 0){
            this.amt += amt;
            System.out.println(Thread.currentThread().getName()+
                    "：存钱成功，账户余额为："+this.getAmt());
        }
    }
}


class Deposit implements Runnable{

    private Account account;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            try {
                lock.lock();
                Thread.sleep(1000);
                account.deposit(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Deposit dep = new Deposit();
        dep.setAccount(new Account());
        Thread t1 = new Thread(dep);
        Thread t2 = new Thread(dep);
        t1.setName("储户1");
        t2.setName("储户2");
        t1.start();
        t2.start();
    }
}
