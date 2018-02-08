package com.gzq.thread.basic.wait;

/**
 * 验证notify方法的随机唤醒。
 * @author GeYi
 *
 */
public class T2WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            object.wait();
                            System.out.println(
                                    Thread.currentThread().getName() + "--接着上次执行---");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.setName("线程i " + i);
            thread.start();
            Thread.sleep(10);// 保证各个线程都按顺序等待在object的wait区。
        }
        System.out.println("main thread end");
        Thread.sleep(100);
        for (int i = 0; i < 20; i++) {
            synchronized (object) {
                object.notify();
                System.out.println("notify唤醒线程");
            }
        }

//        synchronized (object) {
//            object.notifyAll();
//            System.out.println("notifyAll唤醒线程");
//        }
    }
    
}
