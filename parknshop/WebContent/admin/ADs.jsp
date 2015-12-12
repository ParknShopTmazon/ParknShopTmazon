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
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">AdvertisementID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ProductID</td>
			<td align="center" background="images/news-title-bg.gif" width="40%"
				class="left_bt2">ImagePath</td>
			<td align="center" background="images/news-title-bg.gif" width="40%"
				class="left_bt2">URL</td>
		</tr>

		<c:forEach items="${ads}" var="c">
			<tr>
				<td align="center" width="10%" class="left_bt2"><a
					href="ADServlet?id=${c.adId}" target="main">${c.adId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ADServlet?id=${c.adId}" target="main">${c.productId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ADServlet?id=${c.adId}" target="main">${c.imagePath}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ADServlet?id=${c.adId}" target="main">${c.URL}</a></td>

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