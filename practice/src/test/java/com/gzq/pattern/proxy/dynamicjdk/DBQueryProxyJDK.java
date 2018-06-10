package com.gzq.pattern.proxy.dynamicjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的方式实现动态代理
 * @author zhangxin
 *
 */
public class DBQueryProxyJDK implements InvocationHandler {
    IDBQuery query = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (query == null) {
            query = new DBQuery();
        }
        Object object = null;
        if(method.getName().equals("get")) {
            query.get();
        }
        
        return object;
    }

    public static IDBQuery createProxy() {
        IDBQuery proxy = (IDBQuery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[] { IDBQuery.class }, new DBQueryProxyJDK());
        return proxy;
    }

}
