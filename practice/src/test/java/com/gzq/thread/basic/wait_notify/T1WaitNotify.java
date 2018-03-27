package com.gzq.thread.basic.wait_notify;

/**
 * 验证wait、notify方法都需要synchronized监视当前的方法调用的对象。
 * @author GeYi
 *
 */
public class T1WaitNotify {
    public static void main(String[] args) {
        Object object = new Object();
        Object object2 = new Object();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                         System.out.println("===线程开始===");
                        try {
                            object.wait();
                            System.out.println("--接着上次执行---");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.start();
        System.out.println("main thread end");
//        synchronized (object2) {
            object.notifyAll();
            System.out.println("唤醒线程");
//        }
    }
}
