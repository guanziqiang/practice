package com.gzq.thread.basic.create;

/**
 * 测试currentThread方法，以及真实的线程与Thread对象的关系。
 * @author GeYi
 *
 */
public class T3CurrentThread extends Thread {
    @Override
    public void run() {

        System.out.println(
                "通过this打印thread的name和id " + this.getName() + " - " + this.getId());
        System.out.println("Thread.currentThread()打印thread的那么和id。 "
                + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
        System.out.println("=============");
        System.out.println("通过this打印thread的hashcode:  " + this.hashCode());
        System.out.println("通过Thread.currentThread()打印thread的hashcode:  "
                + Thread.currentThread().hashCode());
    }

    public static void main(String[] args) {
        T3CurrentThread threadObject = new T3CurrentThread();
        // 分别使用start和run查看运行的结果
        // threadObject.start();
        threadObject.run();
        System.out.println("主线程的name和id: " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }

}
