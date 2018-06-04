package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） synchronized枷锁防止多线程时产生多个实例。
 * @author zhangxin
 *
 */
public class Singleton2_1 {
    private Singleton2_1() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private static Singleton2_1 instance = null;
    
    public synchronized static Singleton2_1 getInstance() {
        if(instance == null) {
            return instance = new Singleton2_1();
        }else {
            return instance;
        }
    }
    
    
}
