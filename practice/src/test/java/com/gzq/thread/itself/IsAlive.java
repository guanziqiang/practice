package com.gzq.thread.itself;
/**
 * Tests if this thread is alive. A thread is alive if it has
 * been started and has not yet died.
 *
 * @return  <code>true</code> if this thread is alive;
 *          <code>false</code> otherwise.
 * public final native boolean isAlive();
 */
public class IsAlive extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		IsAlive alive = new IsAlive();
		alive.start();
		System.out.println(alive.isAlive());
		Thread.sleep(3000);
		System.out.println(alive.isAlive());
	}
	
}
