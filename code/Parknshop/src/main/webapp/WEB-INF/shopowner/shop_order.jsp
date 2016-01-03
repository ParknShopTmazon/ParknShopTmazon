<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Shop Order</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/order.css">
</head>
<body>
    <%@ include file="header.html"%>
    
    <hr/>
    <div class="container">
	<div id="content">
	    <div class="order-form">
			<div>
			shop Name
			<select>
				<option>ALL</option>
				<option>ShopName1</option>
				<option>ShopName2</option>
				<option>ShopName3</option>
			</select>
			Date:
			<select>
				<option>Near one day</option>
				<option>Near one week</option>
				<option>Near one Month</option>
				<option>Near one year</option>
			</select>
		</div>
		
		<div class="order-form">
			<div class="order-item item-form-head">
				<div class="item-form-head-info"><span>Order Information</span></div>
				<div class="item-form-head-mum"><span>Num</span></div>
				<div class="item-form-head-totalprice"><span>Total</span></div>
				<div class="item-form-head-orderstate"><span>State</span></div>
				<div class="item-form-head-manage"><span>Manage</span></div>
			</div>
		</div>	
		
		
			<c:forEach var="order" items="${orders}" >
				
				<div class="order-item ">
				<div class="item-product-id"><span>Order ID:${order.orderId}</span></div>
				
				
				    
				   <div class="item-product-photo"><img src=></div>  
				    <div class="item-name-time-shop">
					<div class="name"><a href="">productname1</a></div>
					<div class="time"><span>Date:&nbsp;${order.orderTime}</span></div>
					<div class="shop">${order.status}</div>
				    </div>	
<%-- 				    <c:forEach var="orderInfo" items="${order.orderInfos}"> --%>
<%-- 					<div class="item-product-mum"><span>${orderInfo.quantity }</span></div> --%>
<%-- 					</c:forEach> --%>
					<div class="item-product-totalprice"><span>$32</span></div>
					<div class="item-product-orderstate"><span>${order.status}</span></div>
					<div class="item-product-manage dropedlist">
						<ul>
							<li>Manage
								<ul>
									<li>delete</li>
									<li>what</li>
								</ul>
							</li>
						</ul>	
					</div>
				
				
			  </div>
		  </c:forEach>

		
		
		
	</div>
	</div>
	
	<%@ include file="footer.html"%>
</body>
</html>
