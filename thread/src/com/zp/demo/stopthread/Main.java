package com.zp.demo.stopthread;

/**
 * @author zhaopeng
 * @create 2020-04-22 20:24
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StopThread st=new StopThread();
        st.start();
        Thread.sleep(1000);
        //暂停线程
       // st.stop();//错误的停止
        st.interrupt();
        while(st.isAlive()){
             //确保线程已经停止
        }
        st.print();
    }
}

