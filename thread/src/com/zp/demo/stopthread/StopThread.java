package com.zp.demo.stopthread;
/**
 * @author zhaopeng
 * @create 2020-04-22 20:21
 */
public class StopThread extends Thread {
    private int i=0,j=0;
    @Override
    public void run() {
        synchronized (this){
            //增加同步锁，确保线程的安全
            ++i;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++j;
        }
    }

    public void print(){
        System.err.println("i="+i+"j="+j);
    }
}
