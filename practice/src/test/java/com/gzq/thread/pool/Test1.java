package com.gzq.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test1 {
    
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("第一个：" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
//        
//        newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            
//            @Override
//            public void run() {
//                System.out.println("第二个：" + System.currentTimeMillis() / 1000);
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 2, TimeUnit.SECONDS);
//        
    }

}
