package com.zp.demo.thread.bank;

import com.zp.demo.thread.T;

import java.util.concurrent.TimeUnit;

/**
 * 模拟银行账户存钱与查询余额
 * @author zhaopeng
 * @create 2020-05-13 13:42
 */
public class Account {
    private double balance;
    public synchronized void setAccount(double balance){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    public /*synchronized*/ double getAccount(){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a=new Account();
        new Thread(()->{
            a.setAccount(100);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println(a.getAccount());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(a.getAccount());
    }
}
