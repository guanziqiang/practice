package com.gzq.pattern.proxy.javassist;

import java.util.List;

import javassist.CannotCompileException;

public class TestMain2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, CannotCompileException {
        IDBQuery createProxy = DBQueryProxyJavassist2.createProxy();
        System.out.println("延时加载，先获取代理对象");
        List<String> list = createProxy.get();
        System.out.println(list);
    }

}
