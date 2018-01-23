package com.gzq.thread.basic.join;

public class Join2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main join");
		Thread.currentThread().join();
		System.out.println("main end");
	}

}
