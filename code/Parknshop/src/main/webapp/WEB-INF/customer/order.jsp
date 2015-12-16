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
		<%	} %>
		<%	if (order_id != null && !order_id.equals("") && type != null && type.equals("comment")) {%>
				<%@ include file="order_comment.html"%>
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