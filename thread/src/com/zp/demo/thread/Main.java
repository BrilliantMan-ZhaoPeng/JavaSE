package com.zp.demo.thread;
/**
 * @author zhaopeng
 * @create 2020-05-13 10:36
 */
public class Main {
    public static void main(String[] args) {
          testJoin();
    }
    static void testJoin(){
       Thread t1=new Thread(()->{
           for (int i = 0; i < 100; i++) {
               System.err.println("t1:"+i);
           }
       });


        Thread t2=new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.err.println("t2:"+i);
            }
        });
        t2.start();
        t1.start();
    }
}
