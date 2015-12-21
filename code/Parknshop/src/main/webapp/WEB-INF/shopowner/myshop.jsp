<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Register New  Store</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/rs.css">
<meta charset="text/html UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
<title>parknshop</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">
</head>
<body>
   <%@ include file="header.html"%>
<!-- 	<div id=head> -->
<!-- 			<img id="logo" src="images_shop/logo.png"> -->
<!-- 			<span id="topline"> -->
<!-- 				<a href="../public/index.html">Home_page|</a> -->
<!-- 				<a href="../seller/Update_store_information.html" >Store_information|</a> -->
<!-- 				<a href="../seller/Account_setting.html">Accont_setting</a></font> -->
<!-- 			</span> -->
<!-- 	</div> -->
    <hr/>
	<div id="menu"></div>
	<div id="container">
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="images_shop/shop1.jpg" alt="��"></a></div>
			<div><a id="shopname" href=""><span id="">shop name1</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="images_shop/shop2.jpg" alt="��"></a></div>
			<div><a id="shopname" href=""><span id="">shop name2</span></a></div>
			<div>more info</div>	
		</div>
		<!--  
		<div id="shopinfo">
			<div><a href="Register New Store.html"><img src=" images_shop/plus.jpg " alt=" "></a></div>
			<div><a id="shopname" href="Register New Shop.html"><span>click picture to add<span></a></div>
		</div>
		-->
		
		<div id="shopinfo">
		<!-- 
			<div ><a href="RegisterNewStore.html"><img src=" images_shop/plus.jpg " alt=" "></a></div>
			 --> 
			 <div onclick="window.open('registershoppage')"><img src=" images_shop/plus.jpg " alt=" "></div>
			<div id="shopname" onclick="window.open('registershoppage')"><span>add new store<span></div>
		</div>
	
	</div>
	 <div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
	</div>
</body>
</html>
