package com.gzq.thread.basic.group;

/**
 * 测试一个ThreadGroup的helloWorld
 * @author GeYi
 *
 */
public class ThreadGroupTest implements Runnable{
	
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
		Thread thread1 = new Thread(threadGroup,new ThreadGroupTest(),"thread1");
		Thread thread2 = new Thread(threadGroup,new ThreadGroupTest(),"thread2");
		thread1.start();
		thread2.start();
		System.out.println(threadGroup.activeCount());
		threadGroup.list();
	}

	@Override
	public void run() {
		String groupAndName = Thread.currentThread().getThreadGroup().getName();
		while (true) {
			System.out.println(Thread.currentThread().getName() + "work in the " + groupAndName);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
