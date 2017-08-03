package com.newrocktech.autoprint.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.newrocktech.autoprint.entity.MacAddressEntity;
import com.newrocktech.autoprint.impl.MacManageImpl;

public class ExcelImportUtils {

	public static void readCSV(String root) {
		File inFile = new File(root); // ��ȡ��CSV�ļ�
		String inString = "";
		try {
			String en[];
			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			while ((inString = reader.readLine()) != null) {
				en = inString.split(",");
				MacManageImpl.insertMacAddress(new MacAddressEntity(en[0], en[1], en[2]));
			}
			reader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("û�ҵ��ļ���");
		} catch (IOException ex) {
			System.out.println("��д�ļ�����");
		}
	}
}
