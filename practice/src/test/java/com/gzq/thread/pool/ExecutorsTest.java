package com.gzq.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 测试，非周期性调度的线程池
 * @author GeYi
 *
 */
public class ExecutorsTest implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 6; i++) {
			newFixedThreadPool.submit(new ExecutorsTest());
		}
		System.out.println(newFixedThreadPool.isShutdown());
		newFixedThreadPool.shutdown();
		System.out.println("main end");
		Thread.sleep(3000);
		System.out.println(((ThreadPoolExecutor)newFixedThreadPool).getActiveCount());
		
		newFixedThreadPool.submit(new ExecutorsTest());
		
	}

	@Override
	public void run() {
		try {
		    int count = 0;
		    while(count < 1){
		        count++;
		        Thread.sleep(1200);
		        System.out.println(Thread.currentThread().getName());
		    }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
