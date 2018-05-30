package com.gzq.pattern.singleton;

/**
 * 枚举实现单例
 * @author zhangxin
 *
 */
public enum M4Singleton {
    INSTANCE;//天生的单例
    
    private String name = "enumName";
    
    public void getInstance() {
        System.out.println("enum singleton" + name);
    }
    
    public static void main(String[] args) {
       M4Singleton.INSTANCE.getInstance();
       System.out.println(M4Singleton.INSTANCE.name);
    }
}

