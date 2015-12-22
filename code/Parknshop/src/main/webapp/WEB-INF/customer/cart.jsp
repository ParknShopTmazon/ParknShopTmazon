<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="text/html UTF-8">
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache, must-revalidate"> 
	<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
	<title>parknshop-cart</title>
	<link rel="stylesheet" type="text/css" href="css/customer.css">
</head>
<body>
	<%@ include file="header.html"%>
	<%@ include file="dialog.html"%>
	<div class="cart-container">
		<div class="page-title">
			<span class="back-btn button"></span>
			<span class="parknshop">PARKnSHOP</span>
			<span class="main-title">Cart</span>
		</div>
		<div id="shop-lists">
		</div>
		<div id="shop-cost">
			<div class="main">Cost</div>
			<div class="quantity clear-fix sub-main">
				<span>total quantity</span>
				<span class="value"></span>
			</div>
			<div class="origin clear-fix sub-main">
				<span>origin cost</span>
				<span class="value"><s></s></span>
			</div>
			<div class="cost clear-fix sub-main">
				<span>cost</span>
				<span class="value"></span>
			</div>
			<div class="pay clear-fix sub-main">
				<span class="value button"></span>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    customer.init();
	    customer.initCart();
	});
	</script>
</body>
</html>