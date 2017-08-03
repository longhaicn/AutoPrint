CREATE TABLE WorkerList(id int  identity(1,1) not null primary key,
workerid varchar(50) not null,
password varchar(50) not null,
role varchar(50) not null)

CREATE TABLE MacCheckRecord(id int  identity(1,1) not null primary key,
mac varchar(50) not null,
toprint varchar(50) not null, 
reason varchar(50) not null,
datetime varchar(50) not null)

CREATE TABLE MacAddressList(id int  identity(1,1) not null primary key,
part varchar(50) not null,
serial varchar(50) not null, 
mac varchar(50) not null,
checked varchar(50) not null,
datetime varchar(50) not null)

CREATE TABLE MacManager(id int  identity(1,1) not null primary key,
mac varchar(50) not null,
done varchar(50) not null, 
datetime varchar(50) not null)

CREATE TABLE PrintRecord(id int  identity(1,1) not null primary key,
worker varchar(50) not null,
printsum int not null, 
datetime varchar(50) not null)

--Deliver Table

CREATE TABLE NewrockDeliver(id int  identity(1,1) not null primary key,
label_sort varchar(50) not null,
template_id varchar(50) not null, 
bin_head varchar(50) not null,
product_name varchar(50) not null,
sn1234 varchar(50) not null,
pass varchar(50) not null)

CREATE TABLE OEMDeliver(id int  identity(1,1) not null primary key,
bin_name varchar(50) not null,
oem_cust_model varchar(50) not null)

CREATE TABLE ZultysDeliver(id int  identity(1,1) not null primary key,
newrock_name varchar(50) not null,
zultys_name varchar(50) not null, 
template_id varchar(50) not null,
bin_head varchar(50) not null)

CREATE TABLE ZTEDeliver(id int  identity(1,1) not null primary key,
newrock_name varchar(50) not null,
zte_name varchar(50) not null, 
template_id varchar(50) not null,
bin_head varchar(50) not null)

CREATE TABLE HuachenTelDeliver(id int  identity(1,1) not null primary key,
newrock_name varchar(50) not null,
huachentel_name varchar(50) not null, 
template_id varchar(50) not null,
bin_head varchar(50) not null)

CREATE TABLE IranKavaDeliver(id int  identity(1,1) not null primary key,
newrock_name varchar(50) not null,
iran_name varchar(50) not null, 
bin_name varchar(50) not null)

CREATE TABLE TadiranDeliver(id int  identity(1,1) not null primary key,
newrock_name varchar(50) not null,
tadiran_name varchar(50) not null, 
buy_cat varchar(50) not null,
sell_cat varchar(50) not null,
barcode varchar(50) not null,
template_id varchar(50) not null,
bin_head varchar(50) not null,
remark varchar(50) not null)






