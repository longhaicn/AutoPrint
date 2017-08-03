package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.OEMDeliverEntity;

public class OEMDeliverImpl {

	public static List<OEMDeliverEntity> queryAllZTEGoods(String zte) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<OEMDeliverEntity> list = new ArrayList<OEMDeliverEntity>();
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM dbo.ZTEDeliver WHERE zte_name like'" + zte + "%';");
			while (rs.next()) {
				OEMDeliverEntity entity = new OEMDeliverEntity();
				entity.setOem_name(rs.getString("zte_name"));
				entity.setTemplate_id(rs.getString("template_id"));
				entity.setBin_name(rs.getString("bin_head"));
				list.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return list;
	}

	public static String getZTEModel(String model) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String zte = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.ZTEDeliver WHERE newrock_name like'" + model + "%';";
			rs = stat.executeQuery(sql);
			// System.out.println(sql);
			if (rs.next()) {
				zte = rs.getString("zte_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return zte;
	}

	public static List<OEMDeliverEntity> queryAllZultysGoods(String product, String model) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<OEMDeliverEntity> list = new ArrayList<OEMDeliverEntity>();
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.ZultysDeliver WHERE newrock_name like'" + product + "%';";
			// System.out.println(sql);
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OEMDeliverEntity entity = new OEMDeliverEntity();
				entity.setOem_name(model);
				entity.setTemplate_id(rs.getString("template_id"));
				entity.setBin_name(rs.getString("bin_head"));
				list.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return list;
	}

	public static void selectAllZultysGoods() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.OEMDeliver;";
			// System.out.println(sql);
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OEMDeliverEntity entity = new OEMDeliverEntity();
				entity.setNewrock_name(rs.getString("bin_name"));
				entity.setOem_name(rs.getString("oem_cust_model"));
				System.out.println("INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)" + "VALUES('"
						+ entity.newrock_name + "','" + entity.oem_name + "')");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}

		return;
	}

	public static List<OEMDeliverEntity> queryAllHuachenTelGoods(String product, String model) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<OEMDeliverEntity> list = new ArrayList<OEMDeliverEntity>();
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.HuachenTelDeliver WHERE newrock_name like'" + product + "';";
			// System.out.println(sql);
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OEMDeliverEntity entity = new OEMDeliverEntity();
				entity.setOem_name(model);
				entity.setTemplate_id(rs.getString("template_id"));
				entity.setBin_name(rs.getString("bin_head"));
				list.add(entity);
				if (product.contains("OM200G")) {
					OEMDeliverEntity entity2 = new OEMDeliverEntity();
					entity2.setOem_name(model + "-DC");
					entity2.setTemplate_id(rs.getString("template_id"));
					entity2.setBin_name(rs.getString("bin_head"));
					list.add(entity2);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return list;
	}

	public static String getOEMModel(String bin) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String oem_cust_model = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT oem_cust_model FROM dbo.OEMDeliver WHERE bin_name like'%" + bin + "%';";
			System.out.println(sql);
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				oem_cust_model = rs.getString("oem_cust_model");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return oem_cust_model;
	}

}
