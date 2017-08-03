package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.utils.ToolUtils;

public class MacCheckRecordImpl {

	public static void insertRecord(String mac, String toprint, String reason) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "INSERT INTO dbo.MacCheckRecord(mac,toprint,reason,datetime)VALUES ('" + mac + "','" + toprint
					+ "','" + reason + "'," + ToolUtils.getDateTime() + "); ";
			stat.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return;
	}

}
