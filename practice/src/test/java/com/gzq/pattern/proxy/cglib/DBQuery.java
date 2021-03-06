package com.gzq.pattern.proxy.cglib;

import java.util.ArrayList;
import java.util.List;

public class DBQuery implements IDBQuery {
    
    public DBQuery() {
        System.out.println("被代理对象的创建非常耗时");
    }

    @Override
    public List<String> get() {
        return new ArrayList<>();
    }

    @Override
    public String list(String name) {
        return "list 方法";
    }

}
