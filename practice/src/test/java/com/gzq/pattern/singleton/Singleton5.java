package com.gzq.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 反序列化时打破单例的问题
 * @author zhangxin
 */
public class Singleton5 implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    String name;

    private static Singleton5 instance = new Singleton5();

    private Singleton5() {
        if(instance != null) {
            throw new RuntimeException("创建了多个单例");
        }
        System.out.println("创建单例");
        name = "单例";
    }

    public static Singleton5 getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("");
    }

    //反序列化时，如果定义了该方法。则虚化化的实例有该方法返回。可以解决反序列化时，单例被打破的问题。
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton5 s1 = null;
        Singleton5 s2 = Singleton5.getInstance();
        
        try {
            FileOutputStream fos = new FileOutputStream("D:\\testdata\\Singleton5.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            
            
            FileInputStream fis = new FileInputStream("D:\\testdata\\Singleton5.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Singleton5) ois.readObject();
            ois.close();
            
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
