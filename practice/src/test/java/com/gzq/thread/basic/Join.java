package com.gzq.thread.basic;

/**
 * 验证join系列三个方法的效果。
 * @author GeYi
 * 详细解释见：002java线程的基本操作-join方法
 *
 */
public class Join {
	
	public volatile static int i = 0;
	
	public static class AddThread extends Thread{
		@Override
		public void run() {
			for(i=0; i<10000000; i++);
			System.out.println("副线程执行完毕，i值为：" + i);
		}
	}
	
	public static void main(String[] args) {
		AddThread addThread = new AddThread();
		addThread.start();
		//使用与不使用join时打印的i结果时不同的。不使用时，主线程不需要等待副线程执行完成，自己就往下执行了。
		try {
//			addThread.join(10, 500000);
			addThread.join();
//			addThread.join(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程执行完毕，i值为："+i);
	}

}
