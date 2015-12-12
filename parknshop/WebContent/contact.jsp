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

var i = 0;

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

$(document).ready(function() {
	$("input[class='submit_btn float_l']").bind("click",function(){
		i = 0;
		checkrealname();
		checkemail();
		checksubject();
		checktext();
		if(i==0){
			alert("send message success");
			window.location.href="IndexServlet";
		}
	});
	
	$("#author").bind("blur", function() {
		checkrealname();
	});
	$("#email").bind("blur", function() {
		checkemail();
	});
	$("#subject").bind("blur", function() {
		checksubject();
	});
	$("#text").bind("blur", function() {
		checktext();
	});
	
});

function checkrealname() {
	var str = $("#author").val();
	if (str.length == 0) {
		$("#error1").text("input is empty");
		$("#error1").show(500);
		i++;
	} else if (str.length > 20) {
		$("#error1").text("input is too long");
		$("#error1").show(500);
		i++;
	} else
		$("#error1").hide(500);
}
function checkemail() {
	var str = $("#email").val();
	var patt1 = /[A-Za-z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+/m;
	var str1 = str.match(patt1);
	if (str.length == 0) {
		$("#error2").text("input is empty");
		$("#error2").show(500);
		i++;
	} else if (str1 == null || str1[0].length != str.length) {
		$("#error2").text("email address format is not correct");
		$("#error2").show(500);
		i++;
	} else if (str.length > 30) {
		$("#error2").text("input is too long");
		$("#error2").show(500);
		i++;
	} else {
		$("#error2").hide(500);
	}
}
function checksubject() {
	var str = $("#subject").val();
	if (str.length == 0) {
		$("#error3").text("input is empty");
		$("#error3").show(500);
		i++;
	} else if (str.length > 20) {
		$("#error3").text("input is too long");
		$("#error3").show(500);
		i++;
	} else
		$("#error3").hide(500);
}
function checktext() {
	var str = $("#text").val();
	if (str.length == 0) {
		$("#error4").text("input is empty");
		$("#error4").show(500);
		i++;
	} else if (str.length > 200) {
		$("#error4").text("input is too long");
		$("#error4").show(500);
		i++;
	} else
		$("#error4").hide(500);
}

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
					<li><a href="FaqsServlet">FAQs</a></li>
					<li><a id="index_checkout" href="#">Checkout</a></li>
					<li><a id="index_contact" href="#" class="selected">Contact</a></li>
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

				<h1>Contact Information</h1>
				<div class="content_half float_l">
					<h4>Send us a message now!</h4>
					<p>Etiam id massa scelerisque nunc luctus ultrices tellus
						laoreet eget a sem.
					<div id="contact_form">
						<form method="post" name="contact" action="#">

							<label for="author">Name:</label> <input type="text" id="author"
								name="author" class="required input_field" />
							<div class="cleaner h10" style="margin-bottom: 7px">
								<font id="error1" style="display: none" color="red"></font>
							</div>
							<label for="email">Email:</label> <input type="text" id="email"
								name="email" class="validate-email required input_field" />
							<div class="cleaner h10" style="margin-bottom: 7px">
								<font id="error2" style="display: none" color="red"></font>
							</div>

							<label for="subject">Subject:</label> <input type="text"
								name="subject" id="subject" class="input_field" />

							<div class="cleaner h10" style="margin-bottom: 7px">
								<font id="error3" style="display: none" color="red"></font>
							</div>

							<label for="text">Message:</label>
							<textarea id="text" name="text" rows="0" cols="0"
								class="required"></textarea>
							<div class="cleaner h10" style="margin-bottom: 7px">
								<font id="error4" style="display: none" color="red"></font>
							</div>

							<input type="button" value="Send" id="submit" name="submit"
								class="submit_btn float_l" /> <input type="reset" value="Reset"
								id="reset" name="reset" class="submit_btn float_r" />

						</form>
					</div>
				</div>
				<div class="content_half float_r">
					<h4>Mailing Address</h4>
					<h6>
						<strong>Location One</strong>
					</h6>
					132-145 Aliquam vitae mi tellus,<br /> Nulla mauris elit pretium,
					23900<br /> Pellentesque sit amet<br />
					<br /> <strong>Phone:</strong> 090-090-1080<br /> <strong>Email:</strong>
					<a href="mailto:info@yoursite.com">info@yoursite.com</a><br />

					<div class="cleaner h20"></div>
					<h6>
						<strong>Location Two</strong>
					</h6>
					211-303 Curabitur tincidunt euismod,<br /> Sed eu tortor nunc at
					ipsum, 14080<br /> Vestibulum nec tincidunt<br />
					<br /> <strong>Phone:</strong> 020-050-1920<br /> <strong>Email:</strong>
					<a href="mailto:info@yoursite.com">info@yoursite.com</a><br />
				</div>

				<div class="cleaner h40"></div>



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