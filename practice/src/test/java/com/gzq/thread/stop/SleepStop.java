package com.gzq.thread.stop;

public class SleepStop extends Thread{
	
	@Override
	public void run() {
		try {
			for(int i=0; i<300; i++) {
				System.out.println(i);
				Thread.sleep(1000*20);
			}
			System.out.println("正常结束");
		} catch (InterruptedException e) {
			System.out.println("睡眠中，进入异常结束");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SleepStop sleepStop = new SleepStop();
		sleepStop.start();
		//主线在副线程中断前休眠，会先执行副线程，副线程如果也休眠并不会马上终止进入catch。
		//  只有等到主线程苏醒，且副线程此时又睡眠时，副线程才会进入catch。
		//主线程不在副线程中断前休眠，则会先执行完主线程，在执行副线程。如果此时副线程休眠，则会直接进入catch。
//		Thread.sleep(1000 * 100); 
		sleepStop.interrupt();
		System.out.println("main end");
	}

}
