package com.zp.demo.procon;
/**
 * @author zhaopeng
 * @create 2020-04-22 21:20
 */
public class Produce extends Thread{
    @Override
    public void run() {
        synchronized (Main.lock){
            while(Main.falg!=100){
                while(Main.count==0){//证明需要通知生产者生产
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(Main.count!=0) {//开始消费
                    Main.count--;
                    Main.falg++;
                    System.err.println("成功消费第" + Main.falg + "个");
                    Main.lock.notifyAll();
                }
            }
        }
    }
}
