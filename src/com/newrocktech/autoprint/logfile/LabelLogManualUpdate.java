package com.newrocktech.autoprint.logfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.impl.NewrockDeliverImpl;
import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.R;
import com.newrocktech.autoprint.utils.ToolUtils;
import com.newrocktech.autoprint.xml.LabelXMLValue;

public class LabelLogManualUpdate {
	public static List<LabelEntity> getOneEquipmentLabel() {
		List<LabelEntity> lists = new ArrayList<LabelEntity>();
		String rootPath = ConfigUtils.get(R.ManUpdLogPath);
		File path = new File(rootPath);
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println("files[i].getName()="+files[i].getName());
			lists.add(cutString(files[i].getName()));
		}
//		Arrays.sort(files, new Comparator<File>() {
//			@Override
//			public int compare(File file1, File file2) {
//				return (int) (file2.lastModified() - file1.lastModified());
//			}
//		});
//		lists.add(cutString(files[0].getName()));
		
		return lists;

	}

	private static LabelEntity cutString(String str) {
		String mConfig = null;
		String root = ConfigUtils.get(R.ManUpdLogPath)+"\\"+str;
		try {
			Scanner scanner = new Scanner(new File(root));
			while(scanner.hasNextLine()){
				mConfig = scanner.nextLine();
				if(mConfig.contains("HW_REVISION")){
					mConfig = mConfig.substring(mConfig.indexOf("=")+1).trim();
					String s[] = mConfig.split(" ");
					mConfig=s[s.length-1];
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("mConfig="+mConfig);
		
		
		//str   =   000EA9012A00-MX.F5.3.0.6.344_P2.C0.01-96FXO-F
		LabelEntity entity = new LabelEntity();
		String ss[] = str.split("-");
		entity.MAC = ss[0].substring(0, 2) + ":" + ss[0].substring(2, 4) + ":" + ss[0].substring(4, 6) + "" + ":"
				+ ss[0].substring(6, 8) + ":" + ss[0].substring(8, 10) + ":" + ss[0].substring(10, 12);
		entity.SN910="00";
		String bin[] = ss[1].split("\\.");
		entity.bin = bin[0] + "." + bin[1];
		String pass = NewrockDeliverImpl.queryPass(entity.bin);
		System.out.println(pass);
//		String e = LabelXMLValue.getLabelXMLManually(pass);
		if(mConfig.contains("(")){
			System.out.println("º¬ÓÐÀ¨ºÅ");
			String a[] = mConfig.split("\\(");
			String b[] = mConfig.split("\\)");
			if(mConfig.contains("(TG)")){
				mConfig = a[0];
			}else{
				mConfig = a[0]+b[1];
			}
			
		}
		
		
		entity.Model=mConfig;
		entity.SN567 = ToolUtils.getSN567();
		System.out.println(entity.toString());
		return entity;
	}
}
