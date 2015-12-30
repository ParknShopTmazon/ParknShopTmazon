<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>MyShop Homepage</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/photobox.css">
</head>

<body>
   <%@ include file="header.html"%>
  
	<div id="shoplist">
		<div class="shopbox">
			<div class="shopphoto" onclick="window.open('selectedshop')"><img src="images_shop/shop1.jpg"  class="shop-img-box" alt="no p no t"></div>
			<div><a class="shopname" href=""><span id="">store name1</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div class="shopbox">
			<div class="shopphoto"><a href=""><img src="images_shop/shop2.jpg"  class="shop-img-box" alt="no p no t"></a></div>
			<div><a class="shopname" href=""><span id="">store name2</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div class="shopbox">
			<div class="shopphoto"><a href=""><img src="images_shop/shop3.jpg"  class="shop-img-box" alt="no p no t"></a></div>
			<div><a class="shopname" href=""><span id="">store name3</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div class="shopbox">
			<div class="shopphoto"><a href=""><img src="images_shop/shop4.jpg"  class="shop-img-box" alt="no p no t"></a></div>
			<div><a class="shopname" href=""><span id="">store name4</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div class="shopbox">
			<div class="shopphoto"><a href=""><img src="images_shop/shop5.jpg"  class="shop-img-box" alt="no p no t"></a></div>
			<div><a class="shopname" href=""><span id="">store name5</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div class="shopbox">
			<div class="shopphoto"><a href=""><img src="images_shop/shop6.jpg"  class="shop-img-box" alt="no p no t"></a></div>
			<div><a class="shopname" href=""><span id="">store name6</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		
		<div class="shopbox">
			<div  class="shopphoto" onclick="window.open('registershoppage')"><img src="images_shop/plus.jpg" class="shop-img-box" alt=" "></div>
			<div><span id="">Add a new one</span></div>
			<div id="shopname" onclick="window.open('registershoppage')">more info</div>	
		</div>
	</div>
	</div>
	<%@ include file="footer.html"%>	
	
</body>
</html>
