package com.gzq.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射打破单例，及其防止方法
 * @author zhangxin
 *
 */
public class T6Singleton {
    
    private static T6Singleton instance = new T6Singleton();
    
    private T6Singleton() {
        if(instance != null) {
            //实例被创建多个时抛出异常禁止继续创建。
            throw new RuntimeException("单例模式被攻击");
        }
    }

    //公共静态方法返回单例
    public static T6Singleton getInstance() {
        return instance;
    }
    
    /**
     * 测试通过反射打破单例的模式
     * @param args
     */
    public static void main(String[] args) {
        //获取T6Singleton类的所有构造器
        Constructor<?>[] constructors = T6Singleton.class.getDeclaredConstructors();
        //便利构造器
        for (Constructor<?> constructor : constructors) {
            //因为这里做演示，所以不详细判断每个构造器的类型了。 直接设置允许访问权限
            constructor.setAccessible(true);
            try {
                //通过反射构造对象，打破单例模式
                T6Singleton newInstance = (T6Singleton)constructor.newInstance();
                System.out.println(T6Singleton.getInstance() == newInstance);
                
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    
}
