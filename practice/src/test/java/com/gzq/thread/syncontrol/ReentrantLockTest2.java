package com.gzq.thread.syncontrol;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断锁验证.
 * lockInterruptibly
 * isHeldByCurrentThread
 * @author GeYi
 * rL1.lock();这个锁不能够响应中断。
 *
 */
public class ReentrantLockTest2 implements Runnable{
	public static ReentrantLock rL1 = new ReentrantLock();
	public static ReentrantLock rL2 = new ReentrantLock();
	private int type;//根据type值设置实例请求锁的顺序，以便造成锁死。
	
	public ReentrantLockTest2(int type) {
		this.type = type;
	}

	@Override
	public void run() {
		if(type == 1) {
			try {
				try {
					rL1.lockInterruptibly();
//					rL1.lock();
					System.out.println(Thread.currentThread().getName() +" 获取了锁1.");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					rL2.lockInterruptibly();
//					rL2.lock();
					System.out.println(Thread.currentThread().getName() +" 获取了锁2.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				if (rL1.isHeldByCurrentThread()) {//判断当前线程是否拥有锁
					rL1.unlock();
					System.out.println(Thread.currentThread().getName() +" 释放了锁1.");
				}
				if (rL2.isHeldByCurrentThread()) {//判断当前线程是否拥有锁
					rL2.unlock();
					System.out.println(Thread.currentThread().getName() +" 释放了锁2.");
				}
			} 
			
		}else {
			try {
				try {
					rL2.lockInterruptibly();
//					rL2.lock();
					System.out.println(Thread.currentThread().getName() +" 获取了锁2.");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					rL1.lockInterruptibly();
//					rL1.lock();
					System.out.println(Thread.currentThread().getName() +" 获取了锁1.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				if (rL1.isHeldByCurrentThread()) {//判断当前线程是否拥有锁
					rL1.unlock();
					System.out.println(Thread.currentThread().getName() +" 释放了锁1.");
				}
				if (rL2.isHeldByCurrentThread()) {//判断当前线程是否拥有锁
					rL2.unlock();
					System.out.println(Thread.currentThread().getName() +" 释放了锁2.");
				}
			}
		}
		System.out.println(Thread.currentThread().getName() +" end.");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ReentrantLockTest2 reentrantTest21 = new ReentrantLockTest2(1);
		ReentrantLockTest2 reentrantTest22 = new ReentrantLockTest2(2);
		Thread thread1 = new Thread(reentrantTest21);
		Thread thread2 = new Thread(reentrantTest22);
		thread1.start();
		thread2.start();
		Thread.sleep(4000);
		thread2.interrupt();
		
	}
	
	

}
