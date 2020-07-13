package com.zp.demo.practice;
import java.util.LinkedList;
/**
 * @author zhaopeng
 * @create 2020-05-21 21:11
 */
public class MyContainer<T> {
    final  private LinkedList<T> lists=new LinkedList<>();

    final private int MAX=10;//最多10个元素

    private int count=0;

    public synchronized void put(T t) {
        while (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();
    }


    public synchronized T get(){
        T t=null;
        while (lists.size()==0){
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
       t=lists.removeFirst();
       count--;
       this.notifyAll();
       return t;
    }

    public static void main(String[] args) {
        MyContainer<String> c=new MyContainer<>();
        //启动10个生产者
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j <5 ; j++) {
                    System.err.println(c.get());
                }
            },"c:"+i).start();
        }


        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25 ; j++) {
                    c.put(Thread.currentThread().getName()+":"+j);
                }
            }).start();
        }
    }
}
