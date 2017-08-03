package com.newrocktech.autoprint.print;

import java.net.Authenticator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.tempuri.KgmWebService;
import org.tempuri.KgmWebServiceSoap;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.impl.MacManageImpl;
import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.R;
import com.newrocktech.autoprint.utils.ToolUtils;
import com.newrocktech.autoprint.utils.ZipUtils;

import net.sf.json.JSONArray;

public class TadiranPrint {
	/**
	 * 打印接口
	 * 
	 * @param str
	 * @param lists
	 * @param printStyle
	 * @param updateStyle
	 * @param deletBIN
	 * @return
	 */
	public static List<LabelEntity> sendToPrint(String str, List<LabelEntity> lists, int printStyle, int updateStyle,
			String deletBIN) {
		String lbl[] = str.split(",");// workid
										// +","+TadiranName+","+BuyCat+","+SellCat+","+BarCode+","+TemplateId+","+Remark;
		if (!lists.isEmpty()) {
			int i = 1;
			System.out.println(str + "---------lbl[0]");
			String PrintName = ConfigUtils.get(R.PrintName);
			// String PrintStyle = ConfigUtils.get("PrintStyle");
			Authenticator.setDefault(new PmcAuthenticator());
			KgmWebService factory = new KgmWebService();
			KgmWebServiceSoap kgmWSSoap = factory.getKgmWebServiceSoap();
			JSONArray JsonLabels = new JSONArray();
			JSONArray JSON = new JSONArray();
			Map<String, String> map;
			LinkedHashMap<String, Object> map0, map2, map3;

			int begin = getSN11121314(lbl[0], lists.size(), ToolUtils.getSN567());
			// 走纸热机
			JSONArray JsonLabels0 = new JSONArray();
			map = new HashMap<String, String>();
			map.put("Blank", "开始打印");
			JsonLabels0.add(map);
			map0 = new LinkedHashMap<String, Object>();
			map0.put("PrintContent", JsonLabels0.toString());
			map0.put("PrintModel", "TMP0000");
			map0.put("Copies", 1);
			map0.put("PrintName", PrintName);
			JSON.add(map0);
			//
			if (1 == printStyle) {
				for (LabelEntity entity : lists) {
					map = new HashMap<String, String>();
					entity.TemplateId = lbl[5];
					entity.SN8 = lbl[0];
					entity.SN1234 = lbl[4];
					entity.Product = lbl[1];
					if (0 == entity.SN11121314) {
						entity.SN11121314 = begin + i++;
					}
					map.put("TadiranName", entity.Product);
					map.put("SellCat", lbl[3]);
					map.put("Version", ToolUtils.getTadiranVersion(entity.BinHead));
					map.put("BarcodeSN", entity.SN1234 + entity.SN567 + entity.SN8 + entity.SN910
							+ String.format("%04d", entity.SN11121314));
					map.put("MAC", entity.MAC);
					map.put("Date", ToolUtils.getTadiranDate());
					JsonLabels.add(map);
					MacManageImpl.updateMacAddress(entity);
				}
				map2 = new LinkedHashMap<String, Object>();
				map2.put("PrintContent", JsonLabels.toString());
				map2.put("PrintModel", lbl[5]);
				map2.put("Copies", 1);
				map2.put("PrintName", PrintName);
				JSON.add(map2);
			} else if (0 == printStyle) {
				for (LabelEntity entity : lists) {
					map = new HashMap<String, String>();
					entity.TemplateId = lbl[5];
					entity.SN8 = lbl[0];
					entity.SN1234 = lbl[4];
					entity.Product = lbl[1];
					if (0 == entity.SN11121314) {
						entity.SN11121314 = begin + i++;
					}
					map.put("TadiranName", entity.Product);
					map.put("SellCat", lbl[3]);
					map.put("Version", ToolUtils.getTadiranVersion(entity.BinHead));
					map.put("BarcodeSN", entity.SN1234 + entity.SN567 + entity.SN8 + entity.SN910
							+ String.format("%04d", entity.SN11121314));
					map.put("MAC", entity.MAC);
					map.put("Date", ToolUtils.getTadiranDate());
					JsonLabels.add(map);
					map3 = new LinkedHashMap<String, Object>();
					map3.put("PrintContent", JsonLabels.toString());
					map3.put("PrintModel", "TMPX001");
					map3.put("Copies", 1);
					map3.put("PrintName", PrintName);
					JSON.add(map3);
					map2 = new LinkedHashMap<String, Object>();
					map2.put("PrintContent", JsonLabels.toString());
					map2.put("PrintModel", lbl[3]);
					map2.put("Copies", 1);
					map2.put("PrintName", PrintName);
					JSON.add(map2);
					MacManageImpl.updateMacAddress(entity);
				}

			} else if (2 == printStyle) {
				for (LabelEntity entity : lists) {
					map = new HashMap<String, String>();
					entity.TemplateId = lbl[5];
					entity.SN8 = lbl[0];
					entity.SN1234 = lbl[4];
					entity.Product = lbl[1];
					if (0 == entity.SN11121314) {
						entity.SN11121314 = begin + i++;
					}
					map.put("TadiranName", entity.Product);
					map.put("SellCat", lbl[3]);
					map.put("Version", ToolUtils.getTadiranVersion(entity.BinHead));
					map.put("BarcodeSN", entity.SN1234 + entity.SN567 + entity.SN8 + entity.SN910
							+ String.format("%04d", entity.SN11121314));
					map.put("MAC", entity.MAC);
					map.put("Date", ToolUtils.getTadiranDate());
					JsonLabels.add(map);
					map3 = new LinkedHashMap<String, Object>();
					map3.put("PrintContent", JsonLabels.toString());
					map3.put("PrintModel", "TMPX001");
					map3.put("Copies", 2);
					map3.put("PrintName", PrintName);
					JSON.add(map3);
					map2 = new LinkedHashMap<String, Object>();
					map2.put("PrintContent", JsonLabels.toString());
					map2.put("PrintModel", lbl[3]);
					map2.put("Copies", 1);
					map2.put("PrintName", PrintName);
					JSON.add(map2);
					MacManageImpl.updateMacAddress(entity);
				}

			} else if (3 == printStyle) {
				for (LabelEntity entity : lists) {
					map = new HashMap<String, String>();
					entity.TemplateId = lbl[5];
					entity.SN8 = lbl[0];
					entity.SN1234 = lbl[4];
					entity.Product = lbl[1];
					if (0 == entity.SN11121314) {
						entity.SN11121314 = begin + i++;
					}
					map.put("TadiranName", entity.Product);
					map.put("SellCat", lbl[3]);
					map.put("Version", ToolUtils.getTadiranVersion(entity.BinHead));
					map.put("BarcodeSN", entity.SN1234 + entity.SN567 + entity.SN8 + entity.SN910
							+ String.format("%04d", entity.SN11121314));
					map.put("MAC", entity.MAC);
					map.put("Date", ToolUtils.getTadiranDate());
					JsonLabels.add(map);
					MacManageImpl.updateMacAddress(entity);
				}
				map2 = new LinkedHashMap<String, Object>();
				map2.put("PrintContent", JsonLabels.toString());
				map2.put("PrintModel", lbl[5]);
				map2.put("Copies", 1);
				map2.put("PrintName", PrintName);
				JSON.add(map2);
				map3 = new LinkedHashMap<String, Object>();
				map3.put("PrintContent", JsonLabels.toString());
				map3.put("PrintModel", "TMPX001");
				map3.put("Copies", 1);
				map3.put("PrintName", PrintName);
				JSON.add(map3);
			}
			// System.out.println(JSON.toString());
			String result1 = kgmWSSoap.printLabel("00:0E:A9:39:00:76", JSON.toString());
			// System.out.println("print lable test: " + result1);
		}
		if (0 == updateStyle) {// Clear log file from AutoUpdLogPath
			ZipUtils.deleteFile(ConfigUtils.get(R.AutoUpdLogPath), lbl[0].charAt(0), lists.get(0).BIN);
		}
		return lists;
	}

	/**
	 * 动态配置SN号
	 * 
	 * @param workid
	 * @param sum
	 * @param sn567
	 * @return
	 */
	public static int getSN11121314(String workid, int sum, String sn567) {
		// select SUM(printsum) from PrintRecord where datetime='17C';
		int sn11121314 = 0;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT SUM(printsum) FROM dbo.PrintRecord WHERE datetime='" + sn567 + "';");
			if (rs.next()) {
				sn11121314 = rs.getInt(1);
			}
			String sql = "INSERT INTO dbo.PrintRecord(worker,printsum,datetime)VALUES('" + workid + "','" + sum + "','"
					+ sn567 + "');";
			stat.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return sn11121314;
	}

}
