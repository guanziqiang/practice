package com.gzq.thread.basic.stop;

public class Stop {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread.stop();
        
    }
}
