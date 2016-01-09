<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html >
<head>
<title>Modify Products</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>
<body>
	<%@ include file="header2.html"%>
	<div class="modify-products-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Modify Products</span>
			</div>
			<form class="complete-info" action="modifyproduct" name="formen" method="post" enctype="multipart/form-data">
				
				<input type="hidden" name="product_id" value="${product_id }">
				<div class="form-item-photo">
					<div class="form-lable-left">Product Photo</div>
					<div class="img-container" style="background-image: url(${image});"></div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Upload Photo</div>
					 <div class="form-control-right">
					 	<input type="file" name="file" id="file" style="display:none" accept="image/bmp,image/png,image/jpeg" onChange="document.formen.path.value=this.value"> 
					 	<input class="form-input" name="path" readonly> 
					 	<input type="button" value="Browse" onclick="document.formen.file.click()"> 
<!-- 					    <input class="form-input" id="file" name="file" type="file" accept="image/bmp,image/png,image/jpeg"> -->
				  </div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control-right">
						<input class="form-input" id="product_name" value="${productName}" name="product_name" type="text" maxlength="20" business="productName" require="true";>
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
						<input class="form-input" id="price" value="${price}" name="price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Discount Price</div>
					<div class="form-control-right">
						<input class="form-input" id="discount_price" value="${discount_price}" name="discount_price" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Stock Number</div>
					<div class="form-control-right">
						<input class="form-input" id="stock_num" name="stock_num" value="${stockNum}" type="text" maxlength="18";>
					</div>
				</div>
				<div class="form-item-textarea">
					<div class="form-lable-left">Description</div>
					<div class="form-textarea" >
						<textarea class="textarea" name="description" >${description}</textarea>
						<input type="submit" value="Update" class="submit-btn" >
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
