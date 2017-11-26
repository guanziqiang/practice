package com.gzq.thread.itself;

/**
 * Causes the currently executing thread to sleep (temporarily cease
 * execution) for the specified number of milliseconds, subject to
 * the precision and accuracy of system timers and schedulers. The thread
 * does not lose ownership of any monitors.
 *
 * @param  millis
 *         the length of time to sleep in milliseconds
 *
 * @throws  IllegalArgumentException
 *          if the value of {@code millis} is negative
 *
 * @throws  InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
public static native void sleep(long millis) throws InterruptedException;
 */
public class Sleep extends Thread{
	
	@Override
	public void run() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(1000);
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
	}

}
