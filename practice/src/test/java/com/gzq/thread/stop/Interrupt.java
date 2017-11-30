package com.gzq.thread.stop;

/**
 * interrupt调用后不会立马结束线程，但是会给予一个线程需要中断的标志。
 * 
 * interrupted该方法会去判断线程是否中断，同时如果有中断的标志（例如，之前调用了interrupt方法）它将会清楚该标志状态。
 * isInterrupted该方法与interrupted刚好相反，它获取状态后并不会清楚状态标志。
 * @author GeYi
 *
 */
public class Interrupt extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("interrupt :" + i);
		}
	}
	
	public static void main(String[] args) {
//		Interrupt interrupt = new Interrupt();
//		interrupt.start();
//		interrupt.interrupt();
//		System.out.println("interrupted：" + interrupt.interrupted());
//		System.out.println("interrupted：" + interrupt.interrupted());
		Thread.currentThread().interrupt();
//		System.out.println("interrupted：" + Thread.interrupted());
//		System.out.println("interrupted：" + Thread.interrupted());
		System.out.println("interrupted：" + Thread.currentThread().isInterrupted());
		System.out.println("interrupted：" + Thread.currentThread().isInterrupted());
		
	}

}
