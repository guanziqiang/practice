package com.gzq.jvm;

public class StackTest3 {

    @SuppressWarnings("unused")
    public void statck() {
        {
            long b = 2;
        }
        long c = 3;
    }

    @SuppressWarnings("unused")
    public void statck2() {
        long b = 2;
        long c = 3;
    }

}
