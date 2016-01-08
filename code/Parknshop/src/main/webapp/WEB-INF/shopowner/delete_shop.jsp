<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Delete Shops</title>
    <link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>

<body>
    <%@ include file="header2.html"%>
	<div class="delete-shop-container">
		<div id="shopinfo">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Delete Shops</span>
			</div>
			
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
					<div class="img-container" style="background-image: url(${picture});"></div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="delete" class="submit-btn delete-btn button" >
						<button  name="cancel" type="button" onclick="window.location.href='myshop';" class="submit-btn cancel-btn button">cancel</button>
					</div>
				</div>	
				
				<div class="control-group" align="center">
						<c:if test="${ not empty r_is_shop_delete_success }">
							<label style="color: red;">you have unfinished orders,can't delete shop!</label>
						</c:if>
				</div>	
			</form>
	   </div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>
