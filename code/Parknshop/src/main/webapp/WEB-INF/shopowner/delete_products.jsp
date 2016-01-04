<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html >
<head>
<title>add product</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/photobox.css">
</head>
<body>
	<%@ include file="header.html"%>
	<div class="content">
		<div class="height2px color5"></div>
		<div class="manage-nav">
			<div class="unit" id="ProductList" onClick="window.open('selectedshop')"><span>ProductList</span></div>
			<div class="unit" id="AddProduct" onClick="window.open('addproduct')"><span>Add Product</span></div>
			<div class="unit" id="ModifyProduct" onClick="window.open('modifyproduct')"><span>Modify Product</span></div>
			<div class="unit selected" id="DeleteProduct" onClick="window.open('deleteproduct')"><span>Delete Product</span></div>
			<div class="fillspace"></div>
		</div>
		<br>
		<br>
		<div id="container" align="right">
			<form class="complete-info" action="deleteproduct" method="post" >
				
				<input type="hidden" name="product_id" value="${product_id }">
				<div class="form-item-photo">
					<div class="form-lable-left">Product Photo</div>
					 <div class="form-shop-img">
						<img alt="no photo" src="${image}" width="100" height="80">
				  </div>
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
					<div class="form-control-right">${price}</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Discount Price</div>
					<div class="form-control-right">${discount_price}</div>
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
						<input type="submit" value="delete" class="submit-btn" >
						<button name="cancel" onclick="window.open('selectedshop')" class="submit-btn">cancel</button>
					</div>
				</div>			
			</form>
	   </div>
	</div>
	
	   <%@ include file="footer.html"%>	
</body>
</html>
