
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
	<c:forEach items="${product}" var="p">
		<table class="STYLE3" align="center" width="50%">
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductID:</td>
				<td align="center" width="80%" class="left_bt2">${p.productId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductName:</td>
				<td align="center" width="80%" class="left_bt2">${p.productName}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductTypeID:
				</td>
				<td align="center" width="80%" class="left_bt2">${p.productTypeId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductType:</td>
				<td align="center" width="80%" class="left_bt2">${p.productType}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductDesription:
				</td>
				<td align="center" width="80%" class="left_bt2">${p.productDescription}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProductDetail:
				</td>
				<td align="center" width="80%" class="left_bt2">${p.productDetail}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Price:</td>
				<td align="center" width="80%" class="left_bt2">${p.price}</td>
			</tr>

		</table>
	</c:forEach>

</body>
