<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Products</title>
<link rel="stylesheet" type="text/css" href="css_shop/style.css">
<link rel="stylesheet" type="text/css" href="css_shop/photobox.css">
<link rel="stylesheet" type="text/css" href="css_shop/order.css">
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
</head>
<body>
    <%@ include file="header.html"%>
	<div class="content">
		<div class="height2px color5"></div>
		<div class="manage-nav">
			<div class="unit selected" id="ProductList" onClick="getFocus(1)"><span>ProductList</span></div>
			<div class="unit" id="AddProduct" onClick="getFocus(2)"><span>Add Product</span></div>
			<div class="unit" id="ModifyProduct" onClick="getFocus(3)"><span>Modify Product</span></div>
			<div class="unit" id="DeleteProduct" onClick="getFocus(4)"><span>Delete Product</span></div>
			<div class="fillspace"></div>
		</div>
		<div class="productlist">
			<div class="height5px color5" ></div>
			<div class="productbox">
				<div class="product-photo">
				  <input name="" id="product" type="image" class="selected_ok_img" src="images_shop/ok.jpg" onClick=""/>
				  <input name="" type="image" class="product-img-box" onClick="" src="images_shop/product1.jpg" alt="no photo no truth" />
				</div>
				<div class="product-name">
					<a href=""><strong><span >Name:</span></strong><span class="float-right">product1</span></a>
				</div>
				<div class="product-prcie">
					<strong><span id="">Price:</span></strong><span class="float-right font1.4 fontred" >$:27</span>
				</div>
				<div>
				</div>
		    </div>
			<div class="height5px color5" ></div>
			<div class="productbox">
				<div class="product-photo">
				  <input name="" id="product" type="image" class="selected_ok_img" src="images_shop/ok.jpg" onClick=""/>
				  <input name="" type="image" class="product-img-box" onClick="" src="images_shop/product1.jpg" alt="no photo no truth" />
				</div>
				<div class="product-name">
					<a href=""><strong><span >Name:</span></strong><span class="float-right">product1</span></a>
				</div>
				<div class="product-prcie">
					<strong><span id="">Price:</span></strong><span class="float-right font1.4 fontred" >$:27</span>
				</div>
				<div>
				</div>
		    </div>
			<div class="height5px color5" ></div>
			<div class="productbox">
				<div class="product-photo">
				  <input name="" id="product" type="image" class="selected_ok_img" src="images_shop/ok.jpg" onClick=""/>
				  <input name="" type="image" class="product-img-box" onClick="" src="images_shop/product1.jpg" alt="no photo no truth" />
				</div>
				<div class="product-name">
					<a href=""><strong><span >Name:</span></strong><span class="float-right">product1</span></a>
				</div>
				<div class="product-prcie">
					<strong><span id="">Price:</span></strong><span class="float-right font1.4 fontred" >$:27</span>
				</div>
				<div>
				</div>
		    </div>
			<div class="height5px color5" ></div>
			<div class="productbox">
				<div class="product-photo">
				  <input name="" id="product" type="image" class="selected_ok_img" src="images_shop/ok.jpg" onClick=""/>
				  <input name="" type="image" class="product-img-box" onClick="" src="images_shop/product1.jpg" alt="no photo no truth" />
				</div>
				<div class="product-name">
					<a href=""><strong><span >Name:</span></strong><span class="float-right">product1</span></a>
				</div>
				<div class="product-prcie">
					<strong><span id="">Price:</span></strong><span class="float-right font1.4 fontred" >$:27</span>
				</div>
				<div>
				</div>
		    </div>
			<div class="height5px color5" ></div>
			<div class="productbox">
				<div class="product-photo">
				  <input name="" id="product" type="image" class="selected_ok_img" src="images_shop/ok.jpg" onClick=""/>
				  <input name="" type="image" class="product-img-box" onClick="" src="images_shop/product1.jpg" alt="no photo no truth" />
				</div>
				<div class="product-name">
					<a href=""><strong><span >Name:</span></strong><span class="float-right">product1</span></a>
				</div>
				<div class="product-prcie">
					<strong><span id="">Price:</span></strong><span class="float-right font1.4 fontred" >$:27</span>
				</div>
				<div>
				</div>
		    </div>
	   </div>
	</div>
</body>
</html>
