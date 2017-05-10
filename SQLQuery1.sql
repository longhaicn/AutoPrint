
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
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM20白牌','TMPB001','PBX.P1','IPPBX','PPM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM50白牌','TMPB001','PBX.N1','IPPBX','PNM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('HX4E白牌','TMPB001','GW.P1','语音网关 VoIP Gateway','PP01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX8A白牌','TMPB001','GW.N1','语音网关 VoIP Gateway','PN01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80白牌','TMPB002','PBX.H3','IPPBX','PHM6','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM80SE白牌','TMPB002','PBX.H3','IPPBX-SE','PHM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200白牌	','TMPB002','PBX.F3','IPPBX','PFM1','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200SE白牌','TMPB002','PBX.F3','IPPBX-SE','PFM0','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM500/501/502白牌','TMPB002','PBX.L1','IPPBX','PLM2','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60白牌交流','TMPB002','GW.H3','语音网关 VoIP Gateway','PH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120白牌交流','TMPB002','GW.F3','语音网关 VoIP Gateway','PF01','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G白牌单交流','TMPB002','GW.L1','中继网关 SIP-ISDN Gateway','PL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G白牌双交流','TMPB002','GW.L1','中继网关 SIP-ISDN Gateway','PL02','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌单直流','TMPB003','GW.L1','SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌双直流','TMPB003','GW.L1','SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60白牌直流','TMPB003','GW.H3','语音网关 VoIP Gateway','PH07','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌单交流','TMPB004','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌双交流','TMPB004','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌单交流','TMPB004','GW.F5','语音网关 VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌双交流','TMPB004','GW.F5','语音网关 VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌单直流','TMPB005','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('OM200G白牌双直流','TMPB005','PBX.F5','IPPBX','PFM5','admin');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌单直流','TMPB005','GW.F5','语音网关 VoIP Gateway','PF05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX120G白牌双直流','TMPB005','GW.F5','语音网关 VoIP Gateway','PF05','voip');
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
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌单交流','TMPB006','GW.H5','语音网关 VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌双交流','TMPB006','GW.H5','语音网关 VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌单直流','TMPB007','GW.H5','语音网关 VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX60E白牌双直流','TMPB007','GW.H5','语音网关 VoIP Gateway','PH05','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌单交流','TMPB008','GW.L1','中继网关 SIP-ISDN Gateway','PL08','voip');
INSERT INTO dbo.NewrockDeliver(label_sort,template_id,bin_head,product_name,sn1234,pass)VALUES ('MX100G-S白牌双交流','TMPB008','GW.L1','中继网关 SIP-ISDN Gateway','PL08','voip');


