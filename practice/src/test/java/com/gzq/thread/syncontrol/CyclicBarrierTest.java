package com.gzq.thread.syncontrol;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环的栅栏
 * 1，可以指定栅栏的位置
 * 2，可以重复使用
 * 3，当达到条件时可以调用指定的Runnable
 * @author GeYi
 */
public class CyclicBarrierTest {

	public static class Soldier implements Runnable {
		private String solder;
		private final CyclicBarrier cyclicBarrier;

		public Soldier(CyclicBarrier cyc, String name) {
			this.cyclicBarrier = cyc;
			this.solder = name;
		}

		@Override
		public void run() {
			try {
				cyclicBarrier.await();//等待全部线程集合
				doWork();
				cyclicBarrier.await();//等待全部线程完成（上次已经把栅栏置0了）。
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		void doWork() {
			try {
				Thread.sleep(1300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(solder + "完成");
		}
	}

	public static class BarrierRun implements Runnable {
		boolean flag;
		int N;

		public BarrierRun(boolean flag, int N) {
			this.flag = flag;
			this.N = N;
		}

		@Override
		public void run() {
			if (flag) {
				System.out.println(N + "个线程任务完成");
			} else {
				System.out.println(N + "个线程集合完毕");
				flag = true;
			}
		}
	}

	public static void main(String[] args) {
		final int N = 6;
		boolean flag = false;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new BarrierRun(flag, N));//当栅栏中线程个数满足条件时，则调用传入的Runnable
//		CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

		Thread[] all = new Thread[N];
		for (int i = 0; i < N; i++) {
			System.out.println("线程" + i + "报道");
			all[i] = new Thread(new Soldier(cyclicBarrier, "线程" + i));
			all[i].start();
		}
	}

}
