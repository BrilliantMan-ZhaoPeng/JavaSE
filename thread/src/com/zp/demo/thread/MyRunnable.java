package com.zp.demo.thread;

/**
 * @author zhaopeng
 * @create 2020-05-06 10:15
 */

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.err.println("执行线程666");
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new MyRunnable());
        thread.start();
    }
}
