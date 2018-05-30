package com.gzq.thread.basic;

public class RunExceptionTest001 {
    
    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                throw new Error("自定义error错误");
            }
            
        }).start();
    }

}
