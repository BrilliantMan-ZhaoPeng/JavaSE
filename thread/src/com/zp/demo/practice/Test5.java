package com.zp.demo.practice;

/**
 * @author zhaopeng
 * @create 2020-06-13 15:17
 */

public class Test5 {
    public static void main(String[] args) {
        Object lock=new Object();
        new Thread(()->{
            synchronized (lock){
                while(true){

                }
            }
        },"t1").start();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                synchronized (lock){

                }
            },"t"+i).start();
        }
    }
}
