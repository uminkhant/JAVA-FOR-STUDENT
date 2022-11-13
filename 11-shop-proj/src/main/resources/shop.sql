drop database if exists shop_db;

create database shop_db;

use shop_db;

create table member_tbl(
	login varchar(8) primary key,
	password varchar(8) not null,
	role enum('Member','Admin') not null default 'Member'
	);


insert into member_tbl values('minkhant','admin123',1);
insert into member_tbl values('mkt','123',2);

create table category_tbl(
	id int primary key auto_increment,
	cat_name varchar(8) not null,
	cat_size enum('Small','Medium','Large'),
	cat_sex  enum('Male','Female','Unisex')

);

insert into category_tbl values(null,'T-shirt',1,1);
insert into category_tbl values(null,'T-shirt',2,1);
insert into category_tbl values(null,'T-shirt',3,1);


create table address_tbl(
	id int primary key auto_increment,
	street varchar(255) not null,
	township varchar(50),
	city varchar(50)
);

insert into address_tbl values(null,'no(79)၊ thuya street၊ 9 block၊ near ponnami gate','south oakkalar','yangon');
insert into address_tbl values(null,'Waizayandar Yeik Thar 5th Street','thingangyun','yangon');
insert into address_tbl values(null,'Sugical Unit 3, YGH','lathar','yangon');	

create table customer_tbl(

	id int primary key auto_increment,
	cu_name varchar(20) not null,
	cu_phone1 varchar(12)not null,
	cu_phone2 varchar(12),
	address_id int not null,
	foreign key(address_id)references address_tbl(id)
);

insert into customer_tbl values(null,'sandar','0946345343','0934534293',1);
insert into customer_tbl values(null,'myat thuzar','09463433323','09343423233',2);
insert into customer_tbl values(null,'yan naung','09242222332','09345353344',1);

create table item_tbl(

	id int primary key auto_increment,
	item_name varchar(20) not null,
	item_price int  not null,
	item_img varchar(50)  not null,
	item_desc varchar(255) ,
	cat_id int not null,
	crd_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	foreign key(cat_id) references category_tbl(id)
);

