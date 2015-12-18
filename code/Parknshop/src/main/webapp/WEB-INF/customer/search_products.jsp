<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>search products</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">

</head>
<body>
<%@ include file="header.html"%>
<div class="container-fluid">
	<br>
	<div class ="span3">
			<form class="form-search">
				<input class="input-medium search-query" type="text" name="name" /> <button type="submit" class="btn-warning">search</button>
			</form>
		</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<h3>All Products</h3>
					<c:if test="${num == 0}">
						<p>not found</p>
					</c:if>
					<c:if test="${num >0}">
						<c:forEach var="product" items="${productList}" >
							<c:if test="${test%4==0 }">
								<div class="row-fluid">
							</c:if>
								<div class="span3">
									<img src="images/temp/1.jpg">
									<h4>${ product.price } dollar</h4>
									<h4>${ product.name }</h4>
								</div>
							<c:if test="${test%4==3 }"></div></c:if>
						</c:forEach>
					</c:if>
			</div>
		</div>
	</div>
	<c:if test="${num <=4 }">
		<div class="row-fluid" id = "foot"  style="position:absolute; bottom:0; left:0">
			<div class="span12">
				<h3>
					Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
				</h3>
			</div>
		</div>			
	</c:if>
	<c:if test="${num >4 }">
		<div class="row-fluid" id = "foot">
			<div class="span12">
				<h3>
					Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
				</h3>
			</div>
		</div>
	</c:if>
</div>
</body>