package com.gzq.algorithm;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * ������ð�ݡ�ѡ����������㷨�Ĳ��԰�����
 * @author GeYi
 *
 */
public class SimpleSort {
	//ͳһ�������� 
	//{1,2,3,4,5,6,7,8,9,10,11,12}
	//{12,11,10,9,8,7,6,5,4,3,2,1}
	//{34,56,23,45,2,3,7,37,9,0,4,76}
	private static final int[] array = {34,56,23,45,2,3,7,37,9,0,4,76};
	
//	��ӡ��Ҫ��������鳤��
	@Before
	public void before() {
		System.out.println("array.length: "+array.length);
	}
	
//	ð���������
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
		
		System.out.println("ð�� �ܵıȽϴ���"+count);
		System.out.println("ð�� �ܵ�λ�ý�������"+yidong);
		System.out.println("ð��������λ��"+Arrays.toString(blos));
	}
	
	//ѡ������
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
		System.out.println("ѡ������ �ܵıȽϴ���"+count);
		System.out.println("ѡ�������ƶ������� "+jihuan);
		System.out.println("ѡ�������ƶ������� "+Arrays.toString(blos));
	}
	
	//��������
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
					if(j==0){//���뵽��һλ
						blos[0] = linshi;
					}
				}else{//��������������ѭ��
					blos[j+1] = linshi;
					break;
				}
				
			}
		}
		System.out.println("���������ܵıȽϴ�����"+count);
		System.out.println("���������ܵ��ƶ����� " + yidong);
		System.out.println("���������ƶ������� "+Arrays.toString(blos));
	}
}
