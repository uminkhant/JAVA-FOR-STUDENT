drop database if exists shop_db;

create database shop_db;

use shop_db;

create table address_tbl(
	id int primary key auto_increment,
	street varchar(255) not null,
	township varchar(50),
	city varchar(50)
);

insert into address_tbl values(null,'no(79)၊ thuya street၊ 9 block၊ near ponnami gate','south oakkalar','yangon');
insert into address_tbl values(null,'Waizayandar Yeik Thar 5th Street','thingangyun','yangon');
insert into address_tbl values(null,'Sugical Unit 3, YGH','lathar','yangon');	

create table member_tbl(
	id int primary key auto_increment,
	login varchar(8) not null,
	password varchar(8) not null,
	phone1 varchar(12)not null,
	phone2 varchar(12),
	address_id int not null,
	role enum('Member','Admin') not null default 'Member',
	foreign key(address_id)references address_tbl(id)
	on update cascade on delete cascade
	);


insert into member_tbl values(null,'minkhant','admin123','0946345343','0934534293',1,1);
insert into member_tbl values(null,'mkt','123','09242222332','09345353344',1,2);



create table category_tbl(
	id int primary key auto_increment,
	cat_name varchar(8) not null,
	cat_size enum('SMALL','MEDIUM','LARGE'),
	cat_sex enum('MALE','FEMALE','UNISEX')
);


insert into category_tbl values(null,'T-shirt',1,1);
insert into category_tbl values(null,'T-shirt',1,2);
insert into category_tbl values(null,'T-shirt',1,3);
insert into category_tbl values(null,'Trouser',2,1);
insert into category_tbl values(null,'Trouser',2,2);
insert into category_tbl values(null,'Trouser',2,3);
insert into category_tbl values(null,'Shoe',3,1);
insert into category_tbl values(null,'Shoe',3,2);
insert into category_tbl values(null,'Shoe',3,3);

create table item_tbl(

	id int primary key auto_increment,
	item_name varchar(20) not null,
	item_price int not null,
	item_img varchar(50)  not null,
	item_desc varchar(255) ,
	cat_id int not null,
	crd_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	foreign key(cat_id) references category_tbl(id)
	
);

insert into item_tbl values(null,'Uniqlo u crew neck',300,'cottonplainuneck1.jpg','this is testing with u neck t-shirt',1,null);
insert into item_tbl values(null,'Uniqlo u crew neck',300,'cottonplainuneck1.jpg','this is testing with u neck t-shirt',2,null);
insert into item_tbl values(null,'Uniqlo u crew neck',300,'cottonplainuneck1.jpg','this is testing with u neck t-shirt',3,null);

insert into item_tbl values(null,'ushape',120,'ushape1.jpeg','this is testing with u neck t-shirt',2,null);
insert into item_tbl values(null,'vneck',200,'vneck.jpg','this is testing with u neck t-shirt',2,null);
insert into item_tbl values(null,'vneck',220,'vneck.jpg','this is testing with u neck t-shirt',2,null);

insert into item_tbl values(null,'timberland',100,'so1.jpg','this is testing with u neck t-shirt',7,null);
insert into item_tbl values(null,'scholl',200,'so2.jpg','this is testing with u neck t-shirt',8,null);
insert into item_tbl values(null,'scholl',250,'so4.jpeg','this is testing with u neck t-shirt',9,null);

insert into item_tbl values(null,'trouser 1',400,'tr1.jpeg','this is testing with u neck t-shirt',4,null);
insert into item_tbl values(null,'trouser 2',300,'tr2.jpeg','this is testing with u neck t-shirt',5,null);
insert into item_tbl values(null,'trouser 3',340,'tr3.jpg','this is testing with u neck t-shirt',6,null);

insert into item_tbl values(null,'Shirt 1',300,'sh1.jpg','this is testing with u neck t-shirt',1,null);
insert into item_tbl values(null,'Shirt 2',500,'sh2.jpg','this is testing with u neck t-shirt',2,null);
insert into item_tbl values(null,'Shirt 3',700,'sh3.jpg','this is testing with u neck t-shirt',3,null);


create table order_tbl(

	id int primary key auto_increment,
	member_id int not null,
	total_price int ,
	discount int ,
	delivered_dt TIMESTAMP  ,
	order_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	foreign key(member_id)references member_tbl(id)
);

create table order_details_tbl(
	id int primary key auto_increment,
	order_id int not null,
	qty int not null,
	total int not null,
	item_id int not null,
	foreign key(order_id) references order_tbl(id),
	foreign key(item_id)references item_tbl(id)
);


