package com.gzq.thread.basic;

import java.lang.Thread.State;
import java.util.concurrent.ThreadFactory;

public class NewThread {
	
	public static void main(String[] args) {
		//线程的创建和启动
//		Thread thread = new Thread();
//		thread.start();
//		====================
		//通过继承Thread实现自己的线程
//		MyThread myThread = new MyThread();
//		myThread.start();
//		=========================
		//通过实现Runnable实现自己的线程
//		Thread thread = new Thread(new MyRunnbale());
//		thread.start();
		//验证真实的线程
//		new TureThread().start();
//		new FalseThread().run();
		
		System.out.println("main thread name: " + Thread.currentThread().getName());
		System.out.println("main thread end.");
	}

}

class FalseThread extends Thread{
	@Override
	public void run() {
		System.out.println("直接启用run的线程名称：" + Thread.currentThread().getName());
	}
}
class TureThread extends Thread{
	@Override
	public void run() {
		System.out.println("通过start方法启用run的线程名称：" + Thread.currentThread().getName());
	}
}

class MyRunnbale implements Runnable{

	@Override
	public void run() {
		System.out.println("My Runnable run().");
	}
	
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("My Thread run().");
	}
}
