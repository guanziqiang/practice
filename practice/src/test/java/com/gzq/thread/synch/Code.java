package com.gzq.thread.synch;

/**
 * 使用synchronized同步语句块，提高执行的效率。
 * @author Administrator
 */
public class Code {
	
	public static void main(String[] args) {
		CodeTask task = new CodeTask();
		CodeT1 t1 = new CodeT1(task);
		CodeT2 t2 = new CodeT2(task);
		t1.start();
		t2.start();
	}

}

class CodeTask{
	private String data1;
	private String data2;
	
	//把方法的synchronized 移步到内部的语句块中去。
	public void test() {
		System.out.println("com.gzq.thread.synch.CodeTask.test() begin");
		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 String localD1 = "长时间处理任务后从远程返回的值1 threadName为：" + Thread.currentThread().getName();
		 String localD2 = "长时间处理任务后从远程返回的值2 threadName为：" + Thread.currentThread().getName();
		synchronized(this) {//成对注释块级锁，给发放加上synchronized查看不同的效果
			data1 = localD1;
			data2 = localD2;
			System.out.println(data1);
			System.out.println(data2);
		}
		
		System.out.println("com.gzq.thread.synch.CodeTask.test() end");
	}
	
}

class CodeT1 extends Thread{
	private CodeTask codeTask;
	
	public CodeT1(CodeTask codeTask) {
		this.codeTask = codeTask;
	}
	
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		codeTask.test();
		long end = System.currentTimeMillis();
		System.out.println("T1 costed time: " + (end-begin));
	}
}

class CodeT2 extends Thread{
	private CodeTask codeTask;
	
	public CodeT2(CodeTask codeTask) {
		this.codeTask = codeTask;
	}
	
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		codeTask.test();
		long end = System.currentTimeMillis();
		System.out.println("T2 costed time: " + (end-begin));
	}
}


