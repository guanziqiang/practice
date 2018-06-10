package com.gzq.pattern.proxy.dynamicjdk;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        IDBQuery createProxy = DBQueryProxyJDK.createProxy();
        System.out.println("延时加载");
        List<String> list = createProxy.get();
        System.out.println(list);
    }
}
