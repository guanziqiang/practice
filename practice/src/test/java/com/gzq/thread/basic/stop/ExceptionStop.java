package com.gzq.thread.basic.stop;

/**
 * 测试线程抛出异常后会终止。
 * 
 * @author Administrator
 *
 */
public class ExceptionStop {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			private long sum;

			@Override
			public void run() {
				int sum = 10;
				while (true) {
					int result = 2000 / sum;
					System.out.println("结果 " + result);
					System.out.println("sum " + sum--);
				}
			}
		};
		thread.start();
	}

}
