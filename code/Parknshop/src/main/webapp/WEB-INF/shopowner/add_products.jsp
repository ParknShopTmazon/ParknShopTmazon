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
	<%@ include file="header2.html"%>
	<div class="content">
		<div class="height2px color5"></div>
		<div class="manage-nav">
			<div class="unit" id="ProductList" onClick="window.open('selectedshop')"><span>ProductList</span></div>
			<div class="unit selected" id="AddProduct" onClick="window.open('addproduct')"><span>Add Product</span></div>
			<div class="unit" id="ModifyProduct" onClick="window.open('modifyproduct')"><span>Modify Product</span></div>
			<div class="unit" id="DeleteProduct" onClick="window.open('deleteproduct')"><span>Delete Product</span></div>
			<div class="fillspace"></div>
		</div>
		<br>
		<br>
		<div id="container" align="right">
			<form class="complete-info" action="addproduct" method="post" name="formen" enctype="multipart/form-data">
				
				<div class="form-item">
					<div class="form-lable-left">Picture</div>
					<div class="form-control-right">
						<input type="file" name="file" id="file" style="display:none" accept="image/bmp,image/png,image/jpeg" onChange="document.formen.path.value=this.value"> 
						<input name="path" readonly> 
						<input type="button" value="Browse" onclick="document.formen.file.click()">
<!-- 						<input class="form-input-right" id="file" name="file" type="file" accept="image/bmp,image/png,image/jpeg"> -->
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control-right">
						<input class="form-input-right" id="product_name" name="product_name" type="text" maxlength="20";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Category</div>
					<div class="form-control-right">
						<select name="category" >
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
						<input class="form-input-right" id="price" name="price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Stock Number</div>
					<div class="form-control-right">
						<input class="form-input-right" id="stock_num" name="stock_num" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item-textarea">
					<div class="form-lable-left">description</div>
					<div class="form-textarea" >
						<textarea class="textarea" name="description"></textarea>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="submit" class="submit-btn" >
					</div>
				</div>			
			</form>
	   </div>
	</div>
	
	   <%@ include file="footer.html"%>	
</body>
</html>
