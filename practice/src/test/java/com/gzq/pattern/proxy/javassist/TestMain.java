package com.gzq.pattern.proxy.javassist;

public class TestMain {
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IDBQuery createProxy = DBQueryProxyJavassist.createProxy();
        System.out.println("延时加载");
        createProxy.get();
    }

}
