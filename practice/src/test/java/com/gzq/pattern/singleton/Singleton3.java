package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） 静态内部类,调用test时内部类不会被加载。因为类加载时完成实例创建，故对线程天生友好。
 * 
 * @author zhangxin
 *
 */
public class Singleton3 {
    private Singleton3() {
        System.out.println("Singleton pattern private constructor");
    }

    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
    
    public static void test() {
        System.out.println("test");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Singleton3.test();
        Singleton3 instance = Singleton3.getInstance();
    }

}
