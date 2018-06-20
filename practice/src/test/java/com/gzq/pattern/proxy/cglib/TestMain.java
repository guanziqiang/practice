package com.gzq.pattern.proxy.cglib;

import java.util.List;

/**
 * 测试使用cglib实现动态代理
 * @author zhangxin
 *
 */
public class TestMain {
    
    public static void main(String[] args) {
        IDBQuery creatProxy = DBQueryProxyCglib.creatProxy();
        System.out.println("获取代理");
        List<String> list = creatProxy.get();
        System.out.println(list);
    }

}
