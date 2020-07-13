package com.zp.demo.practice;
/**
 * 两个线程交替打印
 * a1b2c3d4........z26
 * @author zhaopeng
 * @create 2020-05-21 19:48
 */
public class Test2 {
    public static  volatile  boolean flag=true;

    public static final Object lock1=new Object();

    public static final Object lock2=new Object();

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            int i=0;
            while(i<26){
                if(flag){
                    System.err.print('a'+i);
                    i++;
                    flag=false;
                    lock2.notify();
                }else{
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.err.println("t1执行");
        });

        Thread t2=new Thread(()->{
            int i=1;
            while(i<=26){
                if(!flag){
                    System.err.print(i);
                    flag=true;
                    i++;
                    lock1.notify();
                }else{
                    try {
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.err.println("t2执行");
        });

        t1.start();
        t2.start();
    }
}
