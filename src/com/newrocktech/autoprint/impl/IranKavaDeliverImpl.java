package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newrocktech.autoprint.db.BaseDao;

public class IranKavaDeliverImpl {
	public static String getIranName(String bin) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String iran = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.IranKavaDeliver WHERE bin_name like'" + bin + "%';";
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				iran = rs.getString("iran_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return iran;
	}

}
