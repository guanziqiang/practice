package com.gzq.pattern.proxy.v3;

public class DBServiceImpl implements DBService{
    
    public DBServiceImpl() {
        try {
            System.out.println("模拟 连接数据等一系列耗时的操作");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "mysql";
    }

}
