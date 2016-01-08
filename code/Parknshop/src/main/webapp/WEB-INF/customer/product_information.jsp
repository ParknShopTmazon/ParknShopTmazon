<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>product information</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">
<link rel="stylesheet" type="text/css" href="css/jquery.jqzoom.css">
</head>
<body>
	<%@ include file="header.html"%>
	<c:if test="${ not empty s_user }">
		<%@ include file="dialog.html"%>
	</c:if>
	<div class="product-container">
		<div class="page-title">
		    <span class="back-btn button"></span>
		    <span class="parknshop">PARKnSHOP</span>
		    <span class="main-title">Products Info</span>
		</div>
		<div class="product-area">
			<div class="img-area">
				<a href="${ product.picture }" class="jqzoom" rel='gal1'  title="triumph" >
		            <img src="${ product.picture }" class="product-picture">
		        </a>
			</div>
			<div class="product-info">
				<div class="main">Introduction of products</div>
				<div class="infos">
					<div class="info-items">
						<div class="name product-name">${ product.name }</div>
					</div>
					<div class="info-items">
						<span class="name">Shop Owner</span>
						<span class="value">
							${ shopOwnerName }
							<span class="line">
								<c:choose>
									<c:when test="${ ownerOnline }">
										[online]
									</c:when>
									<c:otherwise>
										[offline]
									</c:otherwise>
								</c:choose>
							</span>
						</span>
					</div>
					<div class="info-items">
						<span class="name">Original Price</span>
						<span class="value"><s>$${ product.price }</s></span>
					</div>
					<div class="info-items">
						<span class="name">Price</span>
						<span class="value">$${ product.discountPrice }</span>
					</div>
					<div class="info-items">
						<span class="name">Sales Volume</span>
						<span class="value">${ product.soldNum }</span>
					</div>
					<div class="info-items">
						<span class="name">Remaining</span>
						<span class="value">${ product.stockNum }</span>
					</div>
				</div>
				<div class="main">Buy</div>
				<c:if test="${ isLogin }">
					<c:if test="${ not expired }">
						<form>
							<input type="hidden" name="pid" value="${ product.productId }" />
							<c:if test="${ not isExists }">
								<div class="info-items">
									<span class="name">Quantity</span>
									<span class="value"><input name="quantity" type="number" id="add-to-cart" min="1" max_quantity="${ product.stockNum }" value="1"/></span>
								</div>
								<c:if test="${ s_user.role ne 'admin' and s_user.name ne shopOwnerName }">
									<button class="btn-warning">Add to cart</button>
								</c:if>
								<c:if test="${ s_user.name eq shopOwnerName }">
									<button class="btn-warning btn-disabled">Your products</button>
								</c:if>
								<c:if test="${ s_user.role eq 'admin' }">
									<button class="btn-warning btn-disabled" disabled>Admin</button>
								</c:if>
							</c:if>
							<c:if test="${ isExists }">
								<button class="btn-warning btn-disabled" disabled>Already in cart</button>
							</c:if>
						</form>
					</c:if>
					<c:if test="${ expired }">
						<button class="btn-warning btn-disabled" disabled>Expired</button>
					</c:if>
				</c:if>
				<c:if test="${ not isLogin }">
					<a href="/Parknshop/login"><button class="btn-warning">Login</button></a>
				</c:if>	
			</div>
			<div class="main">Product introduction</div>
			<div class="description">${ product.description }</div>
			<div class="main">Product Comments
				<span>
					<span class="averageName">Average</span>	
					<span class="averageValue"></span>
				</span>
			</div>
			<div class="comments">
				<c:forEach var="comment" items="${ comments }">
					<div class="pan"></div>
					<div class="comment-items">
						<div>
							<p class="value">${ comment.userId }</p>
							<p class="name">${ comment.userName }</p>
						</div>
						<div class="comment-part">
							<p class="value">shop: <span>${ comment.shopScore }</span></p>
							<p class="value">product: <span>${ comment.productScore }</span></p>
							<p class="value">delivery: <span>${ comment.deliveryScore }</span></p>
							<p class="name">${ comment.content }</p>
						</div>
					</div>
				</c:forEach>
			</div>	
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.jqzoom-core.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			customer.init();
			customer.initProductInfo();
		});
	</script>
</body>
