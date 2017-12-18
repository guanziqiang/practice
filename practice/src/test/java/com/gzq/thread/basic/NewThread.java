package com.gzq.thread.basic;

public class NewThread {
	
	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.start();
		System.out.println("main end.");
	}

}
