package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） synchronized枷锁防止多线程时产生多个实例。
 * @author zhangxin
 *
 */
public class M2_1Singleton {
    private M2_1Singleton() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private static M2_1Singleton instance = null;
    
    public synchronized static M2_1Singleton getInstance() {
        if(instance == null) {
            return instance = new M2_1Singleton();
        }else {
            return instance;
        }
    }
    
    
}
