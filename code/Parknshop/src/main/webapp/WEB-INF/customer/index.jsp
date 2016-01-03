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
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@ include file="header.html"%>
	<c:if test="${ not empty s_user }">
		<%@ include file="dialog.html"%>
	</c:if>
	
	<div class="row-fluid">
		<div class="span3" align="center">
			<h2>
			Product Type
			</h2>
			<ul>
			
				<c:forEach var="category" items="${ r_categories }">
					<li>
					
						<a href="#">${ category }</a>
					
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="span9">
			<div class="row-fluid">
				<div class="span12">
					<h3>
						Top 10 Products
					</h3>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span2">
					<img src = "1.jpg">
					<h4>1</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>2</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>3</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>4</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>5</h4>
				</div>
				<div class="span2">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span2">
					<img src = "1.jpg">
					<h4>6</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>7</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>8</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>9</h4>
				</div>
				<div class="span2">
					<img src = "1.jpg">
					<h4>10</h4>
				</div>
				<div class="span2">
				</div>
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