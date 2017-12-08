package com.gzq.thread.synch;

/**
 * 1，synchronized修饰方法和synchronized(this)修饰代码块时，表示对锁有自己（对象）管理。
 * 2，synchronized(非this)修饰代码块时，锁由当前的非this（对象）管理，而且与自己管理的同步方法异步执行。
 * @author Administrator
 *
 */
public class WhoSyn {
	
	public static void main(String[] args) {
		final WhoSynTask wSynTask = new WhoSynTask();
		new Thread() {
			@Override
			public void run() {
				wSynTask.test();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				wSynTask.test2();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				wSynTask.test3();
			}
		}.start();
		
	}
	

}

class WhoSynTask{
	//非this的线程锁
	private String syn = new String();
	
	public synchronized void test() {
		System.out.println("this方法锁 进入： " + System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("this方法锁 结束： " + System.currentTimeMillis());
	}
	
	public void test2() {
		
		synchronized(syn) {
			System.out.println("非this代码块锁 进入： " + System.currentTimeMillis());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("非this代码块锁 结束： " + System.currentTimeMillis());
		}
		
	}
	
	public void test3() {
		
		synchronized(this) {
			System.out.println("this代码块锁 进入： " + System.currentTimeMillis());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("this代码块锁 结束： " + System.currentTimeMillis());
		}
		
	}
	
}