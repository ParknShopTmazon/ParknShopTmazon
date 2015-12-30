<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Shop Income</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/order.css">
</head>
<body>
    <%@ include file="header.html"%>
	
    <hr/>
	<div class="container">
		<div id="content">
		<div class="order-form">
			<div>
			shop Name
			<select>
				<option>ALL</option>
				<option>ShopName1</option>
				<option>ShopName2</option>
				<option>ShopName3</option>
			</select>
			Date:
			<select>
				<option>Near one day</option>
				<option>Near one week</option>
				<option>Near one Month</option>
				<option>Near one year</option>
			</select>
		</div>
			<div class="order-item item-form-head">
				<div class="item-form-head-info"><span>Order Information</span></div>
				<div class="item-form-head-mum"><span>Num</span></div>
				<div class="item-form-head-totalprice"><span>Total</span></div>
				<div class="item-form-head-orderstate"><span>State</span></div>
				<div class="item-product-manage"><span>Remark</span></div>
			</div>
			<div class="order-item ">
				<div class="item-product-id"><span>Order ID:<a href="">13121217</a></span></div>
				<div class="item-product-photo"><img src="images_shop/fish.jpg"></div>
				<div class="item-name-time-shop"><a href="">good fish</a><br/><span>Trade Date:&nbsp;2015-13-54</span></div>
				<div class="item-product-mum"><span>1</span></div>
				<div class="item-product-totalprice"><span>$32</span></div>
				<div class="item-product-orderstate"><span>XXXXX</span></div>
				<div class="item-product-manage"><span>view</span></div>
			</div>
			<div class="order-item ">
				<div class="item-product-id"><span>Order ID:<a href="">13121218</a></span></div>
				<div class="item-product-photo"><img src="images_shop/hehe.jpg"></div>
				<div class="item-name-time-shop"><a href="">China MM</a><br/><span>Trade Date:&nbsp;2015-13-54</span></div>
				<div class="item-product-mum"><span>1</span></div>
				<div class="item-product-totalprice"><span>$39</span></div>
				<div class="item-product-orderstate"><span>XXXXX</span></div>
				<div class="item-product-manage"><span>view</span></div>
			</div>
			<div class="order-item ">
				<div class="item-product-id"><span>Order ID:<a href="">13121219</a></span></div>
				<div class="item-product-photo"><img src="images_shop/hehe.jpg"></div>
				<div class="item-name-time-shop"><a href="">China MM</a><br/><span>Trade Date:&nbsp;2015-13-54</span></div>
				<div class="item-product-mum"><span>1</span></div>
				<div class="item-product-totalprice"><span>$39</span></div>
				<div class="item-product-orderstate"><span>State</span></div>
				<div class="item-product-manage"><span>view</span></div>
			</div>
		</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>

