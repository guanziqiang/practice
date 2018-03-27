package com.gzq.pattern.proxy.v3;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MCGLIBDBServiceInterceptor implements MethodInterceptor {
    private DBService dbService = null;

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3)
            throws Throwable {
        if(dbService == null) 
            dbService = new DBServiceImpl();
        return dbService.request();
    }
    
    public static DBService createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MCGLIBDBServiceInterceptor());
        enhancer.setInterfaces(new Class[] {DBService.class});
        DBService dbService = (DBService) enhancer.create();
        return dbService;
    }

}
