package com.zp.demo.practice;

/**
 * @author zhaopeng
 * @create 2020-06-12 20:10
 */

public class Test4 {
    public static void main(String[] args) {
        Object lock1=new Object();
        Object lock2=new Object();
        new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.err.println("t1 lock2..");
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.err.println("t2 lock1.");
                }
            }
        },"t2").start();
    }
}
