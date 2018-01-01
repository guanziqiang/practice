package com.gzq.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试，周期性调度的线程池
 * @author GeYi
 *
 */
public class ScheduledTest {
	public static void main(String[] args) {
		ScheduledExecutorService sPool = Executors.newScheduledThreadPool(10);
		sPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(6000);//当任务的执行时间超过周期时，下一个任务不会执行。
					System.out.println(System.currentTimeMillis() / 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
	}

}
