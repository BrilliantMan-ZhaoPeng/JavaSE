package com.zp.demo.thread.aqs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/**
 * @author zhaopeng
 * @create 2020-06-26 11:32
 */
public class MyCountDownLatch implements Lock {

    private Sync sync;

    private MyCountDownLatch(int count){
        if(count>0||count<Integer.MAX_VALUE){
            this.sync=new Sync(count);
        }else{
            this.sync=new Sync(2);//默认为2
        }
    }


   static class Sync extends  AbstractQueuedSynchronizer{

        private int count;

        public Sync(int count){
            setState(count);
        }
        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }
    }


    @Override
    public void lock() {

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
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}