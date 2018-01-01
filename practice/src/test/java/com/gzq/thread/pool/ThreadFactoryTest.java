package com.gzq.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(9), new ThreadFactory() {

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setDaemon(true);//
                        System.out.println("自定义线程池创建了一个" + thread +"线程");
                        return thread;
                    }
                });
        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.submit(new Runnable() {
                
                @Override
                public void run() {
                    System.out.println("runnalbe " + this.toString());
                }
            });
        }
        Thread.sleep(3000);
    }

}
