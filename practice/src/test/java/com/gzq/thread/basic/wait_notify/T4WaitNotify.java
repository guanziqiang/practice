package com.gzq.thread.basic.wait_notify;

/**
 * 让main线程永远等待。
 * @author GeYi
 *
 */
public class T4WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        synchronized (Thread.currentThread()) {
            Thread.currentThread().wait();
        }
        System.out.println("main end");
    }

}
