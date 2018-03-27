package com.gzq.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 限时获取锁
 * @author Administrator
 *
 */
public class ReentrantLockTest3 extends Thread{
	public static ReentrantLock rLock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			long start = System.currentTimeMillis();
			if(rLock.tryLock(8, TimeUnit.SECONDS)) {
				Thread.sleep(10000);
			}else {
				long end = System.currentTimeMillis();
				System.out.println(Thread.currentThread().getName() + "未获取到锁" 
						+ ", 等待时间为：" + (end-start));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if(rLock.isHeldByCurrentThread()) {
				System.out.println(Thread.currentThread().getName() + "释放了锁");
				rLock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		ReentrantLockTest3 rLockTest31 = new ReentrantLockTest3();
		ReentrantLockTest3 rLockTest32 = new ReentrantLockTest3();
		rLockTest31.start();
		rLockTest32.start();
	}

}
