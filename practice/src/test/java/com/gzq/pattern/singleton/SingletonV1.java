package com.gzq.pattern.singleton;

public class SingletonV1 {
    
    private SingletonV1() {
        System.out.println("创建单例对象");
    }
    
//    private static SingletonV1 singletonV1 = new SingletonV1();
    
    public static SingletonV1 getInstance() {
//        return singletonV1;
        return SingletonHolder.singletonV1;
    }
    
    private static class SingletonHolder  {
        
        private static SingletonV1 singletonV1 = new SingletonV1();
    }
    
    public static void sumNum() {
        System.out.println("模拟不调用单例的函数");
    }
    
    /**
     * 通过内部静态类{@code SingletonHolder}的方式创建单例的对象：
     * 1，可以实现延迟的单例加载，即懒汉模式的单例。还可以避免类似于<code>sumNum</code>方法的打扰打扰。
     * 2，且天然的对多线程友好，不需要再单独加入同步机制。
     */
    public static void main(String[] args) {
        SingletonV1 instance = SingletonV1.getInstance();

        //没有调用单例，但是会被默认的触发。
//        SingletonV1.sumNum();
        
        System.out.println(instance);
    }

}
