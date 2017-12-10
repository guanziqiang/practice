package com.gzq.thread.itself;

public class WaitNotify {

	public static void main(String[] args) {
		final WaitObject waitObject = new WaitObject();

		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					try {
						System.out.println("wait0 thread start");
						waitObject.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "wait0 thread end");
				}
			};
		}.start();
		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					try {
						System.out.println("wait1 thread start");
						waitObject.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "wait1 thread end");
				}
			};
		}.start();
		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					try {
						System.out.println("wait2 thread start");
						waitObject.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "wait2 thread end");
				}
			};
		}.start();
		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					try {
						System.out.println("wait3 thread start");
						waitObject.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("wait3 thread end");
				}
			};
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					System.out.println("notify thread start");
					waitObject.notify();
					System.out.println("notify thread end");
				}
			};
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (waitObject) {
					System.out.println("notifyAll thread start");
					waitObject.notifyAll();
					System.out.println("notifyAll thread end");
				}
			};
		}.start();

	}

	private static class WaitObject {

		public synchronized void testWait() {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public synchronized void testNotify() {
			this.notify();
		}
		
		public synchronized void testnotifyAll() {
			this.notifyAll();
		}

		public static void main(String[] args) {
			final WaitObject waitObject = new WaitObject();

			new Thread() {
				@Override
				public void run() {
					System.out.println("wait0 thread start");
					waitObject.testWait();
					System.out.println("wait0 thread end");
				}
			}.start();
			new Thread() {
				@Override
				public void run() {
					System.out.println("wait1 thread start");
					waitObject.testWait();
					System.out.println("wait1 thread end");
				}
			}.start();
			new Thread() {
				@Override
				public void run() {
					System.out.println("wait2 thread start");
					waitObject.testWait();
					System.out.println("wait2 thread end");
				}
			}.start();

			new Thread() {
				@Override
				public void run() {
						System.out.println("notify thread start");
						waitObject.testNotify();
						System.out.println("notify thread end");
				};
			}.start();

			new Thread() {
				@Override
				public void run() {
						System.out.println("notifyAll thread start");
						waitObject.testnotifyAll();
						System.out.println("notifyAll thread end");
				};
			}.start();
		}

	}

}
