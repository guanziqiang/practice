package com.gzq.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadStack implements Runnable {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            //100/0会有异常
            
            //一、submit 情况下异常不能抛出。
//            executor.submit(new ThreadStack(100,i));
            
            //二、submit.get() 可以抛出异常
//            Future<?> submit = executor.submit(new ThreadStack(100,i));
//            try {
//                submit.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
            
            //三、execute 情况下异常可以抛出
            executor.execute(new ThreadStack(100,i));
            
            
            
        }
    }

    int a, b;
    public ThreadStack(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        double result = a/b;
        System.out.println(result);
    }

}
