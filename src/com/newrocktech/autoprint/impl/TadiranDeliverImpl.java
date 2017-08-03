package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.TadiranDeliverEntity;

public class TadiranDeliverImpl {
	public static List<TadiranDeliverEntity> queryAllTadiranGoods(String name) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<TadiranDeliverEntity> list = new ArrayList<TadiranDeliverEntity>();
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.TadiranDeliver WHERE tadiran_name like'" + name + "%';";
			System.out.println(sql);
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				TadiranDeliverEntity entity = new TadiranDeliverEntity();
				entity.setTadiranName(rs.getString("tadiran_name"));
				entity.setBuyCat(rs.getString("buy_cat"));
				entity.setSellCat(rs.getString("sell_cat"));
				entity.setBarCode(rs.getString("barcode"));
				entity.setTemplateId(rs.getString("template_id"));
				entity.setBinHead(rs.getString("bin_head"));
				entity.setRemark(rs.getString("remark"));
				list.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return list;
	}

	public static String getTadiranModel(String model) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String tadiran = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.TadiranDeliver WHERE newrock_name like'" + model + "%';";
			// System.out.println(sql);
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				tadiran = rs.getString("tadiran_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return tadiran;
	}

	public static List<TadiranDeliverEntity> queryAllZTEGoods(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<TadiranDeliverEntity> queryAllZultysGoods(String model) {
		// TODO Auto-generated method stub
		return null;
	}

}
