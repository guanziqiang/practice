package com.gzq.thread.basic.create;


/**
 * start和run的区别。
 * @author GeYi
 *
 */
public class StartAndRun {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
        System.out.println("main thread: " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }
    
//    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        myRunnable.run();
//        System.out.println("main thread: " + Thread.currentThread().getName() + " - "
//                + Thread.currentThread().getId());
//    }
    
}
