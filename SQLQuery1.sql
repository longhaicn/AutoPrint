
CREATE TABLE MacAddressList(id int  identity(1,1) not null primary key,
part varchar(50) not null,
serial varchar(50) not null, 
mac varchar(50) not null,
checked varchar(50) not null,
datetime varchar(50) not null)

CREATE TABLE MacCheckRecord(id int  identity(1,1) not null primary key,
mac varchar(50) not null,
toprint varchar(50) not null, 
reason varchar(50) not null,
datetime varchar(50) not null)

CREATE TABLE MacManager(id int  identity(1,1) not null primary key,
mac varchar(50) not null,
done varchar(50) not null, 
datetime varchar(50) not null)

CREATE TABLE NewrockDeliver(id int  identity(1,1) not null primary key,
label_sort varchar(50) not null,
template_id varchar(50) not null, 
bin_head varchar(50) not null,
product_name varchar(50) not null,
sn1234 varchar(50) not null,
pass varchar(50) not null)

CREATE TABLE PrintRecord(id int  identity(1,1) not null primary key,
worker varchar(50) not null,
printsum int not null, 
datetime varchar(50) not null)


CREATE TABLE WorkerList(id int  identity(1,1) not null primary key,
workerid varchar(50) not null,
password varchar(50) not null,
role varchar(50) not null)

INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('A','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('B','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('C','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('D','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('E','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('F','AAA','W');
INSERT INTO dbo.WorkerList(workerid,password,role)VALUES ('Manager','AAA','M');
SELECT * FROM dbo.NewrockDeliver
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50��Ӣ��׼','TMPN003','OM.N1','OM50 IPPBX','NNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM20��Ӣ��׼','TMPN001','OM.P1','OM20 IPPBX','NPM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('HX4E��׼','TMPN001','MX.P1','HX4E��������(VoIP  Gateway)','NP01','hx4');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50��Ӣ��׼3C','TMPN004','OM.N1','OM50 IPPBX','NNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60��׼����','TMPN006','MX.H3','MX60��������(VoIP  Gateway)','NH07','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S��׼��ֱ��','TMPN007','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S��׼˫ֱ��','TMPN007','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60��׼ֱ��','TMPN007','MX.H3','MX60��������(VoIP  Gateway)','NH07','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G��׼������','TMPN010','MX.F5','MX120G��������(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G��׼˫����','TMPN010','MX.F5','MX120G��������(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80��Ӣ��׼','TMPN005','OM.H3','OM80 IPPBX','NHM6','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80SE��Ӣ��׼','TMPN005','OM.H3','OM80 IPPBX���Ű�','NHM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200��Ӣ��׼','TMPN005','OM.F3','OM200 IPPBX','NFM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200SE��Ӣ��׼','TMPN005','OM.F3','OM200 IPPBX���Ű�','NFM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM500��Ӣ��׼','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM501��Ӣ��׼','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM502��Ӣ��׼','TMPN005','OM.L1','OM500 IPPBX','NLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120��׼','TMPN005','MX.F3','MX120��������(VoIP  Gateway)','NF01','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('SX3000��׼������','TMPN005','SBC.L1','Session Border Controller','NLS2','SX3000@123');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G��׼������','TMPN011','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G��׼˫����','TMPN011','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G��׼��ֱ��','TMPN012','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G��׼˫ֱ��','TMPN012','MX.L1','SIP-ISDN Gateway','NL02','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM20����','TMPB001','PBX.P1','IPPBX','PPM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50����','TMPB001','PBX.N1','IPPBX','PNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('HX4E����','TMPB001','GW.P1','�������� VoIP Gateway','PP01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX8A����','TMPB001','GW.N1','�������� VoIP Gateway','PN01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80����','TMPB002','PBX.H3','IPPBX','PHM6','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80SE����','TMPB002','PBX.H3','IPPBX-SE','PHM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200����	','TMPB002','PBX.F3','IPPBX','PFM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200SE����','TMPB002','PBX.F3','IPPBX-SE','PFM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM500/501/502����','TMPB002','PBX.L1','IPPBX','PLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60���ƽ���','TMPB002','GW.H3','�������� VoIP Gateway','PH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120���ƽ���','TMPB002','GW.F3','�������� VoIP Gateway','PF01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G���Ƶ�����','TMPB002','GW.L1','�м����� SIP-ISDN Gateway','PL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G����˫����','TMPB002','GW.L1','�м����� SIP-ISDN Gateway','PL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S���Ƶ�ֱ��','TMPB003','GW.L1','SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S����˫ֱ��','TMPB003','GW.L1','SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60����ֱ��','TMPB003','GW.H3','�������� VoIP Gateway','PH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G���Ƶ�����','TMPB004','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G����˫����','TMPB004','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G���Ƶ�����','TMPB004','GW.F5','�������� VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G����˫����','TMPB004','GW.F5','�������� VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G���Ƶ�ֱ��','TMPB005','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G����˫ֱ��','TMPB005','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G���Ƶ�ֱ��','TMPB005','GW.F5','�������� VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G����˫ֱ��','TMPB005','GW.F5','�������� VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX8A��׼','TMPN002','MX.N1','MX8A��������(VoIP  Gateway)','NN01','mx8');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G��׼������','TMPN008','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G��׼˫����','TMPN008','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G��׼��ֱ��','TMPN009','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G��׼˫ֱ��','TMPN009','OM.F5','OM200G IPPBX','NFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G��׼��ֱ��','TMPN009','MX.F5','MX120G��������(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G��׼˫ֱ��','TMPN009','MX.F5','MX120G��������(VoIP  Gateway)','NF05','mx120');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E��׼������','TMPN013','MX.H5','MX60E��������(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E��׼˫����','TMPN013','MX.H5','MX60E��������(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E��׼��ֱ��','TMPN014','MX.H5','MX60E��������(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E��׼˫ֱ��','TMPN014','MX.H5','MX60E��������(VoIP  Gateway)','NH05','mx60');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S��׼������','TMPN015','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S��׼˫����','TMPN015','MX.L1','SIP-ISDN Gateway','NL08','mx100');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E���Ƶ�����','TMPB006','GW.H5','�������� VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E����˫����','TMPB006','GW.H5','�������� VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E���Ƶ�ֱ��','TMPB007','GW.H5','�������� VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E����˫ֱ��','TMPB007','GW.H5','�������� VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S���Ƶ�����','TMPB008','GW.L1','�м����� SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S����˫����','TMPB008','GW.L1','�м����� SIP-ISDN Gateway','PL08','voip');


