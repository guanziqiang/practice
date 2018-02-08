package com.gzq.thread.basic;

import java.util.Random;

public class Daemon extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("守护线程");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.setDaemon(true);
		daemon.start();
		for(int i=0; i<5; i++) {
			new Daemon2().start();
		}
//		daemon.setDaemon(true);设置守护线程不能在start之后。否则会抛出异常（java.lang.IllegalThreadStateException）
//		，而且线程会以用户线程的方式已经运行。
		System.out.println("main end");
	}

}

class Daemon2 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(8)*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("非守护线程结束 " + this.getName());
	}
}