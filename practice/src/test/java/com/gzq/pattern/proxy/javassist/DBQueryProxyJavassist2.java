package com.gzq.pattern.proxy.javassist;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

public class DBQueryProxyJavassist2{

    public static IDBQuery createProxy() throws CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool mPool = new ClassPool(true);
        
        CtClass mCtc = mPool.makeClass("DBQueryProxyJavassist2CodeDynamic");
        
        mCtc.addInterface(mPool.makeClass(IDBQuery.class.getName()));
        
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        
        mCtc.addField(CtField.make("public "+IDBQuery.class.getName()+" query;", mCtc));// public IDBQuery query = null;
        
        String dbqueryname = DBQuery.class.getName();
        String src = "public Object get() { if(query == null) {\r\n" + 
                "            query = new "+dbqueryname+"();\r\n" + 
                "        }\r\n" + 
                "        return query;}";
        CtMethod make = CtNewMethod.make(src, mCtc);
        mCtc.addMethod(make);
        
        Class pc = mCtc.toClass();
        IDBQuery proxy = (IDBQuery) pc.newInstance();
        
        return proxy;
    }

}
