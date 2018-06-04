package com.gzq.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射打破单例
 * @author zhangxin
 *
 */
public class Singleton6 {
    
    private static Singleton6 instance = new Singleton6();
    
    private Singleton6() {
        if(instance != null) {
            //throw new RuntimeException("单例模式被攻击");
        }
    }

    public static Singleton6 getInstance() {
        return instance;
    }
    
    public static void main(String[] args) {
        Constructor<?>[] constructors = Singleton6.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            try {
                Singleton6 newInstance = (Singleton6)constructor.newInstance();
                System.out.println(Singleton6.getInstance() == newInstance);
                
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
