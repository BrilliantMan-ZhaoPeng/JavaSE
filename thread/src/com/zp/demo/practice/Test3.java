package com.zp.demo.practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaopeng
 * @create 2020-05-21 22:21
 */

public class Test3 {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        int i=0;
        lock.lock();
        i++;
        lock.unlock();
     }
}

