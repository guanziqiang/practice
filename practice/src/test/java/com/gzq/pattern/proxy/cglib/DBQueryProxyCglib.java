package com.gzq.pattern.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib完成动态代理模式
 * @author zhangxin
 *
 */
public class DBQueryProxyCglib implements MethodInterceptor{
    private IDBQuery query = null;

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3)
            throws Throwable {
        if(query == null) {
            query = new DBQuery();
        }
        return query.get();
    }
    
    public static IDBQuery creatProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DBQueryProxyCglib());
        enhancer.setInterfaces(new Class[] {IDBQuery.class});
        Object create = enhancer.create();
        return (IDBQuery) create;
    }

}
