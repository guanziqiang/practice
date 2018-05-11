package com.gzq.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

public class BitTest {
    
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        newFixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("....");
                }
                
            }
        });
        newFixedThreadPool.execute(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("my Runnable");                
            }
        });
        
    }

}
