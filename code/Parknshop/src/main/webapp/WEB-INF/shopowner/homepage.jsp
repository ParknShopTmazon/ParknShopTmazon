<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My Home Page' starting page</title>
    
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
    <div id="head">
		<div id="head-up">
			<div class="logo"><a href=""><img id="logo" src="images_shop/logo.jpg"></a></div>
		</div>
		<div id="head-bottom">
			<form action="/s/" class="search" name="searchForm" method="get">
            	<input tabindex="1" type="text" name="w" autocomplete="off"  value="" placeholder="please input the good's name">
                <input type="submit" class="" hidefocus="true" value="search"  data-mod="sr">
    		</form>
		</div>		
	</div>
	<div id="menu">
    <dl class="side-nav-list">
        <dd class="home"><a href=""><strong>My Home</strong></a></dd>
        <dt class="head-item"><strong>My Shop</strong></dt>
        <dd>
            <ul class="item-list">
                <li ><a href="add products.jsp">add products</a></li>
                <li ><a href="modify product.jsp">modify products</a></li>
                <li ><a href="modify product.jsp">delete products</a></li>
            </ul>
        </dd>
        <dt class="head-item" ><strong>My Order</strong></dt>
        <dd>
             <ul class="item-list" >
                <li ><a href="">waiting for evaluating</a></li>
                <li ><a href="">evaluated</a></li>
            </ul>
        </dd>
    </dl>
	</div>
	<div id="content">
	</div>
	<div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
	</div>

  </body>
</html>
