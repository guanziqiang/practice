package com.gzq.pattern.singleton;

/**
 * 懒汉式方法锁：被动加载，synchronized加锁，防止多线程并发问题。
 * @author zhangxin
 *
 */
public class T2Singleton_1 {
    
    //私有化构造器
    private T2Singleton_1() {
        System.out.println("Singleton pattern private constructor");
    }
    
    //私有静态成员变量，不主动创建
    private static T2Singleton_1 instance = null;
    
    //返回单例的公共方法，在获取时被动加载。该方法加锁。
    public synchronized static T2Singleton_1 getInstance() {
        if(instance == null) {
            return instance = new T2Singleton_1();
        }else {
            return instance;
        }
    }
    
    
}
