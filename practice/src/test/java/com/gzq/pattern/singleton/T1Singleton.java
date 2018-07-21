package com.gzq.pattern.singleton;

/**
 * 饿汉式：主动加载,因为类加载时完成实例创建，故对线程天生友好。
 * @author zhangxin
 */
public class T1Singleton {
    //主动创建私有的静态实例，即单例。
    private static T1Singleton instance = new T1Singleton();
    
    //私有化构造器
    private T1Singleton() {
        System.out.println("创建了一个实例");
    }
    
    //公共方法
    public static T1Singleton getInstance() {
        return instance;
    }
    
    public static void main(String[] args) {
        T1Singleton instance1 = T1Singleton.getInstance();
        T1Singleton instance2 = T1Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }

}
