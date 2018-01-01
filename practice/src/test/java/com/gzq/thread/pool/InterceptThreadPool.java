package com.gzq.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试对线程池执行线程的前、后和线程池自己的终结时的拦截。
 * 
 * @author GeYi
 *
 */
public class InterceptThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("线程池正准备执行： " + r.toString());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("线程池完成执行： "+r.toString());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池终结");
            }
        };
        for (int i = 0; i < 9; i++) {
            threadPoolExecutor.execute(new Runnable() {
                
                @Override
                public void run() {
                    System.out.println("run " + this.toString());
                }
            });
            Thread.sleep(10);
        }
        threadPoolExecutor.shutdown();
    }

}
