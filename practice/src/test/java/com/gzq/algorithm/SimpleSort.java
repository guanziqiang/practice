package com.gzq.algorithm;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * 简单排序：冒泡、选择插入排序算法的测试案例。
 * @author GeYi
 *
 */
public class SimpleSort {
	//统一测试数据 
	//{1,2,3,4,5,6,7,8,9,10,11,12}
	//{12,11,10,9,8,7,6,5,4,3,2,1}
	//{34,56,23,45,2,3,7,37,9,0,4,76}
	private static final int[] array = {34,56,23,45,2,3,7,37,9,0,4,76};
	
//	打印需要排序的数组长度
	@Before
	public void before() {
		System.out.println("array.length: "+array.length);
	}
	
//	冒泡排序测试
	@Test
	public void testBubble() {
		int[] blos = Arrays.copyOf(array, array.length);
		int count = 0;
		int yidong = 0;
		for (int i=0; i<blos.length; i++) {
			for(int j=0; j<blos.length-i-1; j++){
				count++;
				if(blos[j+1] > blos[j]){
					yidong++;
					int linshi = blos[j+1];
					blos[j+1] = blos[j];
					blos[j] = linshi;
				}
			}
		}
		
		System.out.println("冒泡 总的比较次数"+count);
		System.out.println("冒泡 总的位置交换次数"+yidong);
		System.out.println("冒泡排序后的位置"+Arrays.toString(blos));
	}
	
	//选择排序
	@Test
	public void testSelect(){
		int[] blos = Arrays.copyOf(array, array.length);
		int count = 0;
		int jihuan = 0;
		for(int i=0; i<blos.length; i++){
			int least = i;
			for(int j=i; j<blos.length-1; j++){
				count++;
				if(blos[j] < blos[j+1]){
					least = j+1;
				}
			}
			if(i != least){
				jihuan++;
				int j = blos[least];
				blos[least] = blos[i];
				blos[i] = j;
			}
		}
		System.out.println("选择排序 总的比较次数"+count);
		System.out.println("选择排序移动次数： "+jihuan);
		System.out.println("选择排序移动次数： "+Arrays.toString(blos));
	}
	
	//插入排序
	@Test
	public void testInsert(){
		int[] blos = Arrays.copyOf(array, array.length);
		int count = 0;
		int yidong = 0;
		for(int i=1; i<blos.length; i++){
			int linshi = blos[i];
			for(int j=i-1; j>=0; j--){
				count++;
				if(blos[j] < linshi){
					yidong++;
					blos[j+1] = blos[j];
					if(j==0){//插入到第一位
						blos[0] = linshi;
					}
				}else{//插入后结束本次内循环
					blos[j+1] = linshi;
					break;
				}
				
			}
		}
		System.out.println("插入排序总的比较次数："+count);
		System.out.println("插入排序总的移动次数 " + yidong);
		System.out.println("插入排序移动次数： "+Arrays.toString(blos));
	}
}
