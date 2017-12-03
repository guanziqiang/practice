package com.gzq.thread.synch;

public class SynExtends {
	
	public synchronized void printMillis() {
		System.out.println(Thread.currentThread().getName() + " begin : "+ System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "   end : "+ System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		final SynExtends sExtends2 = new SynExtends2();
		new Thread() {
			public void run() {
				sExtends2.printMillis();
			};
		}.start();
		new Thread() {
			public void run() {
				sExtends2.printMillis();
			};
		}.start();
		System.out.println("main end");
	}

}

class SynExtends2 extends SynExtends {
//	@Override
//	public void printMillis() {
//		System.out.println(Thread.currentThread().getName() + " begin : "+ System.currentTimeMillis());
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + "   end : "+ System.currentTimeMillis());
//	}
	
}
