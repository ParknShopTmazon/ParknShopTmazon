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
						<a href="selectedshop?shopId=${shop.shopId}" title="info">
					        <div class="over before">
					            <div class="link-btn" style="background-image: url(./images/link-btn.png);"></div>
					            <div class="shop-name">${ shop.name }</div>
					            <div class="shop-status">${shop.status}</div>
					        </div>
					    </a>
						<a href="modifyshop?shopId=${shop.shopId}" title="modify">
					        <div class="over success-over after-left">
					            <div class="link-btn" style="background-image: url(./images/configure-btn.png);"></div>
					        </div>
					    </a>
					    <a href="deleteshop?shopId=${shop.shopId}" title="delete">
					        <div class="over before after-right">
					            <div class="link-btn" style="background-image: url(./images/delete-btn.png);"></div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ shop.picture }');"></div>
					</c:if>
					
					<c:if test="${shop.status=='checking'}">
						<a href="myshop" title="refresh">
					        <div class="over">
					            <div class="link-btn" style="background-image: url(./images/refresh-btn.png);"></div>
					            <div class="shop-name">${ shop.name }</div>
					            <div class="shop-status">${shop.status}</div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ shop.picture }');"></div>
					</c:if>
					
					<c:if test="${shop.status=='fail'}">
						<a href="modifyshop?shopId=${shop.shopId}" title="modify">
					        <div class="over before">
					            <div class="link-btn" style="background-image: url(./images/configure-btn.png);"></div>
					            <div class="shop-name">${ shop.name }</div>
					            <div class="shop-status">${shop.status}</div>
					        </div>
					    </a>
					    <a href="deleteshop?shopId=${shop.shopId}" title="delete">
					        <div class="over before after">
					            <div class="link-btn" style="background-image: url(./images/delete-btn.png);"></div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ shop.picture }');"></div>
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
