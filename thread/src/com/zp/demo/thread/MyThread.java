package com.zp.demo.thread;
/**
 * @author zhaopeng
 * @create 2020-05-06 10:14
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.err.println("执行线程");
    }

    public static void main(String[] args) {
       MyThread thread=new MyThread();
       thread.start();

       new Thread(()->{
           System.err.println("执行简单的线程");
       }).start();
    }
}
