package com.newrocktech.autoprint.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class ToolUtils {
	
	public static boolean isEmpty(String str){
		if(str!=null && str.trim().length()>0){
			return false;
		}
		return true;
	}
	public static String getDateTime() {
		Date date= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//yyyy-MM-dd HH:mm:ss
		String str = sdf.format(date);
		System.out.println(str);
		return str;
		
		
	}
	public static String getSN567() {
		Date date= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		String month = str.substring(5,7);
		int m = Integer.parseInt(month);
		char mo = (char)(m+64);
		return str.substring(2, 4)+mo;
		
		
	}
}
