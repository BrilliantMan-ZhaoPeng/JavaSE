package com.zp.demo.thread;

import javax.security.auth.Subject;
import java.sql.SQLSyntaxErrorException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 * @author zhaopeng
 * @create 2020-05-11 13:44
 */
public class MyThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger integer=new AtomicInteger(0);
        for (int i = 0; i < 10 ; i++) {
            integer.getAndIncrement();
            Future<String> submit = executorService.submit(() -> {
                System.err.println("执行了第:" + integer.get() + "个线程");
                return "执行成功了的！！！";
            });
            String s = submit.get();
            System.err.println(s);
             /*executorService.execute(()->{
                System.err.println("执行了第"+integer.get()+"个线程");
            });*/
        }
    }

}
