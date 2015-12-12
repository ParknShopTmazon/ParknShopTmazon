
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
	<c:forEach items="${comment}" var="comment">
		<table class="STYLE3" align="center" width="50%">
			<tr>
				<td align="center" width="20%" class="left_bt2">CommentID:</td>
				<td align="center" width="80%" class="left_bt2">${comment.commentId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">OrderID:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="OrderServlet?id=${comment.userorder}">${comment.userorder}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ProcudtName:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="ProductServlet?id=${comment.productId}">${comment.productName}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Seller:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="CustomerServlet?id=${comment.sellerName}">${comment.sellerName}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Buyer:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="CustomerServlet?id=${comment.buyerName}">${comment.buyerName}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ShopName:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="ShopServlet?id=${comment.shopId}">${comment.shopName}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Time:</td>
				<td align="center" width="80%" class="left_bt2">${comment.time}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Level:</td>
				<td align="center" width="80%" class="left_bt2">${comment.level}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Status:</td>
				<td align="center" width="80%" class="left_bt2">${comment.status1}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Comment:</td>
				<td align="center" width="80%" class="left_bt2">${comment.comment}</td>
			</tr>
			<tr>
				<td></td>
				<td align="center" class="left_bt2"><a
					style="text-decoration: none;"
					href="AdminCommentServlet?operation=1&id=${comment.commentId}"
					target="main"><button>Normalize</button></a> <a
					style="text-decoration: none;"
					href="AdminCommentServlet?operation=2&id=${comment.commentId}"
					target="main"><button>Delete</button></a></td>
			</tr>
		</table>
	</c:forEach>

</body>
