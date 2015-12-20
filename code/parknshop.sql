CREATE DATABASE parknshop character set  utf8 collate utf8_general_ci;

USE parknshop;

CREATE TABLE user (
	user_id int AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	role varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	PRIMARY KEY (user_id),
	UNIQUE (name)
);

CREATE TABLE address(
	user_id int NOT NULL,
	province varchar(50),
	city varchar(50),
	country varchar(50),
	street varchar(50),
	FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE user_info(
	user_id int NOT NULL,
	phone varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	real_name varchar(50) NOT NULL,
	sex bit NOT NULL,
	birthday date NOT NULL,
	detail text,
	alipay varchar(50) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE shop(
	shop_id int AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	type varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	owner int NOT NULL,
	CONSTRAINT pk_shop_id PRIMARY KEY (shop_id),
	FOREIGN KEY (owner) REFERENCES user(user_id)
);

CREATE TABLE category (
	category varchar(50),
	PRIMARY KEY (category)
);

CREATE TABLE product (
	product_id int AUTO_INCREMENT,
	shop_id int NOT NULL,
	name varchar(50) NOT NULL,
	price decimal(10,2) NOT NULL,
	discont_price decimal(10,2) NOT NULL,
	category varchar(50) NOT NULL,
	stock_num int NOT NULL,
	sold_num int NOT NULL,
	description text NOT NULL,
	picture varchar(100),
	PRIMARY KEY (product_id),
	FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
	FOREIGN KEY (category) REFERENCES category(category)
);

CREATE TABLE product_info (
	product_id int,
	size varchar(50),
	color varchar(50),
	FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE delivery(
	delivery_id int AUTO_INCREMENT,
	company varchar(50) NOT NULL,
	price decimal(10,2) NOT NULL,
	type varchar(50) NOT NULL,
	PRIMARY KEY (delivery_id)
);

CREATE TABLE orders (
	order_id int AUTO_INCREMENT,
	pay_type varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	order_time datetime NOT NULL,
	user_id int NOT NULL,
	delivery_id int NOT NULL,
	PRIMARY KEY (order_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (delivery_id) REFERENCES delivery(delivery_id)
	
);

CREATE TABLE order_info(
	quantity int NOT NULL,
	product_id int NOT NULL,
	order_id int NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product(product_id),
	FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

CREATE TABLE cart (
	user_id int NOT NULL,
	product_id int NOT NULL,
	quantity int NOT NULL,
	PRIMARY KEY (user_id, product_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE friend (
	user_id int NOT NULL,
	friend_id int NOT NULL,
	PRIMARY KEY (user_id, friend_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (friend_id) REFERENCES user(user_id)
);

CREATE TABLE message(
	user_id int NOT NULL,
	friend_id int NOT NULL,
	content text NOT NULL,
	message_time datetime NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (friend_id) REFERENCES user(user_id)
);

CREATE TABLE comment(
	comment_id int AUTO_INCREMENT,
	user_id int NOT NULL,
	product_id int NOT NULL,
	content text NOT NULL,
	comment_time datetime NOT NULL,
	reply_id int,
	CONSTRAINT pk_comment_id PRIMARY KEY (comment_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id),
	FOREIGN KEY (reply_id) REFERENCES comment(comment_id)
);

