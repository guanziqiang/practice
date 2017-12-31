package com.gzq.thread.syncontrol;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 验证读写分离的锁。尤其时在读很多（或者很耗时）的情况下，使用读写分离效率很高。
 * @author GeYi
 *
 */
public class ReadWriteLockTest {

	private static int value = 0;

	public int readValue(Lock lock) throws InterruptedException {

		try {
			lock.lock();
			Thread.sleep(2000);
			return value;
		} finally {
			lock.unlock();
		}
	}

	public void writeValue(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			value++;
			System.out.println("value: " + value);
		} finally {
			lock.unlock();
		}
	}

	static class Daemon extends Thread {
		@Override
		public void run() {
			long start = System.currentTimeMillis();
			while (true) {
				long end = System.currentTimeMillis();
				System.out.println("time: " + (end - start));
			}

		}
	}

	public static void main(String[] args) {

		ReentrantLock reentrantLock = new ReentrantLock();

		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		@SuppressWarnings("unused")
		Lock readLock = readWriteLock.readLock();
		@SuppressWarnings("unused")
		Lock writeLock = readWriteLock.writeLock();

		final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
		Runnable runnableR = new Runnable() {
			@Override
			public void run() {
				try {
					 readWriteLockTest.readValue(reentrantLock);
//					 非读写分离
//					readWriteLockTest.readValue(readLock); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnableW = new Runnable() {
			@Override
			public void run() {
				try {
//					 非读写分离
					 readWriteLockTest.writeValue(reentrantLock);
//					readWriteLockTest.writeValue(writeLock);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Daemon daemon = new Daemon();
		daemon.setDaemon(true);
		daemon.start();
		for (int i = 0; i < 15; i++) {
			new Thread(runnableR).start();
		}
		for (int i = 0; i < 15; i++) {
			new Thread(runnableW).start();
		}

	}

}
