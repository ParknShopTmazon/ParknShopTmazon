<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Register New  Store</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<meta charset="text/html UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
<title>parknshop</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">
</head>
<body>
    <%@ include file="header.html"%>
<!-- 	<div id=head> -->
<!-- 		<img id="logo" src="images_shop/logo.png"> -->
<!-- 		<span id="topline"> -->
<!-- 			<a href="../public/index.html">Home_page|</a> -->
<!-- 			<a href="../seller/Update_store_information.html" >Store_information|</a> -->
<!-- 			<a href="../seller/Account_setting.html">Accont_setting</a></font> -->
<!-- 		</span> -->
<!-- 	</div> -->
    <hr/>
	<div id="menu"></div>
	<div id="container">
		<div id="shopinfo">
			<h2>Please Register</h2>
			
			<form class="complete-info" action="registernewshop" method="post">
				
				<div class="form-item">
					<div class="form-lable-left">Shop Name:</div>
					<div class="form-control">
						<input class="form-input" id="name" name="name" type="text" value="${param.name}" maxlength="20" business="trueName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Shop Type:</div>
					<div class="form-control">
						<input class="form-input" id="type" name="type" type="text" value="${param.type}" maxlength="18" business="id_number" require="true";>
					</div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left">Address:</div>
					<div class="form-control">
						<input class="form-input" id="address" name="address" type="text" value="${param.address}" maxlength="18" business="address" require="true";>
					</div>
				</div>	
				
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control">
						
						<button type="submit" class="btn-warning">submit</button>
					</div>
				</div>	
				<div class="control-group" align="center">
					<c:if test="${ not empty r_error_shop_exists }">
						<label style="color: red;">shop name already exists</label>
					</c:if>
					<c:if test="${ not empty r_is_shop_register_success }">
						<label style="color: red;">register success!please waiting for checking!<a
							href="login" style="color: blue;">click here to log-in</a></label>
					</c:if>
				</div>		
			</form>
	   </div>
	</div>
	<div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
	</div>
</body>
</html>
