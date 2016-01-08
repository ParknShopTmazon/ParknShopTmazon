<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Shop Homepage</title>
<script type="text/javascript">
	var m=1;
	var id="ProductList";
	function getFocus(a){
	if(m!=a)
	{
		
		var classVal = document.getElementById(id).getAttribute("class");
		classVal = classVal.replace("selected","");
		document.getElementById(id).setAttribute("class",classVal );
		if(a==1)
		{
			m=1;
			id="ProductList";
		}
		else if(a==2)
		{
			m=2;
			id="AddProduct";
		}
		else if(a==3)
		{
			m=3;
			id="ModifyProduct";
		}
		else if(a==4)
		{
			m=4;
			id="DeleteProduct";
		}
		classVal = document.getElementById(id).getAttribute("class");
		classVal = classVal.concat(" selected");
		document.getElementById(id).setAttribute("class",classVal );	
	}
}
</script>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
</head>
<body>
    <%@ include file="header2.html"%>
	<div class="products-list-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Products List</span>
			</div>
			<c:forEach var="product" items="${product_list}" >
				<div class="pic-container">	
					<a href="productInfo?pid=${ product.productId }" title="details">
				        <div class="over before">
				            <div class="link-btn" style="background-image: url(./images/link-btn.png);"></div>
				            <div class="shop-name">${ product.name }</div>
				            <div class="shop-status">$${product.price}</div>
				        </div>
				    </a>
					<a href="modifyproduct?product_id=${product.productId}" title="modify">
				        <div class="over success-over after-left">
				            <div class="link-btn" style="background-image: url(./images/configure-btn.png);"></div>
				        </div>
				    </a>
				    <a href="deleteproduct?product_id=${product.productId}" title="delete">
				        <div class="over before after-right">
				            <div class="link-btn" style="background-image: url(./images/delete-btn.png);"></div>
				        </div>
				    </a>
				    <div class="shop" style="background-image: url('${ product.picture }');"></div>
				</div>
			</c:forEach>
			<a href="addproduct">
				<div class="shopbox add-box"></div>
			</a>
	   </div>
	</div>
	<script type="text/javascript">
		shopOwner.initManage();
		shopOwner.initProductList();
	</script>
	<%@include file="footer.html" %>
</body>
</html>
