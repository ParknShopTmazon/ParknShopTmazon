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
	   
	      <c:forEach var="shop" items="${shopList}" >
	          <div class="shopbox">
				<div class="shopphoto" onclick="window.open('selectedshop')"><img src="${ shop.picture }"  class="shop-img-box" alt="no p no t"></div>
				<div><a class="shopname" href=""><span id="">${ shop.name }</span></a></div>
				<div>${shop.status}</div>
		      </div>
	      </c:forEach>
	   
		
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
