package com.gzq.thread.synch;

public class SynStatic {
	
	public synchronized static void test1 () {
		System.out.println("test1" + Thread.currentThread().getName()+" has entered.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test1" + Thread.currentThread().getName()+" has finished.");
	}
	
	
	public void test2 () {
		synchronized (SynStatic.class) {
			System.out.println(Thread.currentThread().getName()+" has entered.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" has finished.");
		}
	}
	
	public synchronized void test3 () {
		System.out.println("test3 : " + Thread.currentThread().getName()+" has entered.");
		try {
			this.test4();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test3 : " + Thread.currentThread().getName()+" has finished.");
	}
	
	public synchronized void test4 () {
		System.out.println("test4 : " + Thread.currentThread().getName()+" has entered.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test4 : " + Thread.currentThread().getName()+" has finished.");
	}
	
	public static void main(String[] args) {
		final SynStatic static1 = new SynStatic();
		final SynStatic2 static2 = new SynStatic2();
		
		new Thread() {
			@Override
			public void run() {
				static1.test4();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				static1.test4();
			}
		}.start();
	}

}


class SynStatic2 extends SynStatic{
	
	public synchronized void test42 () {
		System.out.println("test42 : " + Thread.currentThread().getName()+" has entered.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test42 : " + Thread.currentThread().getName()+" has finished.");
	}
	
	public synchronized static void test21 () {
		System.out.println("test21" + Thread.currentThread().getName()+" has entered.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test21" + Thread.currentThread().getName()+" has finished.");
	}
	
	public synchronized static void test22 () {
		System.out.println("test22" + Thread.currentThread().getName()+" has entered.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test22" + Thread.currentThread().getName()+" has finished.");
	}
	
}




