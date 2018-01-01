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
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 6; i++) {
			newFixedThreadPool.submit(new ExecutorsTest());
		}
		newFixedThreadPool.shutdown();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}

}
