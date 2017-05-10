package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.NewrockDeliverEntity;

public class NewrockDeliverImpl {
	public static List<NewrockDeliverEntity> queryAllGoods(String bin) {
			Connection conn=null;
			Statement stat = null;
			ResultSet	rs=null;
			ArrayList<NewrockDeliverEntity> list = new ArrayList<NewrockDeliverEntity>();
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();
				rs   = stat.executeQuery("SELECT * FROM dbo.NewrockDeliver WHERE bin_head='"+bin+"';");
				while(rs.next()){
				NewrockDeliverEntity entity = new NewrockDeliverEntity();
				entity.setId(rs.getInt("id"));
				entity.setLabel_sort(rs.getString("label_sort"));
				entity.setTemplate_id(rs.getString("template_id"));
				entity.setProduct_name(rs.getString("product_name"));
				entity.setSn1234(rs.getString("sn1234"));
				entity.setPass(rs.getString("pass"));
				list.add(entity);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				BaseDao.getClose(rs, stat, conn);
			}
			return list;
		}
	public static String queryPass(String bin) {
		String pass = null;
		Connection conn=null;
		Statement stat = null;
		ResultSet	rs=null;
		ArrayList<NewrockDeliverEntity> list = new ArrayList<NewrockDeliverEntity>();
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			rs   = stat.executeQuery("SELECT pass FROM dbo.NewrockDeliver WHERE bin_head='"+bin+"';");
			while(rs.next()){
			pass = rs.getString("pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			BaseDao.getClose(rs, stat, conn);
		}
		return pass;
	}



}
