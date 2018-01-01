package com.gzq.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试自定义拒绝处理类。
 * @author GeYi
 *
 */
public class MyReject {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10), 
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r,
                            ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "拒绝");
                    }
                });
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            threadPoolExecutor.submit(task);
            Thread.sleep(10);
        }
    }
    
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "thread id : " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}
