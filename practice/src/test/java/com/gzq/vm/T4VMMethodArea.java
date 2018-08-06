package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试方法区内存中常量池 导致的溢出1
 * -XX:PermSize=10M 设置方法区内存启动时的大小 
 * -XX:MaxPermSize=10M 设置方法去内存最大的取值
 * java1.6中会报错
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
    at java.lang.String.intern(Native Method)
    at com.gzq.vm.T4VMMethodArea.main(T4VMMethodArea.java:16)
 * 
 * @author Administrator
 *
 */
public class T4VMMethodArea {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern()); 
        }
    }
}
