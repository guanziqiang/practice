package com.gzq.pattern.singleton;

/**
 * 主动加载（饿汉式） 因为类加载时完成实例创建，故对线程天生友好。
 * @author zhangxin
 *
 */
public class Singleton1 {
    
    private Singleton1() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private static Singleton1 instance = new Singleton1();
    
    public static Singleton1 getInstance() {
        return instance;
    }

}
