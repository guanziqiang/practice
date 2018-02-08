package com.gzq.thread.basic.join;

/**
 * 让线程自己join自己导致死循环。
 * @author GeYi
 *
 */
public class Join2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main join");
		Thread.currentThread().join();//让线程自己join自己
		System.out.println("main end");
	}

}
