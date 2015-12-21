
use parknshop;

-- user
-- -- customer  !!!!! NAME:13121302  PASSWORD:13121302 
insert into user(userId,name,password,role,status) values(13121302,'13121302','13121302','shop_owner','normal');
-- -- shop_owner
INSERT INTO `parknshop`.`user` (`userId`, `name`, `password`, `role`, `status`) VALUES (7878, 'cartTestUser', 'cartTest', 'customer', 'normal');


-- shop
insert into shop(shopId,name,type,status,owner) values(7880,'131213','company','success',7878);

-- category
insert into category values('TV& Home Theater');
insert into category values('Computers & Tablets');
insert into category values('Cell Phones');
insert into category values('Cameras & Camcorders');
insert into category values('Audio');
insert into category values('Car Electronics & GPS');
insert into category values('Video, Games, Movies & Music');
insert into category values('Health, Fitness & Sports');
insert into category values('Home & Office');



insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'wahaha',3.20,23.21,'Home & Office',34,12,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'computer',4000.20,10000.21,'Computers & Tablets',65,42,'this is a computer');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'atv',3000.20,230000.21,'TV& Home Theater',343,52,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'apple',5000.20,2000003.21,'Cell Phones',49,122,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'cameras',1000.20,11123.21,'Cameras & Camcorders',43,22,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'audio',3.20,23.21,'Audio',34,12,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'car',3.20,23.21,'Car Electronics & GPS',34,12,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'game',3.20,23.21,'Video, Games, Movies & Music',34,12,'this is a children milk');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description) values(7880,'health',3.20,23.21,'Health, Fitness & Sports',34,12,'this is a children milk');

-- product
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`) VALUES ('78781', '7880', 'p4CartTest1', '32', '28', 'Audio', '400', '200', 'nice', '#');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`) VALUES ('78782', '7880', 'p4CartTest2', '12', '3', 'Audio', '12', '88', 'nice', '#');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`) VALUES ('78783', '7880', 'p4CartTest3', '34', '22', 'Audio', '56', '44', 'ok', '#');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`) VALUES ('78784', '7880', 'p4CartTest4', '178', '168', 'Home & Office', '12', '38', 'great', '#');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`) VALUES ('78785', '7880', 'p4CartTest5', '122', '98', 'Home & Office', '34', '12', 'ookk', '#');


-- productinfo
INSERT INTO `parknshop`.`productinfo` (`productId`, `size`, `color`) VALUES(78784,'M','#FFFFFF');
INSERT INTO `parknshop`.`productinfo` (`productId`, `size`, `color`) VALUES(78785,'LL','#FF00FF');

-- cart
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('13121302', '78781', '3');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('13121302', '78782', '1');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('13121302', '78783', '2');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('13121302', '78784', '1');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('13121302', '78785', '1');


