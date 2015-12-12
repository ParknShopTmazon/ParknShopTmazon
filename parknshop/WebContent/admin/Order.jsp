
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<%@ page language="java" contentType="text/html; charset="
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>
<base href="<%=basePath%>">
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
	<br>
	<br>
	<br>
	<c:forEach items="${order}" var="order">
		<table class="STYLE3" align="center" width="50%">
			<tr>
				<td align="center" width="20%" class="left_bt2">OrderID:</td>
				<td align="center" width="80%" class="left_bt2">${order.orderId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ConsigneeInfoID:
				</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="ConsigneeServlet?id=${order.consigneeId}" target="main">${order.consigneeId}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ShopProductID:
				</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="ProductServlet?id=${order.shopProductId}" target="main">${order.shopProductId}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductBuyNum:
				</td>
				<td align="center" width="80%" class="left_bt2">${order.productBuyNum}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">OrderTime:</td>
				<td align="center" width="80%" class="left_bt2">${order.orderTime}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">FinishTime:</td>
				<td align="center" width="80%" class="left_bt2">${order.finishTime}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">CurrentState:</td>
				<td align="center" width="80%" class="left_bt2">${order.state}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">TrackingNum:</td>
				<td align="center" width="80%" class="left_bt2">${order.trackingNum}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">AnythingElse:</td>
				<td align="center" width="80%" class="left_bt2">${order.anythingElse}</td>
			</tr>
		</table>
	</c:forEach>

</body>
