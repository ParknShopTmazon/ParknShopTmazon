
use parknshop;

-- user
-- -- customer  !!!!! NAME:123456  PASSWORD:123456 
insert into user(userId,name,password,role,status) values(12312,'c123456','c123456','customer','normal');
-- -- shop_owner
INSERT INTO `parknshop`.`user` (`userId`, `name`, `password`, `role`, `status`) VALUES (7878, 'cartTestUser', 'cartTest', 'shop_owner', 'normal');


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


-- product
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'wahaha',3.20,23.21,'Home & Office',34,12,'this is a children milk','onsell', 'images/product/78780.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'computer',4000.20,10000.21,'Computers & Tablets',65,42,'this is a computer','onsell', 'images/product/78781.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'atv',3000.20,230000.21,'TV& Home Theater',343,52,'this is a children milk','onsell', 'images/product/78782.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'apple',5000.20,2000003.21,'Cell Phones',49,122,'this is a children milk','onsell', 'images/product/78783.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'cameras',1000.20,11123.21,'Cameras & Camcorders',43,22,'this is a children milk','onsell', 'images/product/78784.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'audio',3.20,23.21,'Audio',34,12,'this is a children milk','onsell', 'images/product/78785.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'car',3.20,23.21,'Car Electronics & GPS',34,12,'this is a children milk','onsell', 'images/product/78786.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'game',3.20,23.21,'Video, Games, Movies & Music',34,12,'this is a children milk','onsell', 'images/product/78787.jpg');
insert into product(shopId,name,price,discountPrice,category,stockNum,soldNum,description,status, picture) values(7880,'health',3.20,23.21,'Health, Fitness & Sports',34,12,'this is a children milk','onsell', 'images/product/78788.jpg');

-- product
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`,status) VALUES ('78781', '7880', 'p4CartTest1', '32', '28', 'Audio', '400', '200', 'nice', 'images/product/78789.jpg','onsell');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`,status) VALUES ('78782', '7880', 'p4CartTest2', '12', '3', 'Audio', '12', '88', 'nice', 'images/product/78780.jpg','onsell');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`,status) VALUES ('78783', '7880', 'p4CartTest3', '34', '22', 'Audio', '56', '44', 'ok', 'images/product/78781.jpg','onsell');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`,status) VALUES ('78784', '7880', 'p4CartTest4', '178', '168', 'Home & Office', '12', '38', 'great', 'images/product/78782.jpg','onsell');
INSERT INTO `parknshop`.`product` (`productId`, `shopId`, `name`, `price`, `discountPrice`, `category`, `stockNum`, `soldNum`, `description`, `picture`,status) VALUES ('78785', '7880', 'p4CartTest5', '122', '98', 'Home & Office', '34', '12', 'ookk', 'images/product/78783.jpg','onsell');

-- update
UPDATE `parknshop`.`product` SET `status`='pulloff' WHERE `productId`='78781';
UPDATE `parknshop`.`product` SET `status`='pulloff' WHERE `productId`='78784';

-- productinfo
INSERT INTO `parknshop`.`productinfo` (`productId`, `size`, `color`) VALUES(78784,'M','#FFFFFF');
INSERT INTO `parknshop`.`productinfo` (`productId`, `size`, `color`) VALUES(78785,'LL','#FF00FF');

-- cart
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('12312', '78781', '3');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('12312', '78782', '1');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('12312', '78783', '2');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('12312', '78784', '1');
INSERT INTO `parknshop`.`cart` (`userId`, `productId`, `quantity`) VALUES ('12312', '78785', '1');


-- delivery
INSERT INTO `parknshop`.`delivery` (`deliveryId`, `company`, `price`, `type`) VALUES ('1', 'EMS', '10', 'normal');
INSERT INTO `parknshop`.`delivery` (`deliveryId`, `company`, `price`, `type`) VALUES ('2', 'EMS', '12', 'fast');
INSERT INTO `parknshop`.`delivery` (`deliveryId`, `company`, `price`, `type`) VALUES ('3', 'STO', '8', 'normal');
INSERT INTO `parknshop`.`delivery` (`deliveryId`, `company`, `price`, `type`) VALUES ('4', 'STO', '10', 'fast');

-- address
INSERT INTO `parknshop`.`address` (`addressId`, `userId`, `description`, `zipcode`, `name`, `phone`) VALUES ('1', '12312', 'xidian xxxxx', '710126', 'li', '13000000000');
INSERT INTO `parknshop`.`address` (`addressId`, `userId`, `description`, `zipcode`, `name`, `phone`) VALUES ('2', '12312', 'xibei xxxxxxx', '710000', 'wang', '13800000000');

-- orders
INSERT INTO `parknshop`.`orders` VALUES (100, 'online_payment', 'normal', now(), 12312, 1);

-- orderInfo
INSERT INTO `parknshop`.`orderInfo` VALUES (100, 1, 2, 78781, 'unpaid', null, null, null, '50256678700001');
INSERT INTO `parknshop`.`orderInfo` VALUES (100, 2, 1, 78782, 'unpaid', null, null, null, '50256678700002');

INSERT INTO `parknshop`.`orders` VALUES ('1', 'online_payment', 'normal', '2015-1-1', '12312', '1');
INSERT INTO `parknshop`.`orders` VALUES ('2', 'online_payment', 'normal', '2015-1-1', '12312', '1');

INSERT INTO `parknshop`.`orderinfo` VALUES ('1', '1', '2', '78781', 'unpaid', null, null, null, null);
INSERT INTO `parknshop`.`orderinfo` VALUES ('1', '1', '3', '78782', 'unpaid', null, null, null, null);
INSERT INTO `parknshop`.`orderinfo` VALUES ('2', '2', '2', '78781', 'unpaid', null, null, null, null);
INSERT INTO `parknshop`.`orderinfo` VALUES ('2', '1', '3', '78783', 'unpaid', null, null, null, null);
INSERT INTO `parknshop`.`orderinfo` VALUES ('2', '1', '3', '4', 'dealed', now(), now(), '5', null);


-- friend
INSERT INTO `parknshop`.`friend` VALUES (12312, 7878);

-- message

INSERT INTO `parknshop`.`message` VALUES (100, 12312, 7878, 'hello?', 0, now());
INSERT INTO `parknshop`.`message` VALUES (101, 7878, 12312, 'hello', 1, now());


INSERT INTO `parknshop`.`comment` (`commentId`, `userId`, `productId`, `content`, `commentTime`, `shopScore`, `productScore`, `deliveryScore`) VALUES ('1', '12312', '4', 'aaaaa', '2016-1-7', '3', '4', '3');
INSERT INTO `parknshop`.`comment` (`commentId`, `userId`, `productId`, `content`, `commentTime`, `shopScore`, `productScore`, `deliveryScore`) VALUES ('2', '12312', '4', 'bbbb', '2016-1-7', '3', '3', '3');
INSERT INTO `parknshop`.`comment` (`commentId`, `userId`, `productId`, `content`, `commentTime`, `shopScore`, `productScore`, `deliveryScore`) VALUES ('3', '12312', '4', 'ccccc', '2016-1-7', '3', '1', '2');

