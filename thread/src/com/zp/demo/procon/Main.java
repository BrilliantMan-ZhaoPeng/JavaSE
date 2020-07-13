package com.zp.demo.procon;
/**
 * @author zhaopeng
 * @create 2020-04-22 21:20
 */
public class Main {
    public static int count=0;
    public static int falg=0;
    public static Object lock=new Object();
    public static void main(String[] args) {
        Consumer consumer=new Consumer();
        Produce produce=new Produce();
        consumer.start();
        produce.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.interrupted();
    }
}
