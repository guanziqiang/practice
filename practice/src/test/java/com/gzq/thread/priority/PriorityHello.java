package com.gzq.thread.priority;

import java.util.Random;

/**
 * 演示优先级属性大的得到CPU的机会大，执行快。
 * @author GeYi
 *
 */
public class PriorityHello extends Thread{
	private int priority;
	
	public PriorityHello(int priority) {
		this.priority = priority;
	}
	
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		long count = 0;
		for(int i=0; i<999999; i++) {
			Random random = new Random();
			int nextInt = random.nextInt();
			count += nextInt;
			count /= 2;
		}
		long end = System.currentTimeMillis();
		System.out.println(priority + " : " + (end-begin) );
	}
	
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			PriorityHello pHello1 = new PriorityHello(1);
			pHello1.setPriority(1);
			pHello1.start();
			PriorityHello pHello10 = new PriorityHello(10);
			pHello10.setPriority(10);
			pHello10.start();
		}
	}

}
