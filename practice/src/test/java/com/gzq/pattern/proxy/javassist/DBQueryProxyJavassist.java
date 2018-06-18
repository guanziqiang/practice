package com.gzq.pattern.proxy.javassist;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class DBQueryProxyJavassist implements MethodHandler{
    private DBQuery query = null;

    @Override
    public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
            throws Throwable {
        if(query == null) {
            query = new DBQuery();
        }
        return query.get();
    }
    
    public static IDBQuery createProxy() throws InstantiationException, IllegalAccessException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[] {IDBQuery.class});
        Class createClass = proxyFactory.createClass();
        IDBQuery idbQuery = (IDBQuery) createClass.newInstance();
        ((ProxyObject)idbQuery).setHandler(new DBQueryProxyJavassist());
        return idbQuery;
    }

}
