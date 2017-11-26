package com.gzq.thread.safe;

public class ThreadSafe1 extends Thread{
	private int count = 9;
	
	/**
	 * 如果不加synchronized关键字，打印出来的数字将有可能不是递减。
	 */
	@Override
	public synchronized void run() {
		count--;
		System.out.println(Thread.currentThread().getName() 
				+ " : " + count);
	}
	
	public static void main(String[] args) {
		ThreadSafe1 safe1 = new ThreadSafe1();
		new Thread(safe1).start();
		new Thread(safe1).start();
		new Thread(safe1).start();
		new Thread(safe1).start();
		new Thread(safe1).start();
		new Thread(safe1).start();
	}

}
