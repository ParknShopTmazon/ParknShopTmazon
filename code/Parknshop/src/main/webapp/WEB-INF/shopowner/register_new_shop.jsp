<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
     <link rel="stylesheet" type="text/css" href="css_shop/style.css">
     <link rel="stylesheet" type="text/css" href="css_shop/photobox.css">
     <script type="text/javascript">
	function checkShopName(){
		var shopname=document.getElementById("shop_name")
		var imgstate=document.getElementById("checkshopname_img");
		var notice=document.getElementById("check_print");
		if(shopname.value=="")
		{
			imgstate.src="images_shop/bad.jpg";
			imgstate.style.display="inline";
			notice.innerHTML="cant be null";
		}
		else if(1)
		{
			imgstate.style.display="inline";
			notice.innerHTML="gongxi keyong";
		}
		else
		{
			document.getElementById("checkshopname_img").src="images_shop/bad.jpg";
			document.getElementById("checkshopname_img").style.display="inline";
			document.getElementById("check_print").innerHTML="already exist!";
		}
	}
	function getPhoto(){
		var path=document.getElementById("photo_path").dir.value;
		alert(path);
		document.getElementById("shop_photo").src=path;
	}
</script>
</head>

<body>
    <%@ include file="header.html"%>

	<div id="container">
		<div id="shopinfo">
			<h2>&nbsp;&nbsp;Please Register</h2>
			
			<form class="complete-info" id="form1" action="registernewshop" method="post">
				
				<div class="form-item">
					<div class="form-lable-left">&nbsp;Shop Name:</div>
					<div class="form-control-right">
						<input class="form-input" id="shop_name" name="name" type="text" value="${param.name}" maxlength="20" business="trueName" require="true";>
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
				
				<div class="item-photo form-item">
					<div class="form-lable-left">Shop Photo:</div>
					<div class="form-shop-img">
					 
					
				      <input name="file" type="file"  id="photo_path" class="inputfile" value="upload_picture"  onSelect="getPhoto()" />
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
						
						<button type="submit" class="btn-warning">submit</button>
					</div>
				</div>	
				<div class="control-group" align="center">
					<c:if test="${ not empty r_error_shop_exists }">
						<label style="color: red;">shop name already exists</label>
					</c:if>
					<c:if test="${ not empty r_is_shop_register_success }">
						<label style="color: red;">register success!please waiting for checking!<a
							href="login" style="color: blue;">click here to log-in</a></label>
					</c:if>
				</div>		
			</form>
	   </div>
	</div>
	<%@ include file="footer.html"%>
	
</body>
</html>
