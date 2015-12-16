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
				class="left_bt2">CommentID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">OrderID</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">Time</td>
			<td align="center" background="images/news-title-bg.gif" width="5%"
				class="left_bt2">Level</td>
			<td align="center" background="images/news-title-bg.gif" width="10%"
				class="left_bt2">Status</td>
			<td align="center" background="images/news-title-bg.gif" width="55%"
				class="left_bt2">Comment</td>
		</tr>

		<c:forEach items="${comment}" var="c">
			<tr>
				<td align="center" width="10%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.commentId}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.userorder}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.time}</a></td>
				<td align="center" width="5%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.level}</a></td>
				<td align="center" width="10%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.status1}</a></td>
				<td align="center" width="55%" class="left_bt2"><a
					href="AdminCommentServlet?id=${c.commentId}" target="main">${c.comment}</a></td>
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