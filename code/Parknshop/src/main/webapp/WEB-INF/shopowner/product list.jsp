<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id=head>
			<img id="logo" src="Images/logo.png">
			<span>
				<a href="../public/index.html">Home_page|</a>
				<a href="../seller/Update_store_information.html" >Store_information|</a>
				<a href="../seller/Account_setting.html">Accont_setting</a></font>
			</span>
	</div>
   
	<div id="container">
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/shop1.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">product name1</span></a></div>
			<div><a href="">more info<a></div>
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/shop2.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">product name2</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/apple.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">red apple</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/banana.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">great banana</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/potato.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">common potato</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/shop6.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">product name6</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/shop7.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">product name7</span></a></div>
			<div>more info</div>	
		</div>
		<div id="shopinfo">
			<div id="shopphoto"><a href=""><img src="Images/shop8.jpg" alt=""></a></div>
			<div><a id="shopname" href=""><span id="">product name8</span></a></div>
			<div>more info</div>	
		</div>
	</div>
	<div id="foot"><span>Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.</span></div>

  </body>
</html>
