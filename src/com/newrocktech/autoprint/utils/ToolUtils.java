package com.newrocktech.autoprint.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ToolUtils {

	public static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}

	public static String getMacAddress(String mac) {

		return mac.substring(0, 2) + ":" + mac.substring(2, 4) + ":" + mac.substring(4, 6) + "" + ":"
				+ mac.substring(6, 8) + ":" + mac.substring(8, 10) + ":" + mac.substring(10, 12);
	}

	public static String getDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// yyyy-MM-dd
																// HH:mm:ss
		String str = sdf.format(date);
		return str;
	}

	public static String getSN567() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		String month = str.substring(5, 7);
		int m = Integer.parseInt(month);
		char mo = (char) (m + 64);
		return str.substring(2, 4) + mo;
	}

	public static String getTadiranDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String str = sdf.format(date);
		return str;
	}

	public static String getNumber(String str) {
		char c[] = str.toCharArray();
		String res = "";
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				res += c[i];
			}
		}
		return res;
	}

	public static String getTadiranVersion(String bin) {

		// NGW.P1.2.1.11.352_10.B0.02
		// String bins[] = bin.split("\\.");
		// String str = String.format("%03d", Integer.parseInt(bins[7]));
		// String b = bins[2]+bins[3]+bins[4]+bins[5].substring(0, 3)+str;
		// bins[2]+bins[3]+bins[4]+bins[5].substring(0, 3)+str;

		String str = getNumber(bin);
		return str.substring(1);
	}
}
