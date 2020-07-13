package com.zp.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhaopeng
 * @create 2020-05-06 10:17
 */

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.err.println("执行callable的线程");
        return "执行成功了的";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(new MyCallable());
        Thread thread=new Thread(futureTask);
        thread.start();
        String s = futureTask.get();
        System.out.println(s);
    }
}
