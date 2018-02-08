package com.gzq.thread.basic.stop;

/**
 * 测试线程抛出异常后会终止。
 * @author Administrator
 *
 */
public class T2ExceptionStop {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
			    int denominator  = 2000;
				int numerator  = 1;
				while (true) {
				    System.out.println("除数" + denominator  );
				    System.out.println("被除数 " + numerator);
				    int quotient = denominator  / numerator ;
				    System.out.println("商 "+quotient);
				    System.out.println("==============");
				    numerator --;
				}
			}
		};
		thread.start();
	}

}
