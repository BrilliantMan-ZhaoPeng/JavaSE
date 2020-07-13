package com.zp.demo.procon;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhaopeng
 * @create 2020-04-22 22:22
 */

public class Main2 {
    public static Object baozidian=new Object();
    public static void main(String[] args) {

    }

    public static void parkUnparkTest(){
        Thread consumerThread=new Thread(()->{
        if(baozidian==null){
            System.err.println("1.进入等待");
            LockSupport.park();
        }
           System.err.println("2.买到了包子");
        });



    }
}
