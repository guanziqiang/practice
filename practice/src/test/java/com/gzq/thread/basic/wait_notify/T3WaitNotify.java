package com.gzq.thread.basic.wait_notify;

/**
 * 验证wait唤醒之后，同样需要获得锁才能继续运行。
 * 
 * @author GeYi
 *
 */
public class T3WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        object.wait();
                        while (true) {
                            System.out.println(
                                    Thread.currentThread().getName() + "--接着上次执行---");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.setName("线程1");
        thread.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        object.wait();
                        while (true) {
                            System.out.println(
                                    Thread.currentThread().getName() + "--接着上次执行---");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.setName("线程2");
        thread2.start();

        Thread.sleep(10);// 保证各个线程都按顺序等待在object的wait区。
        System.out.println("main thread end");
        Thread.sleep(100);//方便查看等待之前打印的结果
        synchronized (object) {
//            object.notifyAll();
            object.notify();
            System.out.println("notify唤醒线程");
        }

    }

}
