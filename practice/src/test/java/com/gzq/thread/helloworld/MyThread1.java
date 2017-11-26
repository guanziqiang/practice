package com.gzq.thread.helloworld;

public class MyThread1 extends Thread{
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}
	
	public static void main(String[] args) {
		MyThread1 myThread = new MyThread1();
		myThread.start();
		System.out.println("test end!");
	}
}
