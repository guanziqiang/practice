package com.gzq.thread.basic.stop;


public class T1Stop {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
               while(true) {
                   System.out.println(Thread.currentThread().getName());
               }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
        
    }
}
