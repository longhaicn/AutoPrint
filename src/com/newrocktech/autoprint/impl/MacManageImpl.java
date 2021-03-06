package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.entity.MacAddressEntity;
import com.newrocktech.autoprint.utils.ToolUtils;

public class MacManageImpl {
	public static boolean checkMac(String mac) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		boolean res = false;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "SELECT * FROM dbo.MacAddressList WHERE mac='" + mac + "'AND checked = '0';";
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				res = true;
			} else {
				res = false;
			}
			System.out.println("getRow=" + res);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return res;
	}

	public static void insertMacAddress(MacAddressEntity entity) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "INSERT INTO dbo.MacAddressList(part,serial,mac,checked,datetime)VALUES ('" + entity.part
					+ "','" + entity.serial + "','" + entity.mac + "','" + 0 + "','" + 19991231 + "'); ";
			stat.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return;
	}

	public static void updateMacAddress(LabelEntity entity) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();
			String sql = "UPDATE dbo.MacAddressList SET checked = '1' , datetime = '" + ToolUtils.getDateTime()
					+ "' WHERE mac = '" + entity.MAC + "';";
			stat.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return;

	}

	public static Vector<Vector<Object>> toVector(int queryType) {
		// TODO Auto-generated method stub
		return queryMacInfo(queryType);
	}

	public static Vector<Vector<Object>> queryMacInfo(int queryType) {
		Vector<Vector<Object>> temp = new Vector<Vector<Object>>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		int i = 1;
		if (0 == queryType) {
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();
				rs = stat.executeQuery("SELECT * FROM dbo.MacCheckRecord ORDER BY id DESC;");
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("toprint"));
					v.add(rs.getString("reason"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		} else if (1 == queryType) {
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();
				rs = stat.executeQuery("SELECT * FROM dbo.MacAddressList WHERE checked = '0' ORDER BY id DESC;");
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("part"));
					v.add(rs.getString("serial"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		} else if (2 == queryType) {
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();
				rs = stat.executeQuery(
						"SELECT TOP 3000 * FROM dbo.MacAddressList WHERE checked = '1' ORDER BY id DESC;");
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("part"));
					v.add(rs.getString("serial"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		}

		return temp;
	}

	public static Vector<Vector<Object>> queryMacInfoByCondition(int queryType, String condition) {
		Vector<Vector<Object>> temp = new Vector<Vector<Object>>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		int i = 1;
		System.out.println(queryType);
		if (0 == queryType) {
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();
				rs = stat.executeQuery("SELECT * FROM dbo.MacCheckRecord WHERE datetime = '" + condition
						+ "' OR mac = '" + condition + "' ORDER BY id DESC;");
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("toprint"));
					v.add(rs.getString("reason"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		} else if (1 == queryType) {
			try {

				conn = BaseDao.getConn();
				stat = conn.createStatement();
				String sql = "SELECT * FROM dbo.MacAddressList WHERE checked = '0' AND( serial like '" + condition
						+ "%' OR  datetime = '" + condition + "' OR mac = '" + condition + "' )ORDER BY id DESC;";
				rs = stat.executeQuery(sql);
				System.out.println(sql);
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("part"));
					v.add(rs.getString("serial"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		} else if (2 == queryType) {
			try {
				conn = BaseDao.getConn();
				stat = conn.createStatement();// serial
				rs = stat.executeQuery("SELECT * FROM dbo.MacAddressList WHERE checked = '1' AND ( serial like '"
						+ condition + "%' OR  datetime = '" + condition + "' OR mac = '" + condition
						+ "' ) ORDER BY id DESC;");
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add("    " + (i++));
					v.add(rs.getString("mac"));
					v.add(rs.getString("part"));
					v.add(rs.getString("serial"));
					v.add(rs.getString("datetime"));
					temp.add(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				BaseDao.getClose(rs, stat, conn);
			}
		}

		return temp;
	}

	public static Vector<Vector<Object>> queryMacInfoByCondition(String condition) {
		Vector<Vector<Object>> temp = new Vector<Vector<Object>>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		int i = 1;
		try {
			conn = BaseDao.getConn();
			stat = conn.createStatement();// serial
			rs = stat.executeQuery("SELECT * FROM dbo.MacAddressList WHERE   serial like '" + condition
					+ "%' OR  datetime like '" + condition + "%' OR mac = '" + condition + "'  ORDER BY id DESC;");
			while (rs.next()) {
				Vector<Object> v = new Vector<>();
				v.add("    " + (i++));
				v.add(rs.getString("mac"));
				v.add(rs.getString("part"));
				v.add(rs.getString("serial"));
				v.add(rs.getString("datetime"));
				temp.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.getClose(rs, stat, conn);
		}

		return temp;
	}

}
