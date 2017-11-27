package com.gzq.thread.itself;

/**
 * public static native void sleep(long millis) throws InterruptedException;
 */
public class Sleep extends Thread{
	
	@Override
	public void run() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(1000);
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
	}

}
