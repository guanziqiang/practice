package com.gzq.thread.itself;

public class SuspendResume {
	
	public synchronized void printS() {
		System.out.println("start");
		if(Thread.currentThread().getName().equals("a")) {
			System.out.println("a线程在没唤醒之前将独占该共享资源");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) throws InterruptedException {
		final SuspendResume sResume = new SuspendResume();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				sResume.printS();
			}
		};
		thread1.setName("a");
		thread1.start();
//		Thread.sleep(1000); 猜测：如果主线程不休眠，后面的resume总会在suspend之前执行。
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				sResume.printS();
			}
		};
		thread2.setName("d");
		thread2.start();
		thread1.resume();
		System.out.println("main end");
	}

}
