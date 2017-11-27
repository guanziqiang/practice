package com.gzq.thread.stop;

public class ReturnStop extends Thread{

	@Override
	public void run() {
		while (1 == 1) {
			if(this.isInterrupted()) {
				System.out.println("return 终止线程");
				return;
			}
			System.out.println("ing");
		}
	}
	
	public static void main(String[] args) {
		ReturnStop returnStop = new ReturnStop();
		returnStop.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnStop.interrupt();
	}
}
