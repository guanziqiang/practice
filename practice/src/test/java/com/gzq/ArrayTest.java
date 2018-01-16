package com.gzq;

/**
 * 测试数组的最大定义长度
 * @author Administrator
 *
 */
public class ArrayTest {
	
	public static void main(String[] args) {
		String[] year = new String[Integer.MAX_VALUE];//0x7fffffff
		System.out.println(year);
	}

}
