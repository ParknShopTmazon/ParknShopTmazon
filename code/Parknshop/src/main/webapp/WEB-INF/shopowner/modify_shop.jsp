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
			<h2>&nbsp;&nbsp;Please Modify</h2>
			
			<form class="complete-info" id="form1" name="formen" action="modifyshop" method="post" enctype="multipart/form-data">
				<input type="hidden" name="product_id" value="${shopId }">
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Shop Name:</div>
					<div class="form-control-right">
						<input class="form-input" id="shop_name" name="name" type="text" value="${name}" maxlength="20" business="trueName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Shop Type:</div>
					<div class="form-control-right">
					    <input type="radio" id="person" checked="checked" name="type" value="person">
						<label name="person" class="checked" for="person">person</label>
						<input type="radio" id="company" name="type" value="company">
						<label name="company" for="company">company</label>
						
					</div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Address:</div>
					<div class="form-control-right">
						<input class="form-input" id="address" name="address" type="text" value="${param.address}" maxlength="18" business="address" require="true";>
					</div>
				</div>	
				
				<div class="form-item-photo">
					<div class="form-lable-left">Shop Photo</div>
					 <div class="form-shop-img">
						<img alt="no photo" src="${picture}" width="100" height="80">
				  </div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Upload Photo</div>
					 <div class="form-control-right">
					 	<input type="file" name="file" id="file" style="display:none" accept="image/bmp,image/png,image/jpeg" onChange="document.formen.path.value=this.value"> 
					 	<input name="path" readonly> 
					 	<input type="button" value="Browse" onclick="document.formen.file.click()"> 
<!-- 					    <input class="form-input-right" id="file" name="file" type="file" accept="image/bmp,image/png,image/jpeg"> -->
				  </div>
				</div>	
				
				<div class="form-item-textarea">
					<div class="form-lable-left">Description:</div>
					<div class="form-textarea">
						<textarea class="textarea"></textarea>
					</div>
				</div>
				
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit" value="next" class="submit-btn" >
					</div>
				</div>		
				<div class="control-group" align="center">
					<c:if test="${ not empty r_error_shop_exists }">
						<label style="color: red;">shop name already exists</label>
					</c:if>
					<c:if test="${ not empty r_is_shop_register_success }">
						<label style="color: red;">register success!please waiting for checking!</label>
					</c:if>
				</div>		
			</form>
	   </div>
	</div>
	<%@ include file="footer.html"%>
	
</body>
</html>
