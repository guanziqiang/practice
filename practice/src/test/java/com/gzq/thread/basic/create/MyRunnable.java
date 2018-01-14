package com.gzq.thread.basic.create;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);//让当前线程休眠2000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread还在工作。 " + Thread.currentThread().getName()
                    + " - " + Thread.currentThread().getId());
        }
    }
}
