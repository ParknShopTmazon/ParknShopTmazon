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
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">
</head>
<body>
	<%@ include file="header.html"%>
	<c:if test="${ not empty s_user }">
		<%@ include file="dialog.html"%>
	</c:if>

	<div class="row-fluid">
		<div class="span3" align="center">
			<h2>Product Type</h2>
			<ul>
				<li><a href="index">All</a></li>
				<c:forEach var="category" items="${ r_categories }">
					<li><a href="index?category=${ category }">${ category }</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="span9">
			<div class="row-fluid">
				<div class="span9">
					<h3>Top 10 Products</h3>
				</div>
				<div class="span3">
					<h3><a href="searchProduct">more</a></h3>
				</div>
			</div>
			<div class="row-fluid">
				<c:if test="${ empty r_products }">no product</c:if>
				<c:forEach var="product" varStatus="status" begin="0" end="4"
					items="${ r_products }">
					<div class="span2">
						<a href="productInfo?pid=${ product.productId }" target="_black"><img src="${ product.picture }" ></a>
						<h4>${ product.name }</h4>
					</div>
				</c:forEach>

				<div class="span2"></div>
			</div>
			<div class="row-fluid">
				<c:forEach var="product" varStatus="status" begin="5" end="9"
					items="${ r_products }">
					<div class="span2">
						<a href="productInfo?pid=${ product.productId }" target="_black"><img src="${ product.picture }"></a>
						<h4>${ product.name }</h4>
					</div>
				</c:forEach>

				<div class="span2"></div>
			</div>
		</div>
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
</html>