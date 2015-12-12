
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<base href="<%=basePath%>">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<%@ page language="java" contentType="text/html; charset="
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
				class="left_bt2">ProductID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ProductType</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ProductName</td>
			<td align="center" background="images/news-title-bg.gif" width="30%"
				class="left_bt2">ProductDescription</td>
			<td align="center" background="images/news-title-bg.gif" width="30%"
				class="left_bt2">ProcudtDetail</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">Price</td>
		</tr>

		<c:forEach items="${product}" var="c">
			<tr>
				<td align="center" width="10%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productType}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productName}</a></td>
				<td align="center" width="30%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productDescription}</a></td>
				<td align="center" width="30%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.productDetail}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="ProductServlet?id=${c.productId}" target="main">${c.price}</a></td>
			</tr>
		</c:forEach>

		<tr align="center">
			<td></td>
			<td></td>
			<td></td>
			<td align="center" class="left_bt2">${msg}</td>
			<td></td>
			<td></td>
		</tr>

	</table>

</body>
</html>