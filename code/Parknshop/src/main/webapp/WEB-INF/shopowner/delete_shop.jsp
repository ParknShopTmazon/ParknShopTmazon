<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Register Shop Page</title>
     <link rel="stylesheet" type="text/css" href="css_shop/style.css">
     <link rel="stylesheet" type="text/css" href="css_shop/photobox.css">  
</head>

<body>
    <%@ include file="header2.html"%>

	<div id="container">
		<div id="shopinfo">
			<h2>&nbsp;&nbsp;Please Register</h2>
			
			<form class="complete-info" id="form1" name="formen" action="deleteshop" method="post" enctype="multipart/form-data">
				
				<div class="form-item">
				    <div class="form-item">
						<div class="form-lable-left">Shop Id:</div>
						<div class="form-control-right">${shopId}</div>
				    </div>
				</div>
				
				<input type="hidden" name="product_id" value="${shopId }">
				<div class="form-item">
				    <div class="form-item">
						<div class="form-lable-left">Shop Name:</div>
						<div class="form-control-right">${name}</div>
				    </div>
				</div>
				<div class="form-item">
				    <div class="form-lable-left">Shop Type:</div>
					<div class="form-control-right">${type}</div>
				</div>
				<div class="form-item-photo">
					<div class="form-lable-left">Shop Photo</div>
					 <div class="form-shop-img">
						<img alt="no photo" src="${picture}" width="100" height="80">
				  </div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="delete" class="submit-btn" >
						<button  name="cancel" type="button" onclick="window.open('myshop')" class="submit-btn">cancel</button>
					</div>
				</div>	
			</form>
	   </div>
	</div>
	<%@ include file="footer.html"%>
	
</body>
</html>
