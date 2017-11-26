package com.gzq.thread.helloworld;

public class RunnableFirst implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		RunnableFirst first = new RunnableFirst();
		Thread thread = new Thread(first);
		thread.setName("my runnable first");
		thread.start();
		System.out.println("main end");
	}
	
}
