<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html >
<head>
<title>Add Products</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>
<body>
	<%@ include file="header2.html"%>
	<div class="add-products-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Add Products</span>
			</div>
			<form class="complete-info" action="addproduct" method="post" name="formen" enctype="multipart/form-data">
				<div class="form-item">
					<div class="form-lable-left">Picture</div>
					<div class="form-control-right">
						<input type="file" required name="file" id="file" style="display:none" accept="image/bmp,image/png,image/jpeg" onChange="document.formen.path.value=this.value"> 
						<input class="form-input" required name="path" readonly> 
						<input type="button" value="Browse" onclick="document.formen.file.click()">
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control-right">
						<input class="form-input" required id="product_name" name="product_name" type="text" maxlength="20";>
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
						<input class="form-input" required id="price" name="price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Stock Number</div>
					<div class="form-control-right">
						<input class="form-input" required id="stock_num" name="stock_num" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item-textarea">
					<div class="form-lable-left">description</div>
					<div class="form-textarea" >
						<textarea class="textarea" required name="description"></textarea>
						<input type="submit" value="submit" class="submit-btn" >
					</div>
				</div>		
			</form>
	   </div>
	</div>
	<script type="text/javascript">
		shopOwner.initManage();
		shopOwner.initAddProducts();
	</script>
	<%@ include file="footer.html"%>
</body>
</html>
