<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.seller.vo.*"%>
<%@ page import="com.seller.dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
   Shopinfo si=new Shopinfo();
   si=(Shopinfo)request.getAttribute("shopinfo");
   session.setAttribute("shopinfo",si);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The seller Center</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="../seller/admin_top.jsp" noresize="noresize"
		frameborder="NO" name="topFrame" scrolling="no" marginwidth="0"
		marginheight="0" target="main" />
	<frameset cols="200,*" rows="560,*" id="frame">
		<frame src="../seller/left.jsp" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="no"
			target="main" />
		<frame src="../seller/right.jsp" name="main" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="auto" target="_self" />
	</frameset>
</frameset>
<noframes>
	<body></body>
</noframes>
</html>
