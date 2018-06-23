package com.gzq.pattern.singleton;

/**
 * 枚举实现单例
 * @author zhangxin
 *
 */
public enum T4Singleton {
    INSTANCE;//天生的单例
    
    private String name = "enumName";
    
    public void getInstance() {
        System.out.println("enum singleton" + name);
    }
    
    public static void main(String[] args) {
       T4Singleton instance2 = T4Singleton.INSTANCE;
       System.out.println(instance2);
    }
}

