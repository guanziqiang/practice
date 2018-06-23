package com.gzq.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 反序列化时打破单例的问题（枚举除外）
 * @author zhangxin
 */
public class T5Singleton implements Serializable {

    //
    private static final long serialVersionUID = 1L;

    String name;

    // 私有静态成员
    private static T5Singleton instance = new T5Singleton();

    //私有化构造器
    private T5Singleton() {
        if(instance != null) {
            //如果创建多个单例则会抛出异常
            throw new RuntimeException("创建了多个单例");
        }
        System.out.println("创建单例");
        name = "单例";
    }

    //公共静态方法返回单例
    public static T5Singleton getInstance() {
        return instance;
    }

    //反序列化时，如果定义了该方法。则反序列化的实例有该方法返回。可以解决反序列化时，单例被打破的问题。
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
        T5Singleton s1 = null;
        T5Singleton s2 = T5Singleton.getInstance();
        
        try {
            //序列化实例s2
            FileOutputStream fos = new FileOutputStream("D:\\testdata\\Singleton5.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            
            //反序列化实例赋值给s1
            FileInputStream fis = new FileInputStream("D:\\testdata\\Singleton5.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (T5Singleton) ois.readObject();
            ois.close();
            
            //判断s1 和 s2是否是同一个对象
            org.junit.Assert.assertEquals(s1, s2);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
