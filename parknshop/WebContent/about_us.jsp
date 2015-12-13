<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PARKnSHOP</title>

<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link type="text/css" href="css/Logindiv.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" media="all"
	href="css/jquery.dualSlider.0.2.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js"></script>

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

</script>

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>
<script src="js/account.js" type="text/javascript"></script>

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
							<div id="sellbestdiv${list.product_ID}" class="bs_box">
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
				<h1>About Us</h1>
				<h2>History of our online shop</h2>
				<p>1973 in Stanley, Hong Kong opened with a light margin
					supermarket supermarkets and peace consolidation renamed PARKnSHOP</p>
				<ul class="templatemo_list">
					<li>Donec aliquam metus a odio molestie eu consequat.</li>
					<li>Sed a rutrum risus, nam sed ligula et nunc fermentum.</li>
					<li>Maecenas sit amet diam quis sem euismod porttitor.</li>
					<li>Aliquam fermentum cursus risus aliquam erat volutpat.</li>
					<li>Sed fermentum tempus enim, eget iaculis purus imperdiet
						eget.</li>
				</ul>
				<div class="cleaner h20"></div>
				<p></p>
				<div class="cleaner"></div>

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