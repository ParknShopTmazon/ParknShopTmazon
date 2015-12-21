<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src='/js/jquery-2.0.3.js'></script>
  </head>
  
  <body>
   <div id=head>
			<img id="logo" src="Images/logo.png">
			<span id="topline">
				<a href="delete.jsp">Home_page|</a>
				<a href="../seller/Update_store_information.html" >Store_information|</a>
				<a href="../seller/Account_setting.html">Accont_setting</a></font>
			</span>
	</div>
    <hr/>
	<div id="menu"></div>
	<div id="container">
		<div id="shopinfo">
			<div id="info-photo">
			  <img src="Images/aple.jpg" width="120" height="120" alt="not authentized">
			  <!--input type="button" value="RNAuthentication" sytle="font-size:1000px;"-->
		  	</div>
			<form class="complete-info" action="t" method="post">
				<div class="form-item">
					<div class="form-lable-left">Account Name </div>
					<div class="form-control">
						<span class="form-item-info">mr***8@qq.com</span>
						<input type="hidden" id="username" name="username" value="mr***8@qq.com" style="width:250px;">
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">E_Mail/Phone </div>
					<div class="form-control">
						<span class="form-item-info">mr***8@qq.com/152****0040</span>
						<input type="hidden"  name="username" value="mr***8@qq.com" style="width:250px;">
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">True Name</div>
					<div class="form-control">
						<input class="form-input" id="true_name" name="true_name" type="text" maxlength="20" business="trueName" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">ID Number</div>
					<div class="form-control">
						<input class="form-input" id="id_number" name="id_number" type="text" maxlength="18" business="id_number" require="true";>
					</div>
				</div>
				<div class="form-item">
					<div class="form-lable-left">Shop Name</div>
					<div class="form-control">
						<input class="form-input" id="shop_name" name="shop_name" type="text" maxlength="18" business="shop_name" require="true";>
					</div>
				</div>	
				<div class="item-photo form-item">
					<div class="form-lable-left">Shop Photo</div>
					<div class="photo-control form-control">
						<img src="Images/hehe.jpg" alt="no picture,no truth" width="200px"  height="100px">
						<br>
						<input type="submit" value="upload_picture" height="30px" sytle="font-size:1000px;">
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
						<input id="submit" type="submit" value="submit" height="30px" sytle="font-size:1000px;">
					</div>
				</div>			
			</form>
	   </div>
	</div>
	<div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
	</div>
	<script type="text/javascript" src='/js/jquery-2.0.3.js'></script>
	<script type="text/javascript">
	$('#submit').click(function() {
	//	var url = "/apms//findPassword";
	});
	</script>
  </body>
</html>
