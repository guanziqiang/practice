package com.gzq.thread.basic.stop;

/**
 * 测试interrupt中断时sleep、wait等操作会抛出异常。
 * @author Administrator
 *
 */
public class T3InterruptedException {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("线程进入休眠");
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					System.out.println("线程在休眠中被唤醒");
					//通过打印值可以发现，中断异常抛出后会清除中断的标志
					System.out.println("通过不清除中断状态的isInterrupted方法获取抛出异常后的中断值："
							+ Thread.currentThread().isInterrupted());
				}
			}
		};
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
	}

}
