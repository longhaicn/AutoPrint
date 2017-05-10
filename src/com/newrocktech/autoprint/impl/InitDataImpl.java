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
			conn=BaseDao.getConn();//��ȡ����
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
			+ "OM50��Ӣ��׼,TMPN003,OM.N1,OM50 IPPBX,NNM1,admin;"
			+ "OM20��Ӣ��׼,TMPN001,OM.P1,OM20 IPPBX,NPM1,admin;"
			+ "HX4E��׼,TMPN001,MX.P1,HX4E��������(VoIP Gateway),NP01,hx4;"
			+ "OM50��Ӣ��׼3C,TMPN004,OM.N1,OM50 IPPBX,NNM1,admin;"
			+ "MX60��׼����,TMPN006,MX.H3,MX60��������(VoIP Gateway),NH07,mx60;"
			+ "MX100G-S��׼��ֱ��,TMPN007,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX100G-S��׼˫ֱ��,TMPN007,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX60��׼ֱ��,TMPN007,MX.H3,MX60��������(VoIP Gateway),NH07,mx60;"
			+ "MX120G��׼������,TMPN010,MX.F5,MX120G��������(VoIP Gateway),NF05,mx120;"
			+ "MX120G��׼˫����,TMPN010,MX.F5,MX120G��������(VoIP Gateway),NF05,mx120;"
			+ "OM80��Ӣ��׼,TMPN005,OM.H3,OM80 IPPBX,NHM6,admin;"
			+ "OM80SE��Ӣ��׼,TMPN005,OM.H3,OM80 IPPBX���Ű�,NHM0,admin;"
			+ "OM200��Ӣ��׼,TMPN005,OM.F3,OM200 IPPBX,NFM1,admin;"
			+ "OM200SE��Ӣ��׼,TMPN005,OM.F3,OM200 IPPBX���Ű�,NFM0,admin;"
			+ "OM500��Ӣ��׼,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "OM501��Ӣ��׼,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "OM502��Ӣ��׼,TMPN005,OM.L1,OM500 IPPBX,NLM2,admin;"
			+ "MX120��׼,TMPN005,MX.F3,MX120��������(VoIP Gateway),NF01,mx120;"
			+ "SX3000��׼������,TMPN005,SBC.L1,Session Border Controller,NLS2,SX3000@123;"
			+ "MX100G��׼������,TMPN011,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G��׼˫����,TMPN011,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G��׼��ֱ��,TMPN012,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "MX100G��׼˫ֱ��,TMPN012,MX.L1,SIP-ISDN Gateway,NL02,mx100;"
			+ "OM20����,TMPB001,PBX.P1,IPPBX,PPM1,admin;"
			+ "OM50����,TMPB001,PBX.N1,IPPBX,PNM1,admin;"
			+ "HX4E����,TMPB001,GW.P1,�������� VoIP Gateway,PP01,voip;"
			+ "MX8A����,TMPB001,GW.N1,�������� VoIP Gateway,PN01,voip;"
			+ "OM80����,TMPB002,PBX.H3,IPPBX,PHM6,admin;"
			+ "OM80SE����,TMPB002,PBX.H3,IPPBX-SE,PHM0,admin;"
			+ "OM200����	,TMPB002,PBX.F3,IPPBX,PFM1,admin;"
			+ "OM200SE����,TMPB002,PBX.F3,IPPBX-SE,PFM0,admin;"
			+ "OM500����,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "OM501����,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "OM502����,TMPB002,PBX.L1,IPPBX,PLM2,admin;"
			+ "MX60���ƽ���,TMPB002,GW.H3,�������� VoIP Gateway,PH07,voip;"
			+ "MX120���ƽ���,TMPB002,GW.F3,�������� VoIP Gateway,PF01,voip;"
			+ "MX100G���Ƶ�����,TMPB002,GW.L1,�м����� SIP-ISDN Gateway,PL02,voip;"
			+ "MX100G����˫����,TMPB002,GW.L1,�м����� SIP-ISDN Gateway,PL02,voip;"
			+ "MX100G-S���Ƶ�ֱ��,TMPB003,GW.L1,SIP-ISDN Gateway,PL08,voip;"
			+ "MX100G-S����˫ֱ��,TMPB003,GW.L1,SIP-ISDN Gateway,PL08,voip;"
			+ "MX60����ֱ��,TMPB003,GW.H3,�������� VoIP Gateway,PH07,voip;"
			+ "OM200G���Ƶ�����,TMPB004,PBX.F5,IPPBX,PFM5,admin;"
			+ "OM200G����˫����,TMPB004,PBX.F5,IPPBX,PFM5,admin;"
			+ "MX120G���Ƶ�����,TMPB004,GW.F5,�������� VoIP Gateway,PF05,voip;"
			+ "MX120G����˫����,TMPB004,GW.F5,�������� VoIP Gateway,PF05,voip;"
			//TMPB005 
			+ "OM200G���Ƶ�ֱ��,TMPB005,PBX.F5,IPPBX,PFM5,admin;"
			+ "OM200G����˫ֱ��,TMPB005,PBX.F5,IPPBX,PFM5,admin;"
			+ "MX120G���Ƶ�ֱ��,TMPB005,GW.F5,�������� VoIP Gateway,PF05,voip;"
			+ "MX120G����˫ֱ��,TMPB005,GW.F5,�������� VoIP Gateway,PF05,voip;"
			//TMPN002
			+ "MX8A��׼,TMPN002,MX.N1,MX8A��������(VoIP Gateway),NN01,mx8;"
			//TMPN008
			+ "OM200G��׼������,TMPN008,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "OM200G��׼˫����,TMPN008,OM.F5,OM200G IPPBX,NFM5,admin;"
			//TMPN009
			+ "OM200G��׼��ֱ��,TMPN009,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "OM200G��׼˫ֱ��,TMPN009,OM.F5,OM200G IPPBX,NFM5,admin;"
			+ "MX120G��׼��ֱ��,TMPN009,MX.F5,MX120G��������(VoIP Gateway),NF05,mx120;"
			+ "MX120G��׼˫ֱ��,TMPN009,MX.F5,MX120G��������(VoIP Gateway),NF05,mx120;"
			//TMPN013,42,43
			+ "MX60E��׼������,TMPN013,MX.H5,MX60E��������(VoIP Gateway),NH05,mx60;"
			+ "MX60E��׼˫����,TMPN013,MX.H5,MX60E��������(VoIP Gateway),NH05,mx60;"
			+ "MX60E��׼��ֱ��,TMPN014,MX.H5,MX60E��������(VoIP Gateway),NH05,mx60;"
			+ "MX60E��׼˫ֱ��,TMPN014,MX.H5,MX60E��������(VoIP Gateway),NH05,mx60;"
			+ "MX100G-S��׼������,TMPN015,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			+ "MX100G-S��׼˫����,TMPN015,MX.L1,SIP-ISDN Gateway,NL08,mx100;"
			//TMPB006,40
			+ "MX60E���Ƶ�����,TMPB006,GW.H5,�������� VoIP Gateway,PH05,voip;"
			+ "MX60E����˫����,TMPB006,GW.H5,�������� VoIP Gateway,PH05,voip;"
			+ "MX60E���Ƶ�ֱ��,TMPB007,GW.H5,�������� VoIP Gateway,PH05,voip;"
			+ "MX60E����˫ֱ��,TMPB007,GW.H5,�������� VoIP Gateway,PH05,voip;"
			//TMPB008
			+ "MX100G-S���Ƶ�����,TMPB008,GW.L1,�м����� SIP-ISDN Gateway,PL08,voip;"
			+ "MX100G-S����˫����,TMPB008,GW.L1,�м����� SIP-ISDN Gateway,PL08,voip";
}





















