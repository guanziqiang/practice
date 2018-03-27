package com.gzq.reflect;

import java.lang.reflect.Field;

import com.gzq.thread.ThisEscope;

/**
 * 通过反射的方式修改类私有属性的变量案例。
 * @author GeYi
 *
 */
public class Test11 {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        ThisEscope thisEscope = new ThisEscope();
        System.out.println(thisEscope.getName());
        Class<? extends ThisEscope> class1 = thisEscope.getClass();
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
//            field.setAccessible(true);//设置反射的访问权限
            System.out.println(field.getName());
            if (field.getName().equals("name")) {
                field.set(thisEscope, "b");
            }
        }
        System.out.println(thisEscope.getName());
    }
}
