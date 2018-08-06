package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 *  测试方法区内存中常量池1,6  和 1.7的创建差别
 * 
 * @author Administrator
 *
 */
public class T4VMMethodArea2 {
    public static void main(String[] args) {
       //jdk1.6的结果为false 1.7和1.8的结果为true
       String str1 = new StringBuilder("计算器").append("软件").toString();
       System.out.println(str1.intern() == str1);
       
       //jdk1.6结果为false 1.7和1.8的记过为false
       String str2 = new StringBuilder("ja").append("va").toString();
       System.out.println(str2.intern() == str2);
       
       /**
        * 原因：1.6中通过new创建StringBuilder对象放在堆中，所以intern()返回的字符串常量池的引用 与 str1的不同。
        * 1.7和1.8则  在JDK1.7的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用因此str1.intern() == str1为ture。
        * str2.intern() == str2为false时因为在执行main函数之前jvm已经执行了很多事情了加载各种jar等等操作，所以有了java这个字符串，不是首次创建。
        */
       
    }
}
