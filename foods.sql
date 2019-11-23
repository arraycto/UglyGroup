create database uglygroup default character set utf8 collate utf8_bin;

--[用户表 user]
--用户编号 uid 主键
--账号 uname
--密码 upwd
--电话 utel
--邮箱 email
--用户角色  ustate 0.用户，1.店家，2.管理员
create table if not exists user(
	uid int primary key auto_increment,
	uname varchar(100) not null unique,
	upwd varchar(100) not null,
	utel varchar(11) unique,
	email varchar(20) unique,
	ustate int(1)
)ENGINE=InnoDB AUTO_INCREMENT=101 default charset=utf8 collate=utf8_bin;

--[美食类型表 foodtypes]
--类型编号 tid 主键
--类型名称 tname
create table if not exists foodtypes(
	tid int primary key auto_increment,
	tname varchar(100) not null unique
)ENGINE=InnoDB AUTO_INCREMENT=101 default charset=utf8 collate=utf8_bin;

--[地区表 area]
--地区序号 aid 主键
--地区名 aname
create table if not exists area(
	aid int primary key auto_increment,
	aname varchar(10) not null unique
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[店铺表 restaurant]
--店铺编号 rid 主键
--店主 uid 外键 [用户表 user]
--店铺区域 aid 外键 [地区表 area]
--店铺特色美食类型 tid 外键 [美食类型表 foodtypes]
--详细地址 radd 
--店铺名 rname
--店铺联系电话 rtel
--店铺图片 rpic
--店铺简介 rdisc
--店铺状态 rstate 0.营业 1.休息 2.审核中 3.已删除 4.未通过
create table if not exists restaurant(
	rid int primary key auto_increment,
	uid  int,
	aid int,
	tid int,
	radd  varchar(100) not null ,
	rname varchar(100) not null unique,
	rtel  varchar(30) not null,
	rpic varchar(1000),
	rdisc text,
	rstate int(2),
	constraint FK_restaurant_uid foreign key(uid) references user(uid),
	constraint FK_restaurant_aid foreign key(aid) references area(aid),
	constraint FK_restaurant_tid foreign key(tid) references foodtypes(tid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[店铺美食类型表 resfoodtype]
--美食编号 trid 主键
--店铺 rid 外键 [店铺表 restaurant]
--美食类型 trtype
create table if not exists resfoodtype(
	trid int primary key auto_increment,
	rid int,
	trtype varchar(100),
	constraint FK_resfoodtype_rid foreign key(rid) references restaurant(rid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[美食表 foods]
--美食编号 fid 主键
--美食类型 trid 外键 [店铺美食类型表 resfoodtype]
--所属店铺 rid 外键 [店铺表 restaurant]
--美食名称 fname
--价格 fprice
--图片 fpic
--状态 fstate 0.已下架 1.已售完 2.销售中
--简介 fdisc
create table if not exists foods(
	fid int primary key auto_increment,
	trid  int,
	rid  int,
	fname varchar(100) not null,
	fprice float(10,2) not null,
	fpic varchar(1000),
	fstate int(1),
	fdisc varchar(1000),
	constraint FK_foods_trid foreign key(trid) references resfoodtype(trid),
	constraint FK_foods_rid foreign key(rid) references Restaurant(rid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[活动表 action]
--活动编号 acid
--店铺 rid 外键 [店铺表 restaurant]
--actype 活动类型 0.满减 1.打折
--活动id生成方法 action+5位随机数+店铺id+当前时间 
create table if not exists action(
	acid varchar(100) primary key ,
	rid int,
	actype int(1),
	constraint FK_action_rid foreign key(rid) references restaurant(rid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--[活动详细表 actiondetail]
--活动详细编号 adid
--美食编号 fid 外键 [美食表 foods]
--活动编号 acid 外键 [活动表 action]
--折扣 discount
--满减下限 lowmin
--满减金额 remoney
--活动起始时间 acptime
--活动结束时间 acendtime
--满减数量 acnum
--活动状态 acstate 0.活动中 1.已结束
create table if not exists actiondetail(
	adid int primary key auto_increment,
	fid int,
	acid varchar(100),
	discount float(3,2),
	lowmin int,
	remoney int,
	acptime Datetime,
	acendtime Datetime,
	acnum int,
	acstate int(1),
	constraint FK_actiondetail_fid foreign key(fid) references foods(fid),
	constraint FK_actiondetail_acid foreign key(acid) references action(acid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[收获地址表 addressreceipt]
--地址编号 arid
--用户编号 uid 外键 [用户表 user]
--地区序号 aid 外键【地区表 area】
--收货人姓名 arname (默认为当前用户)
--收货人电话 artel(默认为当前用户)
--收货地址 aradd
create table if not exists addressreceipt(
	arid int primary key auto_increment,
	uid int,
	aid int,
	arname varchar(10) not null,
	artel  varchar(20) not null,
	aradd  varchar(100) not null,
	constraint FK_addressreceipt_uid foreign key(uid) references user(uid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

--[订单表 foodorder]
--订单编号 oid
--下单用户 uid 外键 [用户表 user]
--地址编号 arid 外键 [收获地址表 addressreceipt]
--总价格 oprice
--下单时间 otime
--实际送达时间 endtime
--订单状态 ostate 0.已下单 1.已付款 2.已送达 3.已取消
create table if not exists foodorder(
	oid varchar(250) primary key unique,--以uglygroup加5位随机数加时间戳生成
	uid  int,
	arid int,
	oprice float(10,2) not null,
	otime Datetime not null,
	endtime Datetime ,
	ostate int(2),
	constraint FK_foodorder_uid foreign key(uid) references user(uid),
	constraint FK_foodorder_arid foreign key(arid) references addressreceipt(arid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--[订单详情表 orderdetail]
--订单详情编号 did
--订单号 oid 外键 [订单表 foodorder]
--美食编号 fid 外键 [美食表 foods]
--食品数量 num
--交易金额 price
create table if not exists orderdetail(
	did int primary key auto_increment,
	oid varchar(250),
	fid int,
	num int,
	price float(10,2) not null,
	constraint FK_orderdetail_uid foreign key(oid) references foodorder(oid),
	constraint FK_orderdetail_fid foreign key(fid) references foods(fid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;