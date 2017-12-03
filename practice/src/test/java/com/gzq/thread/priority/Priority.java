package com.gzq.thread.priority;

/**
 * 演示线程的继承性：如果A线程启动了B线程，那么B线程的优先级将与A保持一致。
 * @author GeYi
 */
public class Priority extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread1： " + this.getPriority());
		Priority2 priority2 = new Priority2();
		priority2.start();
	}
	
	public static void main(String[] args) {
		System.out.println("main： " + Thread.currentThread().getPriority());
		// 线程级别修改，由该线程启动的线程也会相应的被修改（可以注释查看效果）。
		Thread.currentThread().setPriority(7);
		Priority priority = new Priority();
		priority.start();
	}

}

class Priority2 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread2： " + this.getPriority());
	}
}