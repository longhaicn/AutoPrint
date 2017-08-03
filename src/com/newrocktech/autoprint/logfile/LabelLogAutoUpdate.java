package com.newrocktech.autoprint.logfile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.impl.IranKavaDeliverImpl;
import com.newrocktech.autoprint.impl.OEMDeliverImpl;
import com.newrocktech.autoprint.impl.TadiranDeliverImpl;
import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.R;
import com.newrocktech.autoprint.utils.ToolUtils;
import com.newrocktech.autoprint.utils.ZipUtils;
import com.newrocktech.autoprint.xml.LabelXMLValue;

public class LabelLogAutoUpdate {
	/**
	 * 扫描所有LOG获得数据集
	 * 
	 * @param c
	 * @return
	 */
	public static List<Map<String, String>> checkAllEquipmentLabel(char c) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		String ip = "172." + ((int) c - 64);
		String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		File fr = new File(rootPath);
		// $IPADDR-$HW-00$MAC-$BIN-$CUST-$USB_FORMAT-$total-$CIC-$DSP.txt
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
		// String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		// File fr = new File(rootPath);
		// if (fr.isDirectory()) {
		// File ff[] = fr.listFiles();
		File ff[] = getLogFiles(ip);
		LabelEntity entity = new LabelEntity();
		if (ff.length > 0) {
			String str = ff[0].getName();
			int index = str.indexOf("-00");
			String para[] = str.substring(index + 1).split("-");
			String BIN = para[1];
			for (int i = 0; i < ff.length; i++) {
				String filename = ff[i].getName();
				if (filename.contains(ip) && filename.contains(BIN)) {
					entity = cutString(filename);
					if (null != entity) {
						lists.add(entity);
					} else {
						lists.clear();
						break;
					}

				}
			}
		}
		// }
		ZipUtils.copyFolder(ConfigUtils.get(R.AutoUpdLogPath),
				ConfigUtils.get(R.AutoUpdLogPath) + ToolUtils.getDateTime());
		return lists;
	}

	public static File[] getLogFiles(String IP) {
		String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		File fr = new File(rootPath);
		if (fr.isDirectory()) {
			File ff[] = fr.listFiles();

			return ff;
		}
		return null;
	}

	public static int getLogFileSum(String IP) {
		int length = 0;
		String rootPath = ConfigUtils.get(R.AutoUpdLogPath);
		File fr = new File(rootPath);
		if (fr.isDirectory()) {
			File ff[] = fr.listFiles();
			for (int i = 0; i < ff.length; i++) {
				String filename = ff[i].getName();
				if (filename.contains(IP)) {
					length++;

				}
			}

		}
		return length;
	}

	private static LabelEntity cutString(String str) {
		// $IPADDR-$HW-$MAC-$BIN-$CUST-$USB_FORMAT-$total-$CIC-$DSP.txt
		LabelEntity entity = new LabelEntity();
		str = str.replaceAll(".txt", "");
		int i = str.indexOf("-00");
		if (i < 5)
			return null;// 大部分都是00：0E：A9开头
		int j = str.indexOf("-");
		String IPADDR = str.substring(0, j);
		String HW = str.substring(j + 1, i);
		String para[] = str.substring(i + 1).split("-");
		String MAC = para[0];
		String BIN = para[1];
		String CUST = null;
		String USB_FORMAT = null;
		String total = null;
		String CIC = null;

		int DSP = -1;
		if (para.length > 5) {
			CUST = para[2];
			USB_FORMAT = para[3];
			total = para[4];
			CIC = para[5];
			DSP = Integer.parseInt(para[6].trim());
			// System.out.println("DSP="+DSP);
		}
		entity.BIN = BIN;
		//
		if (!HW.contains("-")) {
			return null;
		}
		// 临时处理
		if (BIN.contains("NetGen")) {
			BIN = BIN.replace("NetGen", "GW");
		}
		CUST = OEMDeliverImpl.getOEMModel(BIN.substring(1));
		// System.out.println(CUST+"--------"+BIN.substring(1));
		if (null != CUST && !"".equals(CUST)) {
		} else {
			CUST = "Newrock";
		}
		if ("Iran_Kava".equals(IranKavaDeliverImpl.getIranName(BIN))) {
			CUST = "Iran Kava";
		}
		if (CUST.contains("Tadiran")) {
			HW = modifyNewrockModel(HW);
			HW = getExampleHX4E(HW);
			entity.Customer = "Tadiran";
			entity.Model = TadiranDeliverImpl.getTadiranModel(HW);
		} else if (CUST.contains("ZTE")) {
			HW = modifyNewrockModel(HW);
			BIN = BIN.substring(1);
			entity.Customer = "ZTE";
			entity.Model = OEMDeliverImpl.getZTEModel(HW);

		} else if (CUST.contains("Zultys")) {
			HW = modifyNewrockModel(HW);
			String hw[] = HW.split("-");
			HW = modifyNewrockBlank(HW);
			entity.Customer = "Zultys";
			entity.Product = hw[0];
			entity.Model = HW;

		} else if (CUST.contains("HuachenTel")) {
			HW = modifyNewrockModel(HW);
			if (HW.contains("HX4E")) {
				entity.Product = "HX4E";
				HW = HW.replace("HX4E", "ITA04B");
			} else if (HW.contains("MX60E")) {
				entity.Product = "MX60E";
				HW = HW.replace("MX60E", "ITA60B");
			} else if (HW.contains("MX60")) {
				entity.Product = "MX60";
				HW = HW.replace("MX60", "ITA60");
			} else if (HW.contains("MX100G-S")) {
				entity.Product = "MX100G-S";
				HW = HW.replace("MX100G-S", "ITE100B");
			} else if (HW.contains("MX100G")) {
				entity.Product = "MX100G";
				HW = HW.replace("MX100G", "ITG100G");
			} else if (HW.contains("OM50")) {
				entity.Product = "OM50";
				HW = HW.replace("OM50", "IVX50B");
			} else if (HW.contains("OM80E")) {
				entity.Product = "OM80E";
				HW = HW.replace("OM80E", "IVX100B");
			} else if (HW.contains("OM200G")) {
				entity.Product = "OM200G";
				HW = HW.replace("OM200G", "IVX200B");
			} else if (HW.contains("OM20")) {
				entity.Product = "OM20";
				HW = HW.replace("OM20", "IVX20B");
			}
			entity.Customer = "HuachenTel";
			entity.Model = HW;
		} else if (CUST.contains("Iran")) {
			HW = modifyNewrockModel(HW);
			if (HW.contains("MX120G")) {
				HW = modifyOM200GMX120G(HW, DSP);
				String so[] = HW.split("-");
				HW = so[0] + "-NA" + "-" + so[2];
			} else {
				HW = HW.substring(0, HW.indexOf("-"));
			}
			entity.Customer = "Iran";
			entity.Model = HW;
		} else {
			HW = modifyNewrockModel(HW);
			HW = modifyMX60EOM80E(HW, DSP);
			HW = modifyOM200GMX120G(HW, DSP);
			// 迅时白牌
			if (BIN.startsWith("GW") || BIN.startsWith("PBX")) {
				HW = modifyNewrockBlank(HW);
			} else {
				HW = getExampleHX4E(HW);
			}
			entity.Customer = "NewRock";
			entity.Model = HW;
		}
		entity.webChecked = IPADDR;
		entity.SN910 = IPADDR.substring(7, 9);
		entity.MAC = ToolUtils.getMacAddress(MAC);
		entity.BinHead = BIN;
		entity.SN567 = ToolUtils.getSN567();
		System.out.println(entity.toString());
		return entity;
	}

	private static String modifyNewrockBlank(String HW) {
		String s, o;
		boolean flag = false;
		if (HW.contains("B")) {
			flag = true;
		}
		HW = HW.substring(HW.indexOf("-") + 1);
		if (HW.contains("-")) {
			String mm[] = HW.split("-");
			if (mm[0].contains("/")) {
				String so[] = mm[0].split("/");
				s = ToolUtils.getNumber(so[0]);
				o = ToolUtils.getNumber(so[1]);
				HW = s + "FXS/" + o + "FXO" + HW.substring(HW.indexOf("-"));
			} else {
				s = ToolUtils.getNumber(mm[0]);
				HW = s + "FXS" + HW.substring(HW.indexOf("-"));
			}
		} else {
			if (HW.contains("/")) {
				String so[] = HW.split("/");
				s = ToolUtils.getNumber(so[0]);
				o = ToolUtils.getNumber(so[1]);
				HW = s + "FXS/" + o + "FXO";
			} else {
				if (HW.contains("S")) {
					s = ToolUtils.getNumber(HW);
					HW = s + "FXS";
				} else {
					o = ToolUtils.getNumber(HW);
					HW = o + "FXO";
				}
			}
		}
		if (flag) {
			HW = HW + "(B)";
		}
		// 迅时标准
		return HW;
	}

	private static String getExampleHX4E(String HW) {
		if ("HX4E-2S".equals(HW)) {
			HW = "HX402E";
		} else if ("HX4E-2FXO".equals(HW)) {
			HW = "HX420E";
		} else if ("HX4E-2S/2".equals(HW)) {
			HW = "HX422E";
		} else if ("HX4E-4S".equals(HW)) {
			HW = "HX404E";
		} else if ("HX4E-4FXO".equals(HW)) {
			HW = "HX440E";
		}
		return HW;
	}

	private static String getExampleHX4G(String HW) {
		if ("HX4G-2S".equals(HW)) {
			HW = "HX402G";
		} else if ("HX4G-2FXO".equals(HW)) {
			HW = "HX420G";
		} else if ("HX4G-2S/2".equals(HW)) {
			HW = "HX422G";
		} else if ("HX4G-4S".equals(HW)) {
			HW = "HX404G";
		} else if ("HX4G-4FXO".equals(HW)) {
			HW = "HX440G";
		}
		return HW;
	}

	private static String modifyNewrockModel(String HW) {
		// 迅时标准出货 型号拼接
		int m = HW.indexOf("(");
		int n = HW.indexOf(")");
		if (0 != n - m && 2 != n - m) {
			HW = HW.substring(0, m) + HW.substring(n + 1);
		}
		int index = HW.indexOf("S");
		int len = HW.length();
		if (index < len - 1) {
			char c = HW.charAt(index + 1);
			if (Character.isDigit(c)) {
				HW = HW.substring(0, index) + "S/" + HW.substring(index + 1);
			}
		}
		return HW;
	}

	private static String modifyMX60EOM80E(String HW, int DSP) {
		if (DSP > 0 && ((HW.contains("OM80E") || HW.contains("MX60E")))) {
			String s, o;
			String so[] = HW.split("-");
			HW = so[1];
			if (HW.contains("/")) {
				String mm[] = HW.split("/");
				s = ToolUtils.getNumber(mm[0]);
				o = ToolUtils.getNumber(mm[1]);
			} else {
				s = ToolUtils.getNumber(HW);
				o = "0";
			}
			int fxsfxo = Integer.parseInt(s.trim()) + Integer.parseInt(o.trim());
			if ((DSP - fxsfxo / 8) < 0) {
				HW = so[0] + "-" + HW + "B";
			} else {
				HW = so[0] + "-" + HW;
			}
		}
		return HW;
	}

	private static String modifyOM200GMX120G(String HW, int DSP) {
		if (DSP > 0 && ((HW.contains("OM200G") || HW.contains("MX120G")))) {
			String so[] = HW.split("-");
			HW = so[0] + "-" + so[1] + "-" + (char) (66 + DSP / 3);
		}
		return HW;
	}
}
