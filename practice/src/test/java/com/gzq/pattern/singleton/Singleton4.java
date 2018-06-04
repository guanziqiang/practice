package com.gzq.pattern.singleton;

/**
 * 枚举实现单例
 * @author zhangxin
 *
 */
public enum Singleton4 {
    INSTANCE;//天生的单例
    
    private String name = "enumName";
    
    public void getInstance() {
        System.out.println("enum singleton" + name);
    }
    
    public static void main(String[] args) {
       Singleton4.INSTANCE.getInstance();
       System.out.println(Singleton4.INSTANCE.name);
    }
}

