<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Shop Order</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>
<body>
    <%@ include file="header2.html"%>
    <div class="shops-orders-container">
		<div id="order-list">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Orders List & Incomes</span>
			</div>
		    <div class="order-form">
				<div>
					shop name
					<select name="shopId">
						<option value="-1">ALL</option>
						<c:forEach var="shop" items="${shopList}">
							<option value="${shop.shopId }">${shop.name }</option>
						</c:forEach>
					</select>
					from
					<input type="date" name="start">
					to
					<input type="date" name="end">	
				</div>
			</div>
			<c:if test="${num==0 }">
			no order
			</c:if>
			<c:forEach var="order" items="${orderList}" >
				<div class="order-item">
		            <div class="brief-info">
		                <div class="order-id">
		                    <span class="name">order id:</span>
		                    <span class="value">${order.orderId}</span>
		                </div>
		                <div class="order-ctime">
		                    <span class="value">${order.orderTime }</span>
		                </div>
		                <!-- <div class="delete-btn button"></div> -->
		            </div>
		            <c:forEach  var="orderInfo" items="${order.orderInfos}">
		            <div class="shop-item">
		                <div class="pic-container">
		                    <a href="" target="_blank">
		                        <div class="over">
		                            <div class="link-btn" style="background-image: url(./images/link-btn.png);"></div>
		                        </div>
		                    </a>
		                <div class="shop" style="background-image: url(${orderInfo.product.picture });"></div>
		                </div>
		                <div class="shopId">
		                    <p class="value" title="${orderInfo.product.shopId }">${orderInfo.product.shopId }</p>
		                    <p class="name">id</p>
		                </div>
		                <div class="productName">
		                    <p class="value" title="${orderInfo.product.shopId }">${orderInfo.product.name }</p>
		                    <p class="name">name</p>
		                </div>
		                <div class="origin-price">
		                	<p class="origin">
                                <s title="$${orderInfo.product.price }">$${orderInfo.product.price }</s>
                            </p>
		                    <p class="current" title="$${orderInfo.product.discountPrice }">$${orderInfo.product.discountPrice }</p>
		                </div>
		                <div class="quantity">
		                    <p class="value">${orderInfo.quantity }</p>
		                    <p class="name">quantity</p>
		                </div>
		                <div class="price">
		                    <p class="shop-price">
		                        $${orderInfo.quantity * orderInfo.product.discountPrice + orderInfo.delivery.price}
		                    </p>
		                    <p class="delivery-price">delivery price: ${orderInfo.delivery.price}</p>
		                </div>
		                <div class="info">
		                    <div class="delivery-status">
		                        <p class="value">${orderInfo.status}</p>
		                        <p class="name">status</p>
		                    </div>
		                </div>
		                
		            </div>
		            </c:forEach>
		            <div class="handle-btn button"><a href="modifyorder?orderId=${order.orderId}">Send</a></div>
		        </div>	
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		shopOwner.initManage();
		shopOwner.initOrderList();
	</script>
	<%@ include file="footer.html"%>	
</body>
</html>
