package com.gzq.pattern.proxy.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MJdkDBServiceProxyHandler implements InvocationHandler {
    private DBService dbService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (dbService == null) {
            dbService = new DBServiceImpl();
        }
        return dbService.request();
    }

    public static DBService createJdkProxy() {
        DBService jdkProxy = (DBService) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[] { DBService.class },
                new MJdkDBServiceProxyHandler());
        return jdkProxy;
    }
    
    /**
     * JDK原生的动态代理
     * @param args
     */
    public static void main(String[] args) {
        DBService createJdkProxy = MJdkDBServiceProxyHandler.createJdkProxy();
        String request = createJdkProxy.request();
        System.out.println(request);
    }

}
