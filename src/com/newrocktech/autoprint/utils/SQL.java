package com.newrocktech.autoprint.utils;

public class SQL {
	public static String ADD_NEWROCK_DELIVER_SQL = "INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)"
			+ "VALUES ('PARAM','PARAM','PARAM','PARAM','PARAM','PARAM');";
	public static String ADD_TADIRAN_DELIVER_SQL = "INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)"
			+ "VALUES ('PARAM','PARAM','PARAM','PARAM','PARAM','PARAM','PARAM','PARAM');";

	public static String addNewrockDeliverSQL(String newrock[]) {
		String sqls[] = ADD_NEWROCK_DELIVER_SQL.split("PARAM");
		return sqls[0] + newrock[0] + sqls[1] + newrock[1] + sqls[2] + newrock[2] + sqls[3] + newrock[3] + sqls[4]
				+ newrock[4] + sqls[5] + newrock[5] + sqls[6];
	}

	public static String addTadiranDeliverSQL(String newrock[]) {
		String sqls[] = ADD_TADIRAN_DELIVER_SQL.split("PARAM");
		return sqls[0] + newrock[0] + sqls[1] + newrock[1] + sqls[2] + newrock[2] + sqls[3] + newrock[3] + sqls[4]
				+ newrock[4] + sqls[5] + newrock[5] + sqls[6] + newrock[6] + sqls[7] + newrock[7] + sqls[8];
	}
}
