package com.gzq.pattern.singleton;

/**
 * 懒汉式双重检验: 双重检查枷锁，保证性能。只有在没创建实例时才枷锁创建实例。
 * @author zhangxin
 *
 */
public class T2Singleton_2 {
    
    //私有化构造器
    private T2Singleton_2() {
        System.out.println("Singleton pattern private constructor");
    }
    
    //私有静态成员变量，不主动创建。 volatile是为了解决双重检验中new操作为非原子性的问题。
    private volatile static T2Singleton_2 instance = null;
    
    //双重检验的方法
    public static T2Singleton_2 getInstance() {
        //只有null时才进入加锁创建实例的操作
        if(instance == null) { //【步骤0】
            synchronized (T2Singleton_2.class) {
                if(instance == null) {
                    /*
                     * new操作为非原子性：可能发生
                     * 1，内存 memory = allocate(); 分配内存空间
                     * 2，instance = memory; 此时instance有引用不是null，但是又尚未完成初始化。
                     * 3，T2Singleton_2()执行构造函数。
                     * 在伪代码2完成3尚未完成时，有另外一个线程在【步骤0】中可能返回一个错误的未被初始化好的实例而产生错误。
                     * 而这个错误可以在成员变量中家volatile解决（jdk1.5的volatile关键字才能确保没有问题）。
                     */
                    return instance = new T2Singleton_2();
                }
            }
        }
        return instance;
    }
    
    
}
