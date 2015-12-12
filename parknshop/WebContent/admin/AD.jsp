<%@ page language="java" contentType="text/html; charset="
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="images/skin.css" rel="stylesheet" type="text/css" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
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

.STYLE3 {
	font-size: 14px;
	font-weight: bold;
}
-->
</style>
</head>
<body>
	<div align="center">
		<c:forEach items="${ads}" var="c">
			<img src="${c.imagePath}" />
		</c:forEach>
	</div>
	<br>
	<br>
	<br>
	<c:forEach items="${ads}" var="c">
		<table class="STYLE3" align="center" width="50%">
			<tr>
				<td align="center" width="20%" class="left_bt2">AdvertisementID:
				</td>
				<td align="center" width="80%" class="left_bt2">${c.adId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Image:</td>
				<td align="center" width="80%" class="left_bt2">${c.imagePath}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductID:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productId}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">URL:</td>
				<td align="center" width="80%" class="left_bt2">${c.URL}</td>
			</tr>


			<tr>
				<td></td>
				<td align="center" class="left_bt2"><a
					style="text-decoration: none;"
					href="ADServlet?operation=0&id=${c.adId}" target="main"><button>Delete</button></a>
				</td>
			</tr>
		</table>
	</c:forEach>
	<br>
	<br>
	<br>

</body>
