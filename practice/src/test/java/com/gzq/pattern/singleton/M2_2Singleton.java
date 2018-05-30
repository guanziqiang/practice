package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） 双重检查枷锁，保证性能。只有在没创建实例时才枷锁创建实例。
 * @author zhangxin
 *
 */
public class M2_2Singleton {
    private M2_2Singleton() {
        System.out.println("Singleton pattern private constructor");
    }
    
    private volatile static M2_2Singleton instance = null;
    
    /**
     * @return
     */
    public synchronized static M2_2Singleton getInstance() {
        //只有null时才加锁
        if(instance == null) {
            synchronized (M2_2Singleton.class) {
                if(instance == null) {
                    return instance = new M2_2Singleton();
                }
            }
        }
        return instance;
    }
    
    
}
