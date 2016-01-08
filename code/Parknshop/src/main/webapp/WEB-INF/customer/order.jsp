<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="text/html UTF-8">
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache, must-revalidate"> 
	<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
	<title>parknshop-order</title>
	<link rel="stylesheet" type="text/css" href="./css/customer.css">
</head>
<body>
	<%@ include file="header.html"%>
	<%@ include file="dialog.html"%>
	<div class="order-container">
		<% 	String order_id = request.getParameter("oid");
			String type = request.getParameter("type");
			String page_num = request.getParameter("page"); %>
		<%	if (order_id != null && !order_id.equals("") && type != null && type.equals("show")) {%>
				<%@ include file="order_show.html"%>
				<% String item = request.getParameter("item"); %>
				<input type="hidden" id="item_num" value="<%=item%>">
				<input type="hidden" id="oid" value="<%=order_id%>">
		<%	} %>
		<%	if (order_id != null && !order_id.equals("") && type != null && type.equals("comment")) {%>
				<% String productId = request.getParameter("productId"); %>
				<% String item = request.getParameter("item"); %>
				<% if (productId != null && !productId.equals("")) {%>
					<%@ include file="order_comment.html"%>
					<input type="hidden" id="item_num" value="<%=item%>">
					<input type="hidden" id="productId" value="<%=productId%>">
					<input type="hidden" id="oid" value="<%=order_id%>">
				<%}%>
		<%	} %>
		<%	if (order_id != null && !order_id.equals("") && type != null && type.equals("pay")) {%>
				<%@ include file="order_pay.html"%>
				<% String productId = request.getParameter("productId"); %>
				<input type="hidden" id="productId" value="<%=productId%>">
				<input type="hidden" id="oid" value="<%=order_id%>">
		<%	} %>
		<%	if (order_id != null && !order_id.equals("") && type != null && type.equals("deal")) {%>
				<% String productId = request.getParameter("productId"); %>
				<% if (productId != null && !productId.equals("")) {%>
					<%@ include file="order_deal.html"%>
					<input type="hidden" id="productId" value="<%=productId%>">
					<input type="hidden" id="oid" value="<%=order_id%>">
				<%}%>
		<%	} %>
		<%	if (type != null && type.equals("certain")) {%>
				<%@ include file="order_certain.html"%>
		<%	} %>
		<%	if (type != null && type.equals("list")) {%>
				<%@ include file="order_list.html"%>
		<%	} %>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>