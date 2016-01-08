<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html >
<head>
<title>add product</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>
<body>
	<%@ include file="header2.html"%>
	<div class="delete-products-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Delete Products</span>
			</div>

			<form class="complete-info" action="deleteproduct" method="post" >
				<input type="hidden" name="product_id" value="${product_id }">
				<div class="form-item-photo">
					<div class="form-lable-left">Product Photo</div>
					<div class="img-container" style="background-image: url(${image});"></div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control-right">${productName}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Category</div>
					<div class="form-control-right">${category}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Price</div>
					<div class="form-control-right">$${price}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Discount Price</div>
					<div class="form-control-right">$${discount_price}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Stock Number</div>
					<div class="form-control-right">${stockNum}</div>
				</div>
				<div class="form-item-textarea">
					<div class="form-lable-left">description</div>
					<div class="form-textarea" >${description}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="delete" class="delete-btn submit-btn button" >
						<button  name="cancel" type="button" onclick="window.location.href='selectedshop';" class="cancel-btn submit-btn button">cancel</button>
					</div>
				</div>			
			</form>
			
	   </div>
	</div>
	<script type="text/javascript">
		shopOwner.initManage();
	</script>
	<%@ include file="footer.html"%>	
</body>
</html>
