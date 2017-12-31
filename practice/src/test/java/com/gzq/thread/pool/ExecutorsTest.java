package com.gzq.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest implements Runnable{
	
	
	
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 6; i++) {
			newFixedThreadPool.submit(new ExecutorsTest());
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
