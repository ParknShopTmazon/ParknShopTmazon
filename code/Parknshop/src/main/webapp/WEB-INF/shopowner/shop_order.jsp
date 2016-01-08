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
					<select>
						<option>ALL</option>
						<option>ShopName1</option>
						<option>ShopName2</option>
						<option>ShopName3</option>
					</select>
					from
					<input type="date" name="start">
					to
					<input type="date" name="end">	
				</div>
			</div>

			<c:forEach var="orderInfo" items="${orderInfoList}" >
				<div class="order-item">
		            <div class="brief-info">
		                <div class="order-id">
		                    <span class="name">order id:</span>
		                    <span class="value">${orderInfo.orderId}</span>
		                </div>
		                <div class="order-ctime">
		                    <span class="value">${orderInfo.order.orderTime }</span>
		                </div>
		                <!-- <div class="delete-btn button"></div> -->
		            </div>
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
		                <div class="handle-btn button"><a href="modifyorder?orderId=${orderInfo.orderId}">Send</a></div>
		            </div>
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
