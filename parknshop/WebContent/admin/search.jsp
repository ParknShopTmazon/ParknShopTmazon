<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="images/skin.css" rel="stylesheet" type="text/css" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

a:link {
	text-decoration: underline;
}
-->
</style>
</head>
<body>
	<table class="line_table" width="100%">
		<tr>
			<td align="center" background="images/news-title-bg.gif" width="30%"
				class="left_bt2">Type</td>
			<td align="center" background="images/news-title-bg.gif" width="70%"
				class="left_bt2">Result</td>
		</tr>

		<c:forEach items="${result}" var="c">
			<tr>
				<td align="center" width="30%" class="left_bt2"><a
					href="SearchServlet?t=${c.t}&id=${c.idstring}" target="main">${c.type}</a></td>
				<td align="center" width="70%" class="left_bt2"><a
					href="SearchServlet?t=${c.t}&id=${c.idstring}" target="main">${c.idstring}</a></td>

			</tr>
		</c:forEach>
	</table>
	<table width="100%">
		<tr align="center">
			<td class="left_bt2">${msg}</td>
		</tr>
	</table>

</body>
</html>