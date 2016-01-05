<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>product information</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">
<script text="text/javascript">

</script>
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
		    <span class="main-title">Login</span>
		</div>
		<div class="product-area">
			<div class="product-picture">
				<img src="${ product.picture }">
			</div>
			<div class="product-info">
				<div class="main">Introduction of products</div>
				<div class="infos">
					<div class="info-items">
						<span class="name">Shop Owner</span>
						<span class="value">
							<!-- <a href="#" >${ shopOwnerName }</a> -->
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
			</div>
		</div>
					<c:if test="${ isLogin }">
						<c:if test="${ not expired }">
							<form>
								<fieldset>
									 <input type="hidden" name="pid" value="${ product.productId }" />
									 <c:if test="${ not isExists }">
										 <input name="quantity" type="text" value="1"/> 
										 <span id="quantity" class="help-block">Quantity</span>
										 <button class="btn-warning">Add to cart</button> 	
									</c:if>
									<c:if test="${ isExists }">
										 <span class="help-block">Already in cart</span>
									</c:if>
								</fieldset>
							</form>
						</c:if>
						<c:if test="${ expired }">
							<p><span style="color:red;">Expired</span></p>
						</c:if>
					</c:if>
					<c:if test="${ not isLogin }">
						<a href="/Parknshop/login"><button class="btn-warning">Login</button></a>
					</c:if>
				</div>
	</div>
	<div class="row-fluid">
			<h3>
				Product introduction 
			</h3>
			<p>
				${ product.description }
			</p>
		</div>
	<div class="row-fluid">
			<table class="table">
				<thead>
					<tr>
						<h3>
							Product comments
						</h3>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>					
					</tr>
					<tr>
						<td>
							1
						</td>						
					</tr>
					<tr>
						<td>
							2
						</td>						
					</tr>
					<tr>
						<td>
							3
						</td>					
					</tr>
					<tr>
						<td>
							4
						</td>
					</tr>
				</tbody>
			</table>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			customer.init();
		});
	</script>
</body>
