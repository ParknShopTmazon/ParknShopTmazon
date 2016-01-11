<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="text/html UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
<title>parknshop</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
</head>
<body>
	<%@ include file="header.html"%>
	<c:if test="${ not empty s_user and s_user.role ne 'admin'}">
		<%@ include file="dialog.html"%>
	</c:if>
	<div class="swiper-container">
        <div class="swiper-wrapper">
        	<div class="swiper-slide">
           		<a href="#"><div class="swiper-banner" style="background-image: url(./images/1380961451846.jpg);"></div></a>
           	</div>
           	<div class="swiper-slide">
           		<a href="#"><div class="swiper-banner" style="background-image: url(./images/6630096896932174829.jpg);"></div></a>
           	</div>
	        <c:forEach items="${showAdList }" var="showAd">
	        	<div class="swiper-slide">
            		<a href="productInfo?pid=${showAd.product.productId }"><div class="swiper-banner" style="background-image: url(${showAd.ad.picture});"></div></a>
            	</div>
	        </c:forEach>
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
    </div>

	<div class="index-container">
		<div class="categories" align="center">
			<h2>Product Type</h2>
			<ul>
				<a href="index"><li>All</li></a>
				<c:forEach var="category" items="${ r_categories }" varStatus="status">
					<a href="index?category=${ status.index }"><li>${ category }</li></a>
				</c:forEach>
			</ul>
			<div class="products-btn"></div>
		</div>
		<div class="shops">
			<div class="page-title">
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Top 10 Products</span>
			    <span class="more"><a href="searchProduct">more</a></span>
			</div>
			<div class="shop-lists">
				<c:if test="${ empty r_products }">no product</c:if>
				<c:forEach var="product" varStatus="status" begin="0" end="4"
					items="${ r_products }">
					<div class="pic-container">
					    <a href="productInfo?pid=${ product.productId }">
					        <div class="over">
					            <div class="link-btn"></div>
					            <div class="product-name">${ product.name }</div>
					            <div class="product-price">$${ product.discountPrice }</div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ product.picture }');"></div>
					</div>
				</c:forEach>
				<c:forEach var="product" varStatus="status" begin="5" end="9"
						items="${ r_products }">
					
						<div class="pic-container">
						    <a href="productInfo?pid=${ product.productId }" target="_blank">
						        <div class="over">
						            <div class="link-btn"></div>
						            <div class="product-name">${ product.name }</div>
						            <div class="product-price">$ ${ product.price }</div>
						        </div>
						    </a>
						    <div class="shop" style="background-image: url('${ product.picture }');"></div>
						</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/swiper.min.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			customer.init();
			customer.initIndex();
		});
	</script>
</body>
</html>