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
				<div class="span8">
					<h3>All Products</h3>
					<div class="row-fluid">					
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
						<div class="span4">
							<img src="images/temp/1.jpg">
							<h4>$10</h4>
							<h4>lemon</h4>
						</div>
					</div>
				</div>
				<div class="span4">
				<h3>Host products</h3>
					<img src="images/temp/1.jpg"></br>
					<img src="images/temp/1.jpg"></br>
					<img src="images/temp/1.jpg"></br>
					<img src="images/temp/1.jpg"></br>
					<img src="images/temp/1.jpg">	</br>				
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid" id = "foot">
		<div class="span12">
			<h3>
				Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
			</h3>
		</div>
	</div>
</div>
<%@ include file="footer.html"%>
</body>