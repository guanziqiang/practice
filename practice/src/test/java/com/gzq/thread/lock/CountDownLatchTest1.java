package com.gzq.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计量停止的线程阀
 * @author GeYi
 *
 */
public class CountDownLatchTest1 implements Runnable{
	private static CountDownLatch countDown = new CountDownLatch(5);

	@Override
	public void run() {
		try {
			Thread.sleep(2500);//模拟业务时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" 该线程结束。");
		countDown.countDown();//通知计量阀，本线程结束。
		
	}
	
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		CountDownLatchTest1 countDownLatchTest = new CountDownLatchTest1();
		for (int i = 0; i < 5; i++) {
			newFixedThreadPool.submit(countDownLatchTest);
		}
		
		try {
			countDown.await();//等待5个线程结束
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("5个线程已经结束。");
		newFixedThreadPool.shutdown();
	}

}
