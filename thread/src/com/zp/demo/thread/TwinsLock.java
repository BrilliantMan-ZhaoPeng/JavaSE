package com.zp.demo.thread;

import javafx.concurrent.Worker;
import sun.awt.geom.AreaOp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程的 访问将被阻塞，我们将这个同步工具命名为TwinsLock
 * 。TwinsLock在同一时刻允许至多两个线程的同时访问，表明同步资源 数为2，这样可以设置初始状态status为2，当一个线程进行获取，
 * status减1，该线程释放，则 status加1，状态的合法范围为0、1和2，其中0表示当前已经有两个线程获取了同步资源，
 * 此时 再有其他线程对同步状态进行获取，该线程只能被阻塞。在同步状态变更时，需要使用 compareAndSet(int expect,int update)
 * 方法做原子性保障。
 * @author zhaopeng
 * @create 2020-06-18 23:07
 */
public class TwinsLock implements Lock {

    private final  Sync sync=new Sync(2);

    @Override
    public void lock() {
       sync.tryAcquireShared(1);
    }

    @Override
    public void unlock() {
      sync.tryReleaseShared(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    @Override
    public Condition newCondition() {
        return null;
    }

    public static class Sync extends AbstractQueuedSynchronizer{
       Sync(int count){
           if(count<=0){
               throw new IllegalArgumentException("count must large than zero.");
           }
           //设置state值
           setState(count);
       }

       //共享锁的实现
       @Override
       protected int tryAcquireShared(int reduceCount) {
           for(;;){
               //获取当前的状态量 0表示满了
               int currentState = getState();
               //上锁1个，，减少state的量1个
               int newCount=currentState-reduceCount;
               if(newCount>=0&&compareAndSetState(currentState,newCount)){
                      return newCount;
               }
           }
       }

       @Override
       protected boolean tryReleaseShared(int returnCount) {
           for(;;){
               int currentState=getState();
               int newCount=returnCount+currentState;
               if(compareAndSetState(currentState,newCount)){
               //    System.err.println(Thread.currentThread().getName()+":unlock");
                   return true;
               }
           }
       }
   }


    public static void main(String[] args) {
        TwinsLock lock=new TwinsLock();
        class Worker extends Thread {
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.err.println(Thread.currentThread().getName()+":lock");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }

        // 启动10个线程
         for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.start();
         }
    }
}
