package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） 静态内部类,调用test时内部类不会被加载。因为类加载时完成实例创建，故对线程天生友好。
 * 
 * @author zhangxin
 *
 */
public class M3Singleton {
    private M3Singleton() {
        System.out.println("Singleton pattern private constructor");
    }

    private static class SingletonHolder {
        private static M3Singleton instance = new M3Singleton();
    }

    public static M3Singleton getInstance() {
        return SingletonHolder.instance;
    }
    
    public static void test() {
        System.out.println("test");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        M3Singleton.test();
        M3Singleton instance = M3Singleton.getInstance();
    }

}
