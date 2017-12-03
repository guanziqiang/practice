package com.gzq.thread.itself;

import java.util.Random;

public class Daemon extends Thread{
	
	@Override
	public void run() {
		long count = 0;
		for(int i=0; i<10; i++) {
			count++;
			count += new Random().nextInt();
		}
		System.out.println("非守护线程结束");
	}
	
	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			new Daemon().start();
		}
		Daemon2 daemon2 = new Daemon2();
		daemon2.setDaemon(true);
		daemon2.start();
		System.out.println("main end");
	}

}

class Daemon2 extends Thread{
	@Override
	public void run() {
		long count = 0;
		while (true) {
			count++;
			count += new Random().nextInt();
			count /=2;
			System.out.println("正在守护中。。。");
		}
	}
}
