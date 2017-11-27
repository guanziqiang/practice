package com.gzq.thread.stop;

public class InterruptedExceptionStop extends Thread{
	
	@Override
	public void run() {
		try {
			for(int i=0; i<300; i++) {
				System.out.println(i);
				if( this.isInterrupted() ) {
					System.out.println("异常法终止线程");
					throw new InterruptedException();
					//break; break 只会退出循环。还会继续执行循环以外的run方法部分。
				}
				
			}
			System.out.println("这里如果还有个for循环，还是不会退出的");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws java.lang.InterruptedException {
		InterruptedExceptionStop exception = new InterruptedExceptionStop();
		exception.start();
		Thread.sleep(10);
		exception.interrupt();
	}

}
