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
			<div class="unit" id="ProductList" onClick="window.open('productlist')"><span>ProductList</span></div>
			<div class="unit selected" id="AddProduct" onClick="window.open('addproduct')"><span>Add Product</span></div>
			<div class="unit" id="ModifyProduct" onClick="window.open('modifyproduct')"><span>Modify Product</span></div>
			<div class="unit" id="DeleteProduct" onClick="window.open('deleteproduct')"><span>Delete Product</span></div>
			<div class="fillspace"></div>
		</div>
		<br>
		<br>
		<img alt="tu" src="${img}">
		<form action="addpicture" method="post" enctype="multipart/form-data">
			<input type="file" name="file" size="50" accept="image/bmp,image/png,image/jpeg"/>
			<br />
			<input type="submit" value="uploadpicture" />
		</form>		
	</div>
	
	   <%@ include file="footer.html"%>	
</body>
</html>
