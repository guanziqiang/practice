package com.gzq.thread.basic.create;

/**
 * 通过继承Thread类来创建自己的线程。
 * @author GeYi
 *
 */
public class ExtendsThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main thread: " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }

}
