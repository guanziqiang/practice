package com.gzq.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Assert;

public class SerSingleton implements Serializable{
    private static final long serialVersionUID = 1L;
    
    String name;
    
    private SerSingleton() {
        System.out.println("创建单例对象");
        name = "SerSingleton";
    }
    
    private static SerSingleton serSingleton = new SerSingleton();
    private static SerSingleton getInstance() {
        return serSingleton;
    }
    
    public static void sumNum() {
        System.out.println("模拟不调用单例的函数");
    }
    
    //如果不定义该方法，则反序列化的时候会产生一个新的实例，而不是之前的单实例
    private Object readResolve() {
        return serSingleton;
    }
    
    
    /**
     * 在反序列化的过程中造成的多个单例问题。通过自定义<code>readResolve</code>方法可以解决这一问题。
     * 该案例中采用的是饿汉模式
     */
    public static void main(String[] args) throws Exception {
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();
        
        FileOutputStream fos = new FileOutputStream("d:/SerSingleton.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        
        FileInputStream fis = new FileInputStream("d:/SerSingleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();//如果序列化对象定义了readResolve方法，那么反序列化会主动去调用该方法
        ois.close();
        
        Assert.assertEquals(s, s1);//两个对象如果不想等则报出异常
        
        
    }

}
