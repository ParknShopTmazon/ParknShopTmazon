<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>MyShop Homepage</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>

<body>
	<%@ include file="header2.html"%>
	<div class="shop-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Shops List</span>
			</div>

			<c:forEach var="shop" items="${shopList}" >
				<div class="pic-container">
					<c:if test="${shop.status=='success'}">
						<a href="modifyshop?shopId=${shop.shopId}">
					        <div class="over">
					            <div class="link-btn"></div>
					            <div class="shop-name">Shop Name: ${ shop.name }</div>
					            <div class="shop-status">modify</div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ shop.picture }');"></div>
					</c:if>
					
					<c:if test="${shop.status=='checking'}">
						<a href="modifyshop?shopId=${shop.shopId}">
					        <div class="over">
					            <div class="link-btn"></div>
					            <div class="shop-name">Shop Name: ${ shop.name }</div>
					            <div class="shop-status">modify</div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ shop.picture }');"></div>
					</c:if>
					
					<c:if test="${shop.status=='fail'}">
						<a href=" " class="shopphoto"><img src="${ shop.picture }"  class="shop-img-box" alt="no p no t"></a>
						<div><a class="shopname" href=""><span id="">${ shop.name }</span></a></div>
						<div>${shop.status}</div>
						<a href="deleteshop?shopId=${shop.shopId}">delete</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="modifyshop?shopId=${shop.shopId}">modify</a>
					</c:if>
				    <div class="shop" style="background-image: url('${ product.picture }');"></div>
				</div>
			</c:forEach>
			<a href="registershoppage">
				<div class="shopbox add-box"></div>
			</a>
		</div>
	</div>
	<script type="text/javascript">
		shopOwner.initList();
	</script>
	<%@ include file="footer.html"%>	
</body>
</html>
