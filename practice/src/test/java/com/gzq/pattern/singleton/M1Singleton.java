package com.gzq.pattern.singleton;

/**
 * 主动加载（饿汉式） 因为类加载时完成实例创建，故对线程天生友好。
 * @author zhangxin
 *
 */
public class M1Singleton {
    
    private M1Singleton() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private static M1Singleton instance = new M1Singleton();
    
    public static M1Singleton getInstance() {
        return instance;
    }

}
