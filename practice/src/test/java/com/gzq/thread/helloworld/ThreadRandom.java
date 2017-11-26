package com.gzq.thread.helloworld;

public class ThreadRandom extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			int time = (int)(Math.random() * 1000);
			try {
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadRandom random = new ThreadRandom();
		random.start();
		
		for(int i = 0; i<10; i++) {
			int time = (int)(Math.random() * 1000);
			try {
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
