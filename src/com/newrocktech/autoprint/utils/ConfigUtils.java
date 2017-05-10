package com.newrocktech.autoprint.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigUtils {
	@SuppressWarnings("resource")
	public static String get(String key){
		String mConfig = null;
		try {
			Scanner scanner = new Scanner(new File("D:\\NewRockPrint\\config\\config.txt"));
			while(scanner.hasNextLine()){
				mConfig = scanner.nextLine();
				if(mConfig.contains(key)){
					mConfig = mConfig.substring(mConfig.indexOf("=")+1).trim();
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mConfig;
	}
}
