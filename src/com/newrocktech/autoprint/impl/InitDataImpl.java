package com.newrocktech.autoprint.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newrocktech.autoprint.db.BaseDao;
import com.newrocktech.autoprint.entity.NewrockDeliverEntity;
import com.newrocktech.autoprint.utils.SQL;
import com.newrocktech.autoprint.utils.ToolUtils;

public class InitDataImpl {
	public static void main(String[] args) {
		(new InitDataImpl()).initNewrockDeliver();
	}
	public void addNewrockDeliver(String newrock[]){
		Connection conn= null;
		Statement  stat= null;
		ResultSet  rs = null;
		try {
			conn=BaseDao.getConn();//获取链接
			stat= conn.createStatement();//
			String sql = SQL.addNewrockDeliverSQL(newrock);
 
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.getClose(rs, stat, conn);
		}
		return;
	}
	public void initNewrockDeliver() {
		String newrock[] = NewrockDeliver.split(";");
		for (int i = 0; i < newrock.length; i++) {
			addNewrockDeliver(newrock[i].split(","));
		}
		
	}
	String NewrockDeliver=""
			+ "OM50中英标准,TMPN003,OM.N1,OM50 IPPBX,NNM1,admin;"
			+ "OM20中英标准,TMPN001,OM.P1,OM20 IPPBX,NPM1,admin;"
			+ "HX4E标准,TMPN001,MX.P1,HX4E语音网关(VoIP Gateway),NP01,hx4;"
			+ "OM50中英标准3C,TMPN004,OM.N1,OM50 IPPBX,NNM1,admin;"
			+ "MX60标准交流,TMPN006,MX.H3,MX60语音网关(VoIP Gateway),NH07,mx60;"
			+ "MX100G-S标准单直流,TMPN007,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX100G-S标准双直流,TMPN007,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX60标准直流,TMPN007,MX.H3,MX60语音网关(VoIP Gateway),NH07,mx60;"
			+ "MX120G标准单交流,TMPN010,MX.F5,MX120G语音网关(VoIP Gateway),NF05,mx120;"
			+ "MX120G标准双交流,TMPN010,MX.F5,MX120G语音网关(VoIP Gateway),NF05,mx120;"
			+ "OM80中英标准,TMPN005,OM.H3,OM80 IPPBX,NHM6,admin;"
			+ "OM80SE中英标准,TMPN005,OM.H3,OM80 IPPBX入门版,NHM0,admin;"
			+ "OM200中英标准,TMPN005,OM.F3,OM200 IPPBX,NFM1,admin;"
			+ "OM200SE中英标准,TMPN005,OM.F3,OM200 IPPBX入门版,NFM0,admin;"
			+ "OM500中英标准,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "OM501中英标准,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "OM502中英标准,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "MX120标准,TMPN005,MX.F3,MX120语音网关(VoIP Gateway),NF01,mx120;"
			+ "SX3000标准单交流,TMPN005,SBC.L1,Session Border Controller,NLS2,SX3000@123;"
			+ "MX100G标准单交流,TMPN011,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G标准双交流,TMPN011,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G标准单直流,TMPN012,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G标准双直流,TMPN012,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "OM20白牌,TMPB001,PBX.P1,IPPBX,PPM1,admin;"
			+ "OM50白牌,TMPB001,PBX.N1,IPPBX,PNM1,admin;"
			+ "HX4E白牌,TMPB001,GW.P1,语音网关 VoIP Gateway,PP01,voip;"
			+ "MX8A白牌,TMPB001,GW.N1,语音网关 VoIP Gateway,PN01,voip;"
			+ "OM80白牌,TMPB002,PBX.H3,IPPBX,PHM6,admin;"
			+ "OM80SE白牌,TMPB002,PBX.H3,IPPBX-SE,PHM0,admin;"
			+ "OM200白牌	,TMPB002,PBX.F3,IPPBX,PFM1,admin;"
			+ "OM200SE白牌,TMPB002,PBX.F3,IPPBX-SE,PFM0,admin;"
			+ "OM500白牌,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "OM501白牌,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "OM502白牌,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "MX60白牌交流,TMPB002,GW.H3,语音网关 VoIP Gateway,PH07,voip;"
			+ "MX120白牌交流,TMPB002,GW.F3,语音网关 VoIP Gateway,PF01,voip;"
			+ "MX100G白牌单交流,TMPB002,GW.L1,中继网关 SIP-ISDN Gateway,PL02,voip;"
			+ "MX100G白牌双交流,TMPB002,GW.L1,中继网关 SIP-ISDN Gateway,PL02,voip;"
			+ "MX100G-S白牌单直流,TMPB003,GW.L1,SIP-ISDN Gateway,PL08,voip;"
			+ "MX100G-S白牌双直流,TMPB003,GW.L1,SIP-ISDN Gateway,PL08,voip;"
			+ "MX60白牌直流,TMPB003,GW.H3,语音网关 VoIP Gateway,PH07,voip;"
			+ "OM200G白牌单交流,TMPB004,PBX.F5,IPPBX,PFM5,admin;"
			+ "OM200G白牌双交流,TMPB004,PBX.F5,IPPBX,PFM5,admin;"
			+ "MX120G白牌单交流,TMPB004,GW.F5,语音网关 VoIP Gateway,PF05,voip;"
			+ "MX120G白牌双交流,TMPB004,GW.F5,语音网关 VoIP Gateway,PF05,voip;"
			//TMPB005 
			+ "OM200G白牌单直流,TMPB005,PBX.F5,IPPBX,PFM5,admin;"
			+ "OM200G白牌双直流,TMPB005,PBX.F5,IPPBX,PFM5,admin;"
			+ "MX120G白牌单直流,TMPB005,GW.F5,语音网关 VoIP Gateway,PF05,voip;"
			+ "MX120G白牌双直流,TMPB005,GW.F5,语音网关 VoIP Gateway,PF05,voip;"
			//TMPN002
			+ "MX8A标准,TMPN002,MX.N1,MX8A语音网关(VoIP Gateway),NN01,mx8;"
			//TMPN008
			+ "OM200G标准单交流,TMPN008,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "OM200G标准双交流,TMPN008,OM.F5,OM200G IPPBX,NFM5,admin;"
			//TMPN009
			+ "OM200G标准单直流,TMPN009,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "OM200G标准双直流,TMPN009,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "MX120G标准单直流,TMPN009,MX.F5,MX120G语音网关(VoIP Gateway),NF05,mx120;"
			+ "MX120G标准双直流,TMPN009,MX.F5,MX120G语音网关(VoIP Gateway),NF05,mx120;"
			//TMPN013,42,43
			+ "MX60E标准单交流,TMPN013,MX.H5,MX60E语音网关(VoIP Gateway),NH05,mx60;"
			+ "MX60E标准双交流,TMPN013,MX.H5,MX60E语音网关(VoIP Gateway),NH05,mx60;"
			+ "MX60E标准单直流,TMPN014,MX.H5,MX60E语音网关(VoIP Gateway),NH05,mx60;"
			+ "MX60E标准双直流,TMPN014,MX.H5,MX60E语音网关(VoIP Gateway),NH05,mx60;"
			+ "MX100G-S标准单交流,TMPN015,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX100G-S标准双交流,TMPN015,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			//TMPB006,40
			+ "MX60E白牌单交流,TMPB006,GW.H5,语音网关 VoIP Gateway,PH05,voip;"
			+ "MX60E白牌双交流,TMPB006,GW.H5,语音网关 VoIP Gateway,PH05,voip;"
			+ "MX60E白牌单直流,TMPB007,GW.H5,语音网关 VoIP Gateway,PH05,voip;"
			+ "MX60E白牌双直流,TMPB007,GW.H5,语音网关 VoIP Gateway,PH05,voip;"
			//TMPB008
			+ "MX100G-S白牌单交流,TMPB008,GW.L1,中继网关 SIP-ISDN Gateway,PL08,voip;"
			+ "MX100G-S白牌双交流,TMPB008,GW.L1,中继网关 SIP-ISDN Gateway,PL08,voip";
}





















