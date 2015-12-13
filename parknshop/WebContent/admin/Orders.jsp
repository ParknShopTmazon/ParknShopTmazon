
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
				class="left_bt2">OrderID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ConsigneeInfoID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ShopProductID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">ProductBuyNum</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">OrderTime</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">FinishTime</td>
			<td align="center" background="images/news-title-bg.gif" width="20%"
				class="left_bt2">AnythingElse</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">TrackingNum</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">CurrentState</td>
		</tr>

		<c:forEach items="${order}" var="c">
			<tr>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.orderId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.consigneeId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.shopProductId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.productBuyNum}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.orderTime}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.finishTime}</a></td>
				<td align="center" width="20%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.anythingElse}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.trackingNum}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="OrderServlet?id=${c.orderId}" target="main">${c.state}</a></td>

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