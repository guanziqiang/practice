package com.gzq;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DeliberatePractice {
    
    private static ReentrantReadWriteLock rWLock = new ReentrantReadWriteLock();
    private static ReadLock readLock = rWLock.readLock();
    private static WriteLock writeLock = rWLock.writeLock();
    
    private static ReentrantLock reLock = new ReentrantLock();
    
    public void read(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public void write(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        DeliberatePractice dp = new DeliberatePractice();
        
        Runnable writeRun = new Runnable() {
            @Override
            public void run() {
//                dp.write(writeLock);
                dp.write(reLock);
            }
        };
        Runnable readRun = new Runnable() {
            @Override
            public void run() {
//                dp.read(readLock);
                dp.write(reLock);
            }
        };
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                long count = 0;
                try {
                    while(true) {
                        count++;
                        System.out.println(count);
                    }
                } finally {
                    System.out.println(count);
                }
            }
        };
        
        thread.setDaemon(true);
        thread.start();
        
        
        for(int i=0; i<18; i++) {
            new Thread(readRun).start();
        }
        for(int i=0; i<2; i++) {
            new Thread(writeRun).start();
        }
        
        
        
    }
    
}
