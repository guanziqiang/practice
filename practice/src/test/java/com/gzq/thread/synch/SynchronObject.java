package com.gzq.thread.synch;

public class SynchronObject {
	
	private int num = 0;
	
	//synchronized同步与不同步
	public synchronized void printNum(String name) {
		if(name.equals("a")) {
			num = 100;
			System.out.println("a num :" + num);
		}else{
			num = 200;
			System.out.println("b num :" + num);
		}
	}

}
