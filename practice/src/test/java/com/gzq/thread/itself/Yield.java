package com.gzq.thread.itself;

public class Yield extends Thread{
	
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			//随便干点啥
			double result = 1*1;
			Thread.yield();//注释和不注释的耗时比较
		}
		long end = System.currentTimeMillis();
		System.out.println("总共耗时：" + (end - begin) );
	}
	
	public static void main(String[] args) {
		Yield yield = new Yield();
		yield.start();
		System.out.println("main end!");
	}

}
