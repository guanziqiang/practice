package com.gzq.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 验证ReentrantLock的lock()方法的可重入性。
 * @author GeYi
 *
 */
public class T1LockM {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    lock.lock();//可以再一次获取已经得到的锁，即为重入性。
                    
                    System.out.print("锁可重入");
                    
                }finally {
                    lock.unlock();
                    lock.unlock();//获取了几次锁，就必须的释放几次。
                }
            }
        }).start();
        
        
    }
}
