package com.gzq.thread.basic.synchronized_;

/**
 * 测试synchronized在同一个监视上时可以重入的.
 * thread1先进入syn1，然后在通过syn1直接调用syn2是不需要再次获取锁的。
 * thread2直接进入syn2，犹豫锁被thread1占有了，所以不能进入。
 * @author GeYi
 *
 */
public class T1Reenter {
    
    public synchronized void syn1() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("syn1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syn2();
    }
    
    public synchronized void syn2() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("syn2");
    }
    
    public static void main(String[] args) {
        T1Reenter t1Reenter = new T1Reenter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                t1Reenter.syn1();
            }
        };
        t1.setName("thread1");
        t1.start();
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                t1Reenter.syn2();
            }
        };
        t2.setName("thread2");
        t2.start();
    }

}
