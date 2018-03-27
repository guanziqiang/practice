package com.gzq.thread.basic.volatile_;

/**
 * 
 * @author GeYi
 * 验证 volatile的可见性（顺序性可能不是很明显）。
 * 不加volatitle时，Volatile2Run对象将无法发现在主线程对两个变量的修改，它将不会停止。
 * 这一测试需要在虚拟机的server模式下，在该模式下虚拟机做了优化才能导致这一结果出现。
 */
public class Volatile2 {

	// 去除volatile修饰符查看不同的运行结果。
	private /*volatile*/ static boolean ready;
	private /*volatile*/ static int number;

	private static class Volatile2Run extends Thread {
		public void run() {
			while(!ready);
			System.out.println("number = " + number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new Volatile2Run().start();
		Thread.sleep(2000);
		number = 42;
		ready = true;
		Thread.sleep(5000);
		System.out.println("main end.");
	}

}
