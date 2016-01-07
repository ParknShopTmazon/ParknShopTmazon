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
	<div class="produts-list-container">
		<div id="shoplist">
			<div class="page-title">
				<span class="back-btn button"></span>
			    <span class="parknshop">PARKnSHOP</span>
			    <span class="main-title">Products List</span>
			</div>

			<c:forEach var="product" items="${product_list}" >
				<div class="shopbox">				
					<a href="./productInfo?pid=${ product.productId }" class="shopphoto"><img src="${ product.picture }"  class="shop-img-box" alt="no p no t"></a>
					<div><a class="shopname" href=""><span id="">${ product.name }</span></a></div>
					<div>${product.price}</div>
					<a href="modifyproduct?product_id=${product.productId}">modify</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="deleteproduct?product_id=${product.productId}">delete</a>
				</div>
			</c:forEach>
			<a href="addproduct">
				<div class="shopbox add-box"></div>
			</a>
	   </div>
	</div>
	<%@include file="footer.html" %>
	<script type="text/javascript">
		shopOwner.initManage();
		shopOwner.initProductList();
	</script>
</body>
</html>
