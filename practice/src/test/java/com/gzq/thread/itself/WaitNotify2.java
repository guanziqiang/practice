package com.gzq.thread.itself;

/**
 * 模拟suspend、resume两个Thread的过期方法，同时做了少许优化。
 * @author GeYi
 *
 */
public class WaitNotify2 {
	public static Object u = new Object();

	public static class SuspendResume extends Thread {
		volatile boolean suspendme = false;

		public void suspendMe() {
			suspendme = true;
		}

		public void resumeMe() {
			suspendme = false;
			synchronized (this) {
				notify();
			}
		}
		
		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					while (suspendme)//为true时，模拟挂起。 换成if也可以。
						try {
							System.out.println("wait");
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				synchronized (u) {
					System.out.println("in SuspendResume");
				}
			}
		}
	}
	
	public static class ReadSuspendResume extends Thread{
		@Override
		public void run() {
			while(true) {
				synchronized (u) {
					System.out.println("in ReadSuspendResume");
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SuspendResume t1 = new SuspendResume();
		ReadSuspendResume t2 = new ReadSuspendResume();
		t1.start();
//		t2.start();
		Thread.sleep(1000);
		t1.suspendMe();
		System.out.println("suspend t1 2 second");
		Thread.sleep(1000*2);
		System.out.println("resume t1");
		t1.resumeMe();
	}

}
