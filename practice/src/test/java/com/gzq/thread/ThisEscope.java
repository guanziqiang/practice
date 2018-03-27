package com.gzq.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 未归类，测试线程池的shutdownNow方法到底能不能关闭 正在执行的线程？
 * @author GeYi
 *
 */
public class ThisEscope {
    private String name="a";
    public String name2="a";
    
    public String getName() {
        return name;
    }
    
    public static class Test implements Runnable{
        @Override
        public void run() {
            
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + " : " + new Date());
                int i = Integer.parseInt("a");
            }
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.execute(new Test());
        newFixedThreadPool.execute(new Test());
        
        Thread.sleep(3000);
        
        newFixedThreadPool.shutdownNow();
        
        
        

        

        
    }
}
