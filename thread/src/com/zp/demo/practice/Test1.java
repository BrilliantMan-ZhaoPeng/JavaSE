package com.zp.demo.practice;
import java.util.concurrent.locks.LockSupport;
/**
 * 两个线程交替打印
 * a1b2c3d4........z26
 * @author zhaopeng
 * @create 2020-05-21 17:12
 */
public class Test1 {
    static   Thread t1=null;
    static   Thread t2=null;
    private static volatile boolean flag=true;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            int i=0;
            while(i<26) {
               if(flag){//flag为true执行当前的线程
                   System.err.print((char)('a'+i));
                   flag=false;
                   i++;
                   LockSupport.unpark(t2);
               }else{
                   LockSupport.park(t1);
               }
            }
       });


        t2 = new Thread(()->{
            int i=1;
            while(i<=26) {
              if(!flag){//flag为true执行当前的线程
                  System.err.print(i);
                  i++;
                  flag=true;
                  LockSupport.unpark(t1);
              }else{
                  LockSupport.park(t2);
              }
            }
       });
      t1.start();
      t2.start();
    }
}