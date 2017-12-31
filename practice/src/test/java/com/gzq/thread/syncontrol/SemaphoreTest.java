package com.gzq.thread.syncontrol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 允许多个线程同时访问
 * @author GeYi
 *
 */
public class SemaphoreTest implements Runnable{
	
	public static Semaphore semaphore = new Semaphore(3);

	@Override
	public void run() {
		try {
			semaphore.acquire();
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "end");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(15);
		SemaphoreTest sTest = new SemaphoreTest();
		for(int i=0; i<15; i++) {
			pool.submit(sTest);
		}
		pool.shutdown();
	}

}
