package com.gzq.thread.basic.create;

/**
 * 通过实现Runnable接口来创建自己的线程。
 * @author GeYi
 *
 */
public class ImplementsRunnable {
    
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("main thread: " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }
    
}
