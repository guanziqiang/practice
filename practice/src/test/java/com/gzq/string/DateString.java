package com.gzq.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 测试SimpleDateFormat字符窜转日期
 * @author Administrator
 *
 */
public class DateString {
	public static Date date;
	
	@Test
	public void test() {
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(null);
			System.out.println(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println(date);
	}

}
