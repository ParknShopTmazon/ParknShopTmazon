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
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Seller Name</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Real Name</td>
			<td align="center" background="images/news-title-bg.gif" width="5%"
				class="left_bt2">Sex</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Email</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Phone Number</td>
			<td align="center" background="images/news-title-bg.gif" width="14%"
				class="left_bt2">ID</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Address</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">State</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">RegTime</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Balance</td>
			<td align="center" background="images/news-title-bg.gif" width="9%"
				class="left_bt2">Status</td>

		</tr>

		<c:forEach items="${customer}" var="c">
			<tr>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.customerName}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.realName}</a></td>
				<td align="center" width="5%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.sex}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.email}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.phoneNumber}</a></td>
				<td align="center" width="14%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.identityId}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.address}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.state}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.regTime}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.accountBalence}</a></td>
				<td align="center" width="9%" class="left_bt2"><a
					href="CustomerServlet?id=${c.customerName}" target="main">${c.status1}</a></td>
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