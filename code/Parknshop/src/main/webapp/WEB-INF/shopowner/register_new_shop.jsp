<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Register Shop Page</title>
     <link rel="stylesheet" type="text/css" href="css_shop/style.css">
     <link rel="stylesheet" type="text/css" href="css_shop/photobox.css">  
     <link rel="stylesheet" type="text/css" href="css/style.css">
     <link rel="stylesheet" type="text/css" href="css/customer.css">
</head>

<body>

    <%@ include file="header.html"%>
	<div class="register-container">
		<div class="page-title">
		    <span class="back-btn button"><a href="myshop"></a></span>
		    <span class="parknshop">PARKnSHOP</span>
		    <span class="main-title">Register Shop</span>
		</div>
		<div class="register-area">
			<div class="login-form">
				<form class="form-horizontal" action="registernewshop" method="post" name="formen" enctype="multipart/form-data">
					<div class="control-group">
						<label class="control-label">SHOP NAME</label>
						<div class="controls">
							<input id="input1" type="text" name="name" value="${ param.name }" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">SHOP　TYPE</label>
						<div class="controls">
							 <input type="radio" id="person" checked="checked" name="type" value="person">
							<label name="person" class="checked" for="person">person</label>
							<input type="radio" id="company" name="type" value="company">
							<label name="company" for="company">company</label>
						</div>
					</div>
					
					<div class="control-group">
						<div class="control-label">SHOP PHOTO</div>
						<div class="controls">
						 
							 <input type="file" name="file" id="file" style="display:none" onChange="document.formen.path.value=this.value"> 
							 <input name="path" readonly> 
							 <input type="button" value="Browse" onclick="document.formen.file.click()">  
					    </div>
				    </div>	
				
					<div class="control-group">
						<label class="control-label">SHOP ADDRESS</label>
						<div class="controls">
							<input id="input1" type="text" name="address" value="${ param.address }" />
						</div>
					</div>
					
					<div class="control-group">
						<div class="controls">
							<br />
							<button type="submit" class="btn-warning">submit</button>
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
	</div>
	<%@ include file="footer.html"%>
	
</body>
</html>
