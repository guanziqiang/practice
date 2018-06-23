package com.gzq.pattern.singleton;

/**
 * 被动加载（懒汉式） 静态内部类,调用test时内部类不会被加载。因为类加载时完成实例创建，故对线程天生友好。
 * @author zhangxin
 *
 */
public class T3Singleton {
    private T3Singleton() {
        System.out.println("Singleton pattern private constructor");
    }

    //静态内部类（这里public的效果与private效果差不多，建议写成private）
    private static class SingletonHolder {
        private static T3Singleton instance = new T3Singleton();
    }

    //公共方法返回单例
    public static T3Singleton getInstance() {
        return SingletonHolder.instance;
    }
    
    //测试调用test时并不会初始化（public 或 private）内部类，从而达到延时加载的目的
    public static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        T3Singleton.test();//测试是否可以延时加载
    }

}
