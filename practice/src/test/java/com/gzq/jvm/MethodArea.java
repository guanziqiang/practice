package com.gzq.jvm;

public class MethodArea {
    
    //-XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails
    public static void main(String[] args) {
        for(int i=0; i < Integer.MAX_VALUE; i++) {
            String tString = String.valueOf(i).intern();
        }
    }

}
