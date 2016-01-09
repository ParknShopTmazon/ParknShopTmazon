
use parknshop;

-- admin;


INSERT INTO user(userId,name,password,role,status) VALUES (3,'admin0','admin0','admin','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (4,'admin1','admin1','admin','normal');

-- user;


INSERT INTO user(userId,name,password,role,status) VALUES (5,'ruirui','ruirui','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (6,'zhengzheng','zhengzheng','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (7,'kuaile','kuaile','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (8,'marvel','marvel','shop_owner','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (9,'create','create','shop_owner','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (10,'gaoxin','gaoxin','shop_owner','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (11,'kuaile0','kuaile','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (12,'hahaha','hahaha','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (13,'gagaga','gagaga','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (14,'qqqqq','qqqqq','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (15,'aaaaa','aaaaa','customer','normal');
INSERT INTO user(userId,name,password,role,status) VALUES (16,'qwerty','qwerty','customer','normal');


-- shop-apply;


insert into shop(shopId,name,type,status,owner) values(7881,'aaa','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7882,'bbb','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7883,'ccc','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7884,'ddd','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7885,'eee','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7886,'fff','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7887,'ggg','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7888,'hhh','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7889,'abc','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7890,'fadfas','company','checking',7878);
insert into shop(shopId,name,type,status,owner) values(7891,'iojio','company','checking',7878);

-- rate;

insert into rate(rate) value('0.055');

-- advertisement;


INSERT INTO `parknshop`.`advertisement` VALUES (1,1,50,null);
INSERT INTO `parknshop`.`advertisement` VALUES (2,2,30,null);
INSERT INTO `parknshop`.`advertisement` VALUES (3,3,40,null);
INSERT INTO `parknshop`.`advertisement` VALUES (4,4,50,null);
INSERT INTO `parknshop`.`advertisement` VALUES (6,6,150,null);
INSERT INTO `parknshop`.`advertisement` VALUES (7,7,90,null);
INSERT INTO `parknshop`.`advertisement` VALUES (8,8,50,null);
INSERT INTO `parknshop`.`advertisement` VALUES (9,78781,130,null);

--orderInfo


INSERT INTO `parknshop`.`orderinfo` VALUES (1, 1, 5, 78783, 'dealed','2016-01-08 13:53:17', '2016-01-08 14:53:17', '5', null);
INSERT INTO `parknshop`.`orderinfo` VALUES (2, 1, 3, 78782, 'dealed', '2016-01-07 16:52:17', '2016-01-07 17:53:17', '5', null);
INSERT INTO `parknshop`.`orderinfo` VALUES (100, 1, 1, 78783, 'dealed','2016-01-08 23:53:17', '2016-01-08 13:53:18', '5', null);
INSERT INTO `parknshop`.`orderinfo` VALUES (100, 1, 2,78784, 'dealed', '2016-01-07 13:53:17', '2016-01-07 14:53:17', '5', null);
