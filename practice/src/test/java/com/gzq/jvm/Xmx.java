package com.gzq.jvm;

import java.util.Vector;

public class Xmx {
    
    public static void main(String[] args) {
        Vector vector = new Vector<>();
        for(int i=1; i<=10; i++) {
            byte[] b = new byte[1024*1024];
            vector.add(b);
            System.out.println("已使用内存（M）" + i);
        }
        System.out.println("系统可用的最大堆内存(M)： " + Runtime.getRuntime().maxMemory()/1024/1024);
    }

}
