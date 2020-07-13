package com.zp.demo.procon;

import java.util.zip.CheckedOutputStream;

/**
 * @author zhaopeng
 * @create 2020-04-22 21:20
 */
public class Consumer extends  Thread{
    @Override
    public void run() {
        synchronized (Main.lock){
            while(Main.falg!=100){
                while(Main.count!=0){
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(Main.count==0){
                    Main.count++;
                    System.err.println("开始生产第"+(Main.falg+1)+"个");
                    Main.lock.notifyAll();
                }
            }
        }
    }
}
