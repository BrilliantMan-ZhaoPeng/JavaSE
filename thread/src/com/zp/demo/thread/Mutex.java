package com.zp.demo.thread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.regex.Pattern;

/**
 * @author zhaopeng
 * @create 2020-06-18 22:02
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer{
        //锁是否是占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        //尝试上锁
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                  throw  new RuntimeException("请先上锁再来释放");
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        Condition condition(){
            return new ConditionObject();
        }
    }

    private final Sync sync=new Sync();
    @Override
    public void lock() {
        sync.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
       sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryRelease(0);
    }

    @Override
    public Condition newCondition() {
        return sync.condition();
    }
}
