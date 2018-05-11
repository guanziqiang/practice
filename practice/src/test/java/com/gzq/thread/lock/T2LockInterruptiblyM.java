package com.gzq.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 验证ReentrantLock的lockInterruptibly()方法的可中断性 ，并与lock()进行比较。
 * 案例逻辑：
 * 让两个线程形成死锁，先各自获取一个锁，然后再请求对方占有的锁来造成死锁的情况。
 * 在以上情况下分别使用lock()和lockInterruptibly()然后中断其中一个线程看程序运行的结果。
 * @author GeYi
 *
 */
public class T2LockInterruptiblyM {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lockInterruptibly();
//                    lock.lock();
                    System.out.println("t1获取到锁1");
                    Thread.sleep(3000);
                    lock2.lockInterruptibly();
//                    lock2.lock();
                    System.out.println("t1获取到锁2");
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("t1 异常挂掉");
                } finally {
                    if(lock.isHeldByCurrentThread()) { //判断是否持有锁，有则释放。
                        lock.unlock();                        
                    }
                    if (lock2.isHeldByCurrentThread()) {
                        lock2.unlock();
                    }
                }
            }
        });
        
        t1.start();
        
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock2.lockInterruptibly();
//                    lock2.lock();
                    System.out.println("t2获取到锁2");
                    Thread.sleep(2000);
                    lock.lockInterruptibly();
//                    lock.lock();
                    System.out.println("t2获取到锁1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("t2 异常挂掉");
                } finally {
                    if(lock.isHeldByCurrentThread()) {
                        lock.unlock();                        
                    }
                    if (lock2.isHeldByCurrentThread()) {
                        lock2.unlock();
                    }
                }
            }
        });
        
        t2.start();
        
        Thread.sleep(5000);
        t2.interrupt();//向T2发起中断
        
        
    }
}
