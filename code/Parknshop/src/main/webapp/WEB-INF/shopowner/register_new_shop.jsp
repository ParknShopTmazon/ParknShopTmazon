<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
     <link rel="stylesheet" type="text/css" href="css_shop/style.css">
     <link rel="stylesheet" type="text/css" href="css_shop/photobox.css">
</head>
<body>
    <%@ include file="header.html"%>

	<div id="container">
		<div id="shopinfo">
			<h2>&nbsp;&nbsp;Please Register</h2>
			
			<form class="complete-info" id="form1" action="registernewshop" method="post">
				
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Shop Name:</div>
					<div class="form-control-right">
						<input class="form-input" id="name" name="name" type="text" value="${param.name}" maxlength="20" business="trueName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Shop Type:</div>
					<div class="form-control-right">
						<input class="form-input" id="type" name="type" type="text" value="${param.type}" maxlength="18" business="id_number" require="true";>
					</div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Address:</div>
					<div class="form-control-right">
						<input class="form-input" id="address" name="address" type="text" value="${param.address}" maxlength="18" business="address" require="true";>
					</div>
				</div>	
				
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						
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
	<div id="footer">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
	</div>
</body>
</html>
