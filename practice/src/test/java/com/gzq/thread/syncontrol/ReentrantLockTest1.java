package com.gzq.thread.syncontrol;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 验证可重入锁
 * @author GeYi
 *
 */
public class ReentrantLockTest1 implements Runnable{
	public static ReentrantLock reentrantLock = new ReentrantLock();
	public static int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			reentrantLock.lock();
			reentrantLock.lock();//这里体现了锁的可以重入。注意的时，拿几次就得释放几次。
			try {
				count++;
			} finally{
				reentrantLock.unlock();
				reentrantLock.unlock();//那几次，就放几次
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ReentrantLockTest1());
		Thread t2 = new Thread(new ReentrantLockTest1());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("main end. count = "+ReentrantLockTest1.count);
	}

}
