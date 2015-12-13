<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PARKnSHOP</title>

<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<style type="text/css">
.btn1 {
	border-bottom-width: thin;
	border-color: #CCC;
	border-style: outset;
	background-color: #FFF;
}

.btn2 {
	border: #FFF;
	border-color: #FFF;
	background-color: #FFF;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script language="javascript" type="text/javascript">
var Ajaxresult=null;

	$(document).ready(function() {
		//判断用户输入非法值 购物车
		$("#buy_left").bind("click", function() {

			var i = Number($("#buycount").val());
			if (i > 1)
				i = i - 1;
			$("#buycount").val(i);
		});
		$("#buy_right").bind("click", function() {
			var i = Number($("#buycount").val());
			i = i + 1;

			$("#buycount").val(i);
		});
		
		$("a[name='addtofavorite']").bind("click", function(){
			if($("#session_customername").val()=="")
				alert("please login");
			else{
				var product_ID=this.id.substring(13,this.id.length);
				addtofavoriteAjax(product_ID);
			}
		});
		
		function addtofavoriteAjax(product_ID){
			Ajaxresult=null;
			$.ajax({
				type: "post",
				url: "AddToFavoriteAjax?product_ID="+product_ID,
				contentType: "application/json; charset=utf-8",
				success: function (data) {
					
					Ajaxresult=eval("("+data+")");
					var result=Ajaxresult.result;
					if(result>=1)
						alert("add to favorite success");
					else
						alert("add to favorite false");
				},    
				error: function (XMLHttpRequest, textStatus, errorThrown) {   
					alert(errorThrown);    
				}    
			});	
		}
		
	});

	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})
  
  

</script>

<link rel="stylesheet" type="text/css" media="all"
	href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>
<script src="js/account.js" type="text/javascript"></script>
<script type="text/javascript" src="js/addtocart.js"></script>

</head>


