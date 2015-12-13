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

$(document).ready(function() {
	
});

</script>

<link rel="stylesheet" type="text/css" media="all"
	href="css/jquery.dualSlider.0.2.css" />

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
					<li><a href="AboutUsServlet">About</a></li>
					<li><a href="FaqsServlet" class="selected">FAQs</a></li>
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
			<div id="content" class="faq float_r">
				<h2>FAQs</h2>
				<h3>How will I know you received my order?</h3>
				<p>You'll receive an email confirming that your order has been
					received. If you do not receive an email confirmation, please check
					to see if the email address on your order was entered correctly.</p>

				<h3>When will my order be shipped?</h3>
				<p>Please read our shipping policy. Click</p>

				<h3>What payment methods do you accept?</h3>
				<p>PayPal and 2Checkout (2CO)</p>

				<h3>Can I return or exchange my purchase if I don't like it?</h3>
				<p>Please read our exchange policy. Click</p>

				<h3>How do I know if online ordering is secure?</h3>
				<p>Protecting your information is a priority for Glory Silver.
					We use Secure Sockets Layer (SSL) to encrypt your credit card
					number, name and address so only Glory Silver is able to decode
					your information. SSL is the industry standard method for computers
					to communicate securely without risk of data interception,
					manipulation or recipient impersonation. To be sure your connection
					is secure; when you are in the Shopping Cart, look at the lower
					corner of your browser window. If you see an unbroken key or closed
					lock, the SSL is active and your information is secure. Since most
					of the customers are still uncomfortable with providing your credit
					card online, we use PayPal and 2CheckOut services so they don't
					need to give out credit card information.</p>

				<h3>What is your privacy policy?</h3>
				<p>Glory Silver respects your privacy and wants to ensure that
					you understand what information we need to complete your order, and
					what information you can choose to share with us and with our
					marketing partners. For complete information on our privacy policy,
					please visit our mainpage.</p>
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