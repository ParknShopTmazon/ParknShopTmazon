<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="text/html UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
<title>parknshop</title>
<link rel="stylesheet" type="text/css" href="css/customer.css">

  </head>
  
  <body>
  <%@ include file="header.html"%>
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
	<div id="content" >
	   <h2>In the review,please wait...</h2>
	</div>
	<%@ include file="footer.html"%>

  </body>
</html>
