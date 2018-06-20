package com.gzq.pattern.proxy.dynamicjdk;

import java.util.List;

/**
 * 使用jdk原生方式实现动态代理
 * @author zhangxin
 *
 */
public class TestMain {

    public static void main(String[] args) {
        IDBQuery createProxy = DBQueryProxyJDK.createProxy();
        System.out.println("延时加载");
        List<String> list = createProxy.get();
        System.out.println(list);
    }
}
