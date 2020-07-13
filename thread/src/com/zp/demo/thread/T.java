package com.zp.demo.thread;
/**
 * @author zhaopeng
 * @create 2020-05-13 13:18
 */
public class T implements Runnable{
    private int count=100;
    @Override
    public  void run() {
        count--;
        System.err.println(Thread.currentThread().getName()+":count="+count);
    }
    public static void main(String[] args) {
        T t=new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"thread"+i).start();
        }
    }
}

