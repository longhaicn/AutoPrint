
--dbo.WorkerList
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('A','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('B','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('C','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('D','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('E','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('F','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('Manager','AAA','M');
--dbo.HuachenTelDeliver
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('HX4E','ITA04','TMPO025','BP01')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('MX8A','ITA04','TMPO025','BN01')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('OM20','IVX20B','TMPO026','BPM1')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('OM50','IVX50B','TMPO026','BNM1')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('MX60','ITA60','TMPO018','BH07')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('MX60E','ITA60B','TMPO027','BH05')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('MX100G','ITG100G','TMPO019','BL02')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('MX100G-S','ITE100B','TMPO019','BL08')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('OM80E','IVX100B','TMPO028','BHM5')
INSERT INTO dbo.HuachenTelDeliver(newrock_name,huachentel_name,template_id,bin_head)VALUES('OM200G','IVX200B','TMPO020','BFM5')
--dbo.ZTEDeliver
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('HX4E-4S','ZXECS AG 4s-X','TMPO014','ZP01')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX8A-8S','ZXECS AG 8s-X','TMPO015','ZN01')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX8A-4S/4','ZXECS AG 4s/4o','TMPO015','ZN01')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX60E-16S-D2','ZXECS AG 16s-X','TMPO016','ZH05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX60E-32S-D4','ZXECS AG 32s-X','TMPO016','ZH05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX60E-32S-D3','ZXECS AG 32s-C-X','TMPO016','ZH05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX60E-48S-D6','ZXECS AG 48s-X','TMPO016','ZH05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX60E-48S-D3','ZXECS AG 48s-C-X','TMPO016','ZH05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX120G-96S-F','ZXECS AG 96s-X','TMPO017','ZF05')
INSERT INTO dbo.ZTEDeliver(newrock_name,zte_name,template_id,bin_head)VALUES('MX120G-96S-C','ZXECS AG 96s-C-X','TMPO017','ZF05')
--dbo.OEMDeliver
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.P1.1.1.8.340.E0.02.bin','Tadiran_HX4E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.F5.3.0.6.344_P2.E0.06.bin','Tadiran_MX120G')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.F5.3.0.16.351_P1.E0.01.bin','Tadiran_MX120G')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.F5.3.0.6.344_P2.E0.06.bin','Tadiran_MX120G-DC')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.F5.3.0.16.351_P1.E0.01.bin','Tadiran_MX120G-DC')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.N1.2.0.10mt.344_P2.E0.04.bin','Tadiran_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.N1.2.1.5mt.350.E0.05.bin','Tadiran_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.L1.3.0.16.5_115.E0.02.bin','Tadiran_100GS')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.H5.3.0.16.351_P1.E0.01.bin','Tadiran_MX60E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.P1.1.1.25.343.2.E0.03.bin','Zultys_HX4E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.N1.1.1.25mt.343.2.E0.03.bin','Zultys_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('Zultys.H5.3.0.16.351.E0.01.bin','Zultys_MX60E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('ZTE.P1.2.0.10.344_P2.C0.02.bin','ZTE_HX4E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('ZTE.N1.2.0.10mt.344_P2.C0.03.bin','ZTE_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('ZTE.N1.2.0.10mt.344_P2.C0.04.bin','ZTE_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('ZTE.H5.3.0.16.351.C0.01.bin','ZTE_MX60E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('ZTE.F5.3.0.6.344_P2.C0.01.bin','ZTE_MX120G')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.H5.3.0.16.351.C0.02.bin','HuachenTel_MX60E')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('PBX.M5.3.0.6.5_108_P4.C0.04.bin','HuachenTel_OM200G')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('PBX.M5.3.0.6.5_108_P4.C0.04.bin','HuachenTel_OM200G-DC')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.N1.2.1.5mt.344_P2.C0.04.bin','HuachenTel_MX8A')
INSERT INTO dbo.OEMDeliver(bin_name,oem_cust_model)VALUES('GW.P1.2.1.5.344_P2.C0.04.bin','HuachenTel_HX4E')
--dbo.ZultysDeliver
INSERT INTO dbo.ZultysDeliver(newrock_name,zultys_name,template_id,bin_head)VALUES('HX4E','4FXO','TMPO005','BP01')
INSERT INTO dbo.ZultysDeliver(newrock_name,zultys_name,template_id,bin_head)VALUES('MX8A','8FXO','TMPO006','BN01')
INSERT INTO dbo.ZultysDeliver(newrock_name,zultys_name,template_id,bin_head)VALUES('MX60','48FXS','TMPO007','BH07')
INSERT INTO dbo.ZultysDeliver(newrock_name,zultys_name,template_id,bin_head)VALUES('MX60E','32S','TMPO008','BH05')
--dbo.IranKavaDeliver
INSERT INTO dbo.IranKavaDeliver(newrock_name,iran_name,bin_name)VALUES('OM20','Iran_Kava','OM.P1.2.1.11.5_113_P4.E0.02.bin')
INSERT INTO dbo.IranKavaDeliver(newrock_name,iran_name,bin_name)VALUES('OM50','Iran_Kava','OM.N1.2.1.11mt.5_113_P4.E0.02.bin')
INSERT INTO dbo.IranKavaDeliver(newrock_name,iran_name,bin_name)VALUES('MX8A','Iran_Kava','MX.N1.2.1.10mt.351.E0.05.bin')
INSERT INTO dbo.IranKavaDeliver(newrock_name,iran_name,bin_name)VALUES('MX120G','Iran_Kava','MX.F5.3.0.16.351.E0.02.bin')
--dbo.NewrockDeliver
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50中英标准','TMPN003','OM.N1','OM50 IPPBX','NNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM20中英标准','TMPN001','OM.P1','OM20 IPPBX','NPM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('HX4E标准','TMPN001','MX.P1','HX4E语音网关(VoIP  Gateway)','NP01','hx4');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50中英标准3C','TMPN004','OM.N1','OM50 IPPBX','NNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60标准交流','TMPN006','MX.H3','MX60语音网关(VoIP  Gateway)','NH07','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S标准单直流','TMPN007','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S标准双直流','TMPN007','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60标准直流','TMPN007','MX.H3','MX60语音网关(VoIP  Gateway)','NH07','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G标准单交流','TMPN010','MX.F5','MX120G语音网关(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G标准双交流','TMPN010','MX.F5','MX120G语音网关(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80中英标准','TMPN005','OM.H3','OM80 IPPBX','NHM6','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80SE中英标准','TMPN005','OM.H3','OM80 IPPBX入门版','NHM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200中英标准','TMPN005','OM.F3','OM200 IPPBX','NFM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200SE中英标准','TMPN005','OM.F3','OM200 IPPBX入门版','NFM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM500中英标准','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM501中英标准','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM502中英标准','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120标准','TMPN005','MX.F3','MX120语音网关(VoIP  Gateway)','NF01','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('SX3000标准单交流','TMPN005','SBC.L1','Session Border Controller','NLS2','SX3000@123');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G标准单交流','TMPN011','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G标准双交流','TMPN011','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G标准单直流','TMPN012','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G标准双直流','TMPN012','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM20白牌','TMPB001','PBX.P1','IPPBX','BPM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50白牌','TMPB001','PBX.N1','IPPBX','BNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('HX4E白牌','TMPB001','GW.P1','语音网关 VoIP Gateway','BP01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX8A白牌','TMPB001','GW.N1','语音网关 VoIP Gateway','BN01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80白牌','TMPB002','PBX.H3','IPPBX','BHM6','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80SE白牌','TMPB002','PBX.H3','IPPBX-SE','BHM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200白牌	','TMPB002','PBX.F3','IPPBX','BFM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200SE白牌','TMPB002','PBX.F3','IPPBX-SE','BFM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM500/501/502白牌','TMPB002','PBX.L1','IPPBX','BLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60白牌交流','TMPB002','GW.H3','语音网关 VoIP Gateway','BH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120白牌交流','TMPB002','GW.F3','语音网关 VoIP Gateway','BF01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G白牌单交流','TMPB002','GW.L1','中继网关 SIP-ISDN Gateway','BL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G白牌双交流','TMPB002','GW.L1','中继网关 SIP-ISDN Gateway','BL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌单直流','TMPB003','GW.L1','SIP-ISDN Gateway','BL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌双直流','TMPB003','GW.L1','SIP-ISDN Gateway','BL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60白牌直流','TMPB003','GW.H3','语音网关 VoIP Gateway','BH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌单交流','TMPB004','PBX.F5','IPPBX','BFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌双交流','TMPB004','PBX.F5','IPPBX','BFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌单交流','TMPB004','GW.F5','语音网关 VoIP Gateway','BF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌双交流','TMPB004','GW.F5','语音网关 VoIP Gateway','BF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌单直流','TMPB005','PBX.F5','IPPBX','BFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌双直流','TMPB005','PBX.F5','IPPBX','BFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌单直流','TMPB005','GW.F5','语音网关 VoIP Gateway','BF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌双直流','TMPB005','GW.F5','语音网关 VoIP Gateway','BF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX8A标准','TMPN002','MX.N1','MX8A语音网关(VoIP  Gateway)','NN01','mx8');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G标准单交流','TMPN008','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G标准双交流','TMPN008','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G标准单直流','TMPN009','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G标准双直流','TMPN009','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G标准单直流','TMPN009','MX.F5','MX120G语音网关(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G标准双直流','TMPN009','MX.F5','MX120G语音网关(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E标准单交流','TMPN013','MX.H5','MX60E语音网关(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E标准双交流','TMPN013','MX.H5','MX60E语音网关(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E标准单直流','TMPN014','MX.H5','MX60E语音网关(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E标准双直流','TMPN014','MX.H5','MX60E语音网关(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S标准单交流','TMPN015','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S标准双交流','TMPN015','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌单交流','TMPB006','GW.H5','语音网关 VoIP Gateway','BH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌双交流','TMPB006','GW.H5','语音网关 VoIP Gateway','BH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌单直流','TMPB007','GW.H5','语音网关 VoIP Gateway','BH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌双直流','TMPB007','GW.H5','语音网关 VoIP Gateway','BH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌单交流','TMPB008','GW.L1','中继网关 SIP-ISDN Gateway','BL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌双交流','TMPB008','GW.L1','中继网关 SIP-ISDN Gateway','BL08','voip');

--dbo.TadiranDeliver
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('HX404E','TGW4-4FXS','77449231410','77449231400','7442314','TMPO001','NGW.P1','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX8A-8S','TGW8S-2G','77449231510','77449231500','7442315','TMPO002','NGW.N1','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX8A–4S/4','TGW8-2G','77449230510','77449230500','7442305','TMPO002','NGW.N1','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-8S/8','TGW16-3G','77449265610','77449265600','7442656','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-8S/8-1DC','TGW16-3G-DC','77449265710','77449265700','7442657','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24SB','TGW24-16-3G','77449265810','77449265800','7442658','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24SB-1DC','TGW24-16-3G-DC','77449265910','77449265900','7442659','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24S','TGW24-24-3G','77449266010','77449266000','7442660','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24S-1DC','TGW24-24-3G-DC','77449266110','77449266100','7442661','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-16S/16B','TGW24-3G-16S/16B','77449266210','77449266200','7442662','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-16S/16B-1DC','TGW24-3G-16S/16B-DC','77449266310','77449266300','7442663','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24S/8B','TGW24-3G-24S/8B','77449266410','77449266400','7442664','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60E-24S/8B-1DC','TGW24-3G-24S/8B-DC','77449266510','77449266500','7442665','TMPO001','NGW.H5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-8S/8','TGW16-2G','77449255010','77449265000','7442650','TMPO003','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24SB','TGW24-16-2G','77449255110','77449265100','7442651','TMPO003','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24S','TGW24-24-2G','77449255210','77449265200','7442652','TMPO003','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-16S/16B','TGW24-2G-16S/16B','77449258210','77449268200','7442682','TMPO003','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-8S/8-1DC','TGW16-2G-DC','77449255310','77449265300','7442653','TMPO004','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24SB-1DC','TGW24-16-2G-DC','77449255410','77449265400','7442654','TMPO004','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24S-1DC','TGW24-24-2G-DC','77449255510','77449265500','7442655','TMPO004','NGW.H3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-8S/8','TGW16-2G','77449255010','77449255000','7442550','TMPO003','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24SB','TGW24-16-2G','77449255110','77449255100','7442551','TMPO003','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24S','TGW24-24-2G','77449255210','77449255200','7442552','TMPO003','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-8S/8-1DC','TGW16-2G-DC','77449255310','77449255300','7442553','TMPO004','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24SB-1DC','TGW24-16-2G-DC','77449255410','77449255400','7442554','TMPO004','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX60-24S-1DC','TGW24-24-2G-DC','77449255510','77449255500','7442555','TMPO004','NGW.H3','DO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-C','TGW96-24-2G','77449255610','77449255600','7442556','TMPO001','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-F','TGW96-96-2G','77449255710','77449255700','7442557','TMPO001','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-C-2AC','TGW96-24-2G-2AC','77449255810','77449255800','7442558','TMPO001','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-F-2AC','TGW96-96-2G-2AC','77449255910','77449255900','7442559','TMPO001','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-C-1DC','TGW96-24-2G-DC','77449256010','77449256000','7442560','TMPO004','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-F-1DC','TGW96-96-2G-DC','77449256110','77449256100','7442561','TMPO004','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-C-2DC','TGW96-24-2G-2DC','77449256210','77449256200','7442562','TMPO004','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120G-96FXS-F-2DC','TGW96-96-2G-2DC','77449256310','77449256300','7442563','TMPO004','NGW.F5','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-1E1/NC','TGW1E1-2G','77449230810','77449230800','7442308','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-2E1/NC','TGW2E1-2G','77449231010','77449231000','7442310','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-4E1/NC','TGW4E1-2G','77449230910','77449230900','7442309','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-2E1','TGW2E1','77449229710','77449229700','7442297','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-1E1-2AC/NC','TGW1E1-2G-2P','77449231610','77449231600','7442316','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-2E1-2AC/NC','TGW2E1-2G-2P','77449231710','77449231700','7442317','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-4E1-2AC/NC','TGW4E1-2G-2P','77449231810','77449231800','7442318','TMPO002','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-1E1-2DC/NC','TGW1E1-2G-2DC','77449256410','77449256400','7442564','TMPO004','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-2E1-2DC/NC','TGW2E1-2G-2DC','77449256510','77449256500','7442565','TMPO004','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX100G-4E1-2DC/NC','TGW4E1-2G-2DC','77449256610','77449256600','7442566','TMPO004','NGW.L1','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120-96FXS-C','TGW96-24','77449230610','77449230600','7442306','TMPO004','NGW.F3','NO');
INSERT INTO dbo.TadiranDeliver(newrock_name,tadiran_name,buy_cat,sell_cat,barcode,template_id,bin_head,remark)VALUES ('MX120-96FXS-F','TGW96-96','77449229510','77449229500','7442295','TMPO004','NGW.F3','NO');

