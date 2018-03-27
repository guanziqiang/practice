package com.gzq.jvm;

public class StackTest1 {
    private static long count = 0;
    
    public void statck() {
        count++;
        statck();
    }
    
    public static void main(String[] args) {
        try {
            new StackTest1().statck();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(count);//16754
    }

}
