package com.gzq.thread.basic.volatile_;

/**
 * 
 * @author GeYi
 * 验证vaolatile不能保证数据的一致性。
 */
public class Volatile {

	private volatile static int i = 0;

	private static class VolatileRun implements Runnable {
		public void run() {
			for (int j = 0; j < 10000; j++) {
				i++;//该操作不是原子性的。
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new VolatileRun());
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();//确保所有线程运行完之后，再执行主线程剩余的部分
		}
		
		//多运行几次i的值很多时候都是小于10 * 10000的，应为volatile不能保证数据的一致性
		System.out.println("main end. i = " + i);

	}

}
