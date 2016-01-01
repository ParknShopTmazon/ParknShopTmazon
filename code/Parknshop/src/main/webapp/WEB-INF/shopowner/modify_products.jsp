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
			<div class="unit" id="AddProduct" onClick="window.open('addproduct')"><span>Add Product</span></div>
			<div class="unit selected" id="ModifyProduct" onClick="window.open('modifyproduct')"><span>Modify Product</span></div>
			<div class="unit" id="DeleteProduct" onClick="window.open('deleteproduct')"><span>Delete Product</span></div>
			<div class="fillspace"></div>
		</div>
		<br>
		<br>
		<div id="container" align="right">
			<form class="complete-info" action="modifyproduct" method="post" enctype="multipart/form-data">
				
				<input type="hidden" name="product_id" value="${product_id }">
				<div class="form-item-photo">
					<div class="form-lable-left">Product Photo</div>
					 <div class="form-shop-img">
						<img alt="no photo" src="${image}" width="100" height="80">
				  </div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Upload Photo</div>
					 <div class="form-control-right">
					    <input class="form-input-right" id="file" name="file" type="file" accept="image/bmp,image/png,image/jpeg">
				  </div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control-right">
						<input class="form-input-right" id="product_name" value="${productName}" name="product_name" type="text" maxlength="20" business="productName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Category</div>
					<div class="form-control-right">
						<select name="category" >
							<option value="null"></option>
			   				<option value="TV& Home Theater">TV& Home Theater</option>
			   				<option value="Computers & Tablets" >Computers & Tablets</option>
			   				<option value="Cell Phones" >Cell Phones</option>
			   				<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
			   				<option value="Audio" >Audio</option>
			   				<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
			   				<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
			   				<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
			   				<option value="Home & Office" >Home & Office</option>
						</select>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Price</div>
					<div class="form-control-right">
						<input class="form-input-right" id="price" value="${price}" name="price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Discount Price</div>
					<div class="form-control-right">
						<input class="form-input-right" id="discount_price" value="${discount_price}" name="discount_price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Stock Number</div>
					<div class="form-control-right">
						<input class="form-input-right" id="stock_num" name="stock_num" value="${stockNum}" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item-textarea">
					<div class="form-lable-left">description</div>
					<div class="form-textarea" >
						<textarea class="textarea" name="description" >${description}</textarea>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="next" class="submit-btn" >
					</div>
				</div>			
			</form>
	   </div>
	</div>
	
	   <%@ include file="footer.html"%>	
</body>
</html>
