package com.gzq.thread.itself;

/**
 * @author GeYi
 * 通过public static native Thread currentThread();方法进一步查看启动的新线程去执行run()方法的效果。
 */
public class CurrentThread extends Thread{
	
	public CurrentThread() {
		//构造器是在main线程中执行。
		System.out.println("constructer's thread: " + Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		//run方法则是在新启动的线程中执行。
		System.out.println("run's thread: " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		CurrentThread currentThread = new CurrentThread();
		currentThread.start();
		System.out.println("main's thread: " + Thread.currentThread().getName() );
	}
	

}
