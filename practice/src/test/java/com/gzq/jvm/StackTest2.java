package com.gzq.jvm;

public class StackTest2 {
    private static long count = 0;
    
    public void statck(long a,long b, long c) {
        a = 1;
        b = 2;
        c = 3;
        count++;
        statck(a,b,c);
    }
    
    public static void main(String[] args) {
        try {
            new StackTest2().statck(0,0,0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(count);//16800
    }

}
