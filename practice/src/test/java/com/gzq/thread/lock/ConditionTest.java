package com.gzq.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author GeYi
 *
 */
public class ConditionTest implements Runnable{
	public static ReentrantLock rLock = new ReentrantLock();
	public static Condition condition = rLock.newCondition();
	
	public ConditionTest() {
		
	}


	@Override
	public void run() {
		try {
			rLock.lock();
			System.out.println(Thread.currentThread().getName()+"让自己等待");
			condition.await();
			System.out.println(Thread.currentThread().getName()+"被主线程唤醒继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ConditionTest conditionTest = new ConditionTest();
		Thread thread = new Thread(conditionTest);
		thread.start();
		Thread.sleep(1000);//主线睡眠，会保证副线程先执行，避免以下代码在副线程之前运行。
		rLock.lock();//唤醒别的线程之前，自己先获取这把重入的锁
		condition.signal();//
		rLock.unlock();//唤醒别人后，自己应该释放这把锁，让别人可以执行。不然自己有获取这把锁了。
	}

}
