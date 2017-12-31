package com.gzq.thread.syncontrol;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试公平锁
 * @author GeYi
 */
public class ReentrantLockTest4 extends Thread{
	private ReentrantLock reentrantLock;
	
	public ReentrantLockTest4(ReentrantLock reentrantLock) {
		this.reentrantLock = reentrantLock;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + "获得锁");
			}finally {
				if(reentrantLock.isHeldByCurrentThread()) {
					reentrantLock.unlock();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock(true);//true表示创建公平锁，false表示随机
		new ReentrantLockTest4(reentrantLock).start();
		new ReentrantLockTest4(reentrantLock).start();
	}

}
