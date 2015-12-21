<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add products.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css_shop/style.css">

  </head>
  
  <body>
    <div id=head>
			<img id="logo" src="images_shop/logo.png">
			<span id="topline">
				<a href="../public/index.html">Home_page|</a>
				<a href="../seller/Update_store_information.html" >Store_information|</a>
				<a href="../seller/Account_setting.html">Accont_setting</a></font>
			</span>
	</div>
    <br><hr/>
	<div id="menu"> </div>
	<div id="content">
		<div id="info">
			<form class="complete-info" action="add" method="post">
				<div class="item-photo form-item">
					<div class="form-lable-left">Shop Photo</div>
					<div class="photo-control form-control">
						<img src="images_shop/hehe.jpg" alt="" width="200px"  height="100px">
					</div>
				</div>	 
					<div class="form-item">
					<div class="form-lable-left">Shop Name </div>
					<div class="form-control">
						<span class="form-item-info">China MMDian</span>
					</div>
				
				<div class="item-uphoto form-item">
					<div class="form-lable-left">Product Photo</div>
					<div class="uphoto-control form-control">
						<img src="images_shop/tune.jpg" alt=""width=""  height="100px">
						<br>
						<input type="submit" value="upload_picture" height="30px" sytle="font-size:1000px;">
					</div>
				</div>		
				</div>	  
					<div class="form-item">
					<div class="form-lable-left">Product Id</div>
					<div class="form-control">
						<input class="form-input" id="product_id" name="product_id" type="text" maxlength="20" business="productName" require="true";>
					</div>
				</div> 
				<div class="form-item">
					<div class="form-lable-left">Product Name</div>
					<div class="form-control">
						<input class="form-input" id="product_name" name="product_name" type="text" maxlength="20" business="productName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Product Price</div>
					<div class="form-control">
						<input class="form-input" id="price" name="price" type="text" maxlength="18" business="price" require="true";>
					</div>
				</div>
				<div class="item-textarea form-item">
					<div class="form-lable-left">Remark</div>
					<div class="textarea-control form-control">
						<textarea class="text-area"></textarea>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left"></div>
					<div class="form-control">
						<input type="submit" value="submit" height="30px" sytle="font-size:1000px;">
					</div>
				</div>			
			</form>
	   </div>
	</div>
	<div id="foot"><span>Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.<span></div>
  </body>
</html>
