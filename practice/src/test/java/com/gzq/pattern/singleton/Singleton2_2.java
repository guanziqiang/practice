package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） 双重检查枷锁，保证性能。只有在没创建实例时才枷锁创建实例。
 * @author zhangxin
 *
 */
public class Singleton2_2 {
    private Singleton2_2() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private volatile static Singleton2_2 instance = null;
    
    /**
     * @return
     */
    public synchronized static Singleton2_2 getInstance() {
        //只有null时才加锁
        if(instance == null) {
            synchronized (Singleton2_2.class) {
                if(instance == null) {
                    return instance = new Singleton2_2();
                }
            }
        }
        return instance;
    }
    
    
}
