<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Order Details</title>
    <link rel="stylesheet" type="text/css" href="css_shop/style.css"> 
</head>

<body>
    <%@ include file="header2.html"%>
    <% 	String order_id = request.getParameter("oid"); %>
    <% String item = request.getParameter("item"); %>
    <input type="hidden" value="<%=order_id %>" id="oid">
    <input type="hidden" value="<%=item %>" id="item-number">
    <div class="page-title">
	    <span class="back-btn button"></span>
	    <span class="parknshop">PARKnSHOP</span>
	    <span class="main-title">Order Details</span>
	</div>
	<div class="detail-container">
		<div id="order-info"></div>
	</div>
    <script type="text/javascript">
		shopOwner.initShow($('#oid').val(), $('#item-number').val());
	</script>
	<%@ include file="footer.html"%>	
</body>
</html>
