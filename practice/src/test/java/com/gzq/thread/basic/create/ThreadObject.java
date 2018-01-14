package com.gzq.thread.basic.create;

public class ThreadObject extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);//让当前线程休眠2000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("MyThread还在工作1。 " + this.getName() + " - " + this.getId());
            System.out.println("MyThread还在工作2。 " + Thread.currentThread().getName()
                    + " - " + Thread.currentThread().getId());
            
            System.out.println("MyThread:  " + this.hashCode());
            System.out.println("currentThread: 。 " + Thread.currentThread().hashCode());
        }
    }
    
    public static void main(String[] args) {
        ThreadObject threadObject = new ThreadObject();
        //分别使用start和run查看运行的结果
        threadObject.start();
//        threadObject.run();
        System.out.println("main thread: " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }

}
