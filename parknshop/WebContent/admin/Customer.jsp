<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="images/skin.css" rel="stylesheet" type="text/css" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

	<c:forEach items="${customer}" var="customer">
		<table class="STYLE3" align="center" width="50%">
			<tr>
				<td align="center" width="20%" class="left_bt2">CustomerName:</td>
				<td align="center" width="80%" class="left_bt2">${customer.customerName}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">RealName:</td>
				<td align="center" width="80%" class="left_bt2">${customer.realName}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Sex:</td>
				<td align="center" width="80%" class="left_bt2">${customer.sex}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Email:</td>
				<td align="center" width="80%" class="left_bt2">${customer.email}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">PhoneNumber:</td>
				<td align="center" width="80%" class="left_bt2">${customer.phoneNumber}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">IdentityID:</td>
				<td align="center" width="80%" class="left_bt2">${customer.identityId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Address:</td>
				<td align="center" width="80%" class="left_bt2">${customer.address}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">AccountState:</td>
				<td align="center" width="80%" class="left_bt2">${customer.state}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">RegTime:</td>
				<td align="center" width="80%" class="left_bt2">${customer.regTime}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">AccountBalance:
				</td>
				<td align="center" width="80%" class="left_bt2">${customer.accountBalence}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">State:</td>
				<td align="center" width="80%" class="left_bt2">${customer.status1}</td>
			</tr>
			<tr>
				<td></td>
				<td align="center" class="left_bt2"><a
					style="text-decoration: none;"
					href="CustomerServlet?operation=1&id=${customer.customerName}"
					target="main"><button>BlackList</button></a> <a
					style="text-decoration: none;"
					href="CustomerServlet?operation=2&id=${customer.customerName}"
					target="main"><button>Delete</button></a></td>
			</tr>
		</table>
	</c:forEach>

</body>
