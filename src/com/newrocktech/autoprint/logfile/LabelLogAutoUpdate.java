package com.newrocktech.autoprint.logfile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.R;
import com.newrocktech.autoprint.utils.ToolUtils;
import com.newrocktech.autoprint.utils.ZipUtils;
import com.newrocktech.autoprint.xml.LabelXMLValue;

public class LabelLogAutoUpdate {
	/**
	 * 扫描所有LOG获得数据集
	 * @param c
	 * @return
	 */
	public static List<Map<String, String>> checkAllEquipmentLabel(char c) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		String ip = "172." + ((int) c - 64);
		String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		File fr = new File(rootPath);
		if (fr.isDirectory()) {
			File ff[] = fr.listFiles();
			for (int i = 0; i < ff.length; i++) {
				String filename = ff[i].getName();
				if (filename.contains(ip)) {
					map = new HashMap<String, String>();
					map.put("ip", filename.substring(0, filename.indexOf('-')));
					map.put("app", LabelXMLValue.checkWeb(filename.substring(0, filename.indexOf('-'))));
					list.add(map);
				}
			}
		}

		for (Map<String, String> map2 : list) {
			System.out.println(map2.get("ip") + map2.get("app"));
		}
		return list;
	}

	/**
	 *            
	 * @param c
	 * @return
	 */
	public static List<LabelEntity> getAllEquipmentLabel(char c) {
		String ip = "172." + ((int) c - 64);
		List<LabelEntity> lists = new ArrayList<LabelEntity>();
		String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		File fr = new File(rootPath);
		if (fr.isDirectory()) {
			File ff[] = fr.listFiles();
			for (int i = 0; i < ff.length; i++) {
				String filename = ff[i].getName();
				if (filename.contains(ip)) {
					lists.add(cutString(filename));
				}
			}
		}
		ZipUtils.copyFolder(ConfigUtils.get(R.AutoUpdLogPath),
				ConfigUtils.get(R.AutoUpdLogPath) + ToolUtils.getDateTime());
		return lists;
	}

	private static LabelEntity cutString(String str) {
		LabelEntity entity = new LabelEntity();
		String ss[] = str.split("-");
		entity.appChecked = ss[0];
		entity.SN910 = ss[0].substring(7, 9);
		entity.MAC = ss[3].substring(0, 2) + ":" + ss[3].substring(2, 4) + ":" + ss[3].substring(4, 6) + "" + ":"
				+ ss[3].substring(6, 8) + ":" + ss[3].substring(8, 10) + ":" + ss[3].substring(10, 12);
		String mo[] = ss[1].split("\\(");
		String model = mo[0] + "-" + ss[2];
		int n = model.indexOf("S");
		int m = model.length();
		if (n < m - 1) {
			char c = model.charAt(n + 1);
			if (Character.isDigit(c)) {
				model = model.substring(0, n) + "S/" + model.substring(n + 1);
			}
		}
		entity.Model = model;
		String bin[] = ss[4].split("\\.");
		entity.bin = bin[0] + "." + bin[1];
		entity.SN567 = ToolUtils.getSN567();
		System.out.println(entity.toString());
		return entity;
	}
}
