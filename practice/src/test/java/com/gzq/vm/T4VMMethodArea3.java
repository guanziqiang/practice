package com.gzq.vm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 测试直接让方法区
 *jdk1.6 Exception in thread "Reference Handler" java.lang.OutOfMemoryError: PermGen space
 *jdk1.7  java.lang.OutOfMemoryError: PermGen space
 *jdk1.8 不能复现
 * @author Administrator
 *
 */
public class T4VMMethodArea3 {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args,
                        MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
    
    static class TestObject{
        private static List<String> strings = new ArrayList<String>();
        
        public TestObject() {
            double dd = 0;
            while (true) {
                strings.add(String.valueOf(dd));
            }
        }
    }

}
