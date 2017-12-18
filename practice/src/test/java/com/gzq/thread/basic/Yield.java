package com.gzq.thread.basic;

/**
 * 验证yield可以让出CPU
 * @author GeYi
 *     public static native void yield();
 * 让当前调用的线程让出CPU，但是不代表之后不再竞争CPU资源。
 *
 */
public class Yield {
	
	public static class yThread extends Thread{
		@Override
		public void run() {
			long begin = System.currentTimeMillis();
			for(int i=0; i<1000000; i++) {
				Thread.yield();//注释和不注释的耗时比较
			}
			long end = System.currentTimeMillis();
			System.out.println("总共耗时：" + (end - begin) );
		}
	}
	
	public static void main(String[] args) {
		yThread ythread = new yThread();
		ythread.start();
		System.out.println("main end!");
	}

}
