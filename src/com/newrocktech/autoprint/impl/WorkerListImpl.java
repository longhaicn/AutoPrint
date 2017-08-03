package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newrocktech.autoprint.db.BaseDao;

public class WorkerListImpl {
	/**
	 * µÇÂ¼²Ù×÷
	 * 
	 * @param account
	 * @return
	 */
	public static String loginWorker(String account) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String role = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.WorkerList WHERE workerid='" + account + "';";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				role = rs.getString("role");
				System.out.println(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return role;
	}

}