<body>

	<c:import url="login_head.jsp"></c:import>

	<div class="account">
		<a href="#"> <img src="images/false.jpg" height="20" width="20">
		</a>
		<h2>Account Balance</h2>
		<p>
			<font id="account_name"></font><br>
			<br> Your account balance : <b style="color: red"> $<font
				id="useraccount"></font></b>
		</p>
	</div>


	<div id="templatemo_wrapper">
		<div id="templatemo_header">

			<div id="site_title">
				<h1>
					<a href="IndexServlet">PARKnSHOP</a>
				</h1>
			</div>

			<div id="header_right">
				<a id="userName" href="#">My Home</a> | <a id="accountid" href="#">My
					Account</a> | <a id="head_myfavorite" href="#"> My favorite </a> | <a
					id="head_mycart" href="#" name="movetocart">My Cart</a> | <a
					id="login" href="#">Log In</a>
			</div>

			<div class="cleaner"></div>
		</div>
		<!-- END of templatemo_header -->

		<div id="templatemo_menu">
			<div id="top_nav" class="ddsmoothmenu">
				<ul>
					<li><a href="IndexServlet">Home</a></li>
					<li><a href="NewProductsServlet">Products</a></li>
					<li><a href="AboutUsServlet" class="selected">About</a></li>
					<li><a href="FaqsServlet">FAQs</a></li>
					<li><a id="index_checkout" href="#">Checkout</a></li>
					<li><a id="index_contact" href="#">Contact</a></li>
				</ul>
				<br style="clear: left" />
			</div>
			<!-- end of ddsmoothmenu -->
			<div id="menu_second_bar">
				<div id="top_shopping_cart">
					Shopping Cart: <strong><font id="shopping_cart_count">0</font>
						Products</strong> ( <a href="#" name="movetocart">Show Cart</a> )
				</div>
				<div id="templatemo_search">
					<form action="#" method="get">
						<input type="text" value="Search" name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="button" name="Search" value=" Search " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
				<div class="cleaner"></div>
			</div>
		</div>
		<!-- END of templatemo_menu -->

		<div id="templatemo_main">
			<div id="sidebar" class="float_l">
				<div class="sidebar_box">
					<span class="bottom"></span>
					<h3>Categories</h3>
					<div class="content">
						<ul class="sidebar_list">
							<li class="first"><a
								href="SearchProductByTypeServlet?type=1">dress </a></li>
							<li><a href="SearchProductByTypeServlet?type=2">shoes</a></li>
							<li><a href="SearchProductByTypeServlet?type=3">bags</a></li>
							<li><a href="SearchProductByTypeServlet?type=4">
									underwear</a></li>
							<li><a href="SearchProductByTypeServlet?type=5">outdoor</a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=6">Fitness
									equipment </a></li>
							<li><a href="SearchProductByTypeServlet?type=7">Snacks</a></li>
							<li><a href="SearchProductByTypeServlet?type=8">care </a></li>
							<li><a href="SearchProductByTypeServlet?type=9">alcohol</a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=10">drink </a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=11"> phone</a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=12">Camera</a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=13">Computer</a>
							</li>
							<li><a href="SearchProductByTypeServlet?type=14">Skin
									care </a></li>
						</ul>
					</div>
				</div>
				<div class="sidebar_box">
					<span class="bottom"></span>
					<h3>Best Sellers</h3>
					<div class="content">
						<c:forEach items="${requestScope.sell_best_list}" var="list">
							<div id="div${list.product_ID}" class="bs_box">
								<a href="ProductDetailServlet?product_ID=${list.product_ID}"><img
									src="${list.product_img_url}"
									style="border-width: 2px; height: 55px; width: 70px;" /></a>
								<h4>
									<a href="ProductDetailServlet?product_ID=${list.product_ID}">${list.product_description}</a>
								</h4>
								<p class="price">$${list.product_price}</p>
								<div class="cleaner"></div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div id="content" class="float_r">

				<h1>${requestScope.product_name}</h1>
				<input type="hidden" value="${requestScope.product_id}" />
				<div class="content_half float_l">
					<img src="${requestScope.product_img_url}"
						style="max-height: 200px; max-width: 300px;" />
				</div>
				<div class="content_half float_r">
					<table>
						<tr>
							<td height="30" width="160">Price:</td>
							<td>$${requestScope.product_price}</td>
						</tr>
						<tr>
							<td height="30">Availability:</td>
							<td>${requestScope.product_availability}</td>
						</tr>
						<tr>
							<td height="30">Model:</td>
							<td>${requestScope.product_model}</td>
						</tr>
						<tr>
							<td height="30">Manufacturer:</td>
							<td>${requestScope.product_manufacturer}</td>
						</tr>
						<tr>
							<td height="30">Quantity</td>
							<td><input class="btn2" id="buy_left" type="button"
								value="-" /> <input id="buycount" type="text"
								disabled="disabled" value="1"
								style="width: 20px; text-align: center" /> <input class="btn1"
								id="buy_right" type="button" value="+" /></td>
						</tr>
						<tr>
							<td height="30">Stock</td>
							<td><b style="color: red">100</b> &nbsp;&nbsp;Piece</td>
						</tr>

					</table>
					<div class="cleaner h20"></div>
					<a id="addtocart${requestScope.product_id}" class="add_to_card">Add
						to Cart</a> &nbsp;&nbsp; &nbsp;&nbsp; <a
						id="addtofavorite${requestScope.product_id}" href="#"
						name="addtofavorite">Add to Favourite</a>
				</div>
				<div class="cleaner h30"></div>

				<h5>Product Description</h5>
				<p>${requestScope.product_description}</p>

				<div class="cleaner h50"></div>

				<div id="commentlist">
					<table cellpadding="0" cellspacing="0">
						<tr align="left" bgcolor="#dddddd">
							<th width="100" align="center">commentlist</th>
							<th width="460" align="center"></th>
							<th width="100" align="center"></th>
						</tr>
						<c:forEach items="${requestScope.comment_list}" var="list">
							<tr bgcolor="#eeeeee">
								<td align="center">${list.customername}</td>
								<td align="center">${list.level}</td>
								<td align="center">${list.time}</td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
			<div class="cleaner"></div>
		</div>
		<!-- END of templatemo_main -->

		<div id="templatemo_footer">
			<p>
				<a href="IndexServlet">Home</a> | <a href="NewProductsServlet">Products</a>
				| <a href="AboutUsServlet">About</a> | <a href="FaqsServlet">FAQs</a>
				| <a href="ContactServlet">Contact</a>
			</p>
			Copyright © 2014 &nbsp;&nbsp; <b>PARKnSHOP </b>
		</div>
		<!-- END of templatemo_footer -->

	</div>
	<!-- END of templatemo_wrapper -->



	<div align="center">
		<div id="enddiv" class="logincontent"></div>
	</div>
	<div align="right">
		<div id="angle" style="width: 1px; height: 1px"></div>
	</div>

</body>
</html>