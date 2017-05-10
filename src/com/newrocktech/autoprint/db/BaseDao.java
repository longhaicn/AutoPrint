package com.newrocktech.autoprint.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.R;

public class BaseDao {
	final static String HOST = ConfigUtils.get(R.DBHOST);
	final static String DBNAME = ConfigUtils.get(R.DBNAME);
	final static String PORT = ConfigUtils.get(R.DBPORT);
	final static String USER = ConfigUtils.get(R.DBUSER);
	final static String PASSWORD = ConfigUtils.get(R.DBPWD);

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// ��������
			conn = DriverManager.getConnection("jdbc:sqlserver://" + HOST + ":" + PORT + ";DataBaseName=" + DBNAME,
					USER, PASSWORD);// ��ȡָ�����ݿ������
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void getClose(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}