package com.gzq.books.b1;

public class NoVisibility {
    private static boolean ready = false;
    private static int number = 0;
    
    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println(number);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(3000);
        number = 42;
        ready = true;
    }

}
