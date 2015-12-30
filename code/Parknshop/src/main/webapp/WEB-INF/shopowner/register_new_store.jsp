<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en_us">
<head>
<meta http-equiv="content-type" content="text/html"/>
<title>Register New  Store</title>
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
			document.getElementById("check_print").innerHTML="wokao, already exist!";
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
	<div id="container">
			<form class="complete-info" id="form1"action="registe-new store.asp" method="post">
				<div class="form-item">
					<div class="form-lable-left">Account Name </div>
					<div class="form-control-right">
						<span class="form-item-info">Nill</span>
						<input type="hidden" id="username" name="username" value="Nill"  />
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">E_Mail/Phone </div>
					<div class="form-control-right">
						<span class="form-item-info">234@126.com/152****0040</span>
						<input type="hidden"  name="email" value="234@126.com/15200400040"  />
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Shop Name</div>
					<div class="form-control-right">
						<input class="form-input-right" id="shop_name" type="text" maxlength="18" onChange="checkShopName()"/>
						<input type="image" id="checkshopname_img" class="small_ok_img" src="images_shop/ok.jpg" />
						<span id="check_print">support letter num and underline</span>
					</div>
				</div>	
				<div class="form-item">
					<div class="form-lable-left">Shop Type</div>
					<div class="form-control-right">
						<select name="type" class="form-input-right" >
							<option value="MULTIPLE" selected="selected">MULTIPLE</option>
							<option value="OTHERS">OTHERS</option>
						</select>
					</div>
				</div>
					
				<div class="item-photo form-item">
					<div class="form-lable-left">Shop Photo</div>
					<div class="form-shop-img">
					  
					
				      <input name="file" type="file"  id="photo_path" class="inputfile" value="upload_picture"  onSelect="getPhoto()" />
				  </div>
				</div>		  
				<div class="form-item-textarea">
					<div class="form-lable-left">Description</div>
					<div class="form-textarea">
						<textarea class="textarea"></textarea>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control-right">
						<input type="submit"  value="submit"  class="submit-btn">
					</div>
				</div>		
			</form>
	   </div>
</body>
</html>
