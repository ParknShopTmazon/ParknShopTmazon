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

var i=0;

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

$(document).ready(function() {
	
	$("a[name='paybutton']").hover(function() {
		this.style.cursor = "pointer";
	});
	
	$("a[name='paybutton']").bind("click",function(){
		i = 0;
		checkreceivename();
		checkreceiveaddress();
		checkreceivecity();
		checkreceivecountry();
		checkreceiveemail();
		checkreceivephone();
		if( i==0 ){
			$("#form1").attr("action","CheckoutEndServlet");
			$("#form1").submit();
		}
	});
	
	$("#receivename").bind("blur", function() {
		checkreceivename();
	});
	$("#receiveaddress").bind("blur", function() {
		checkreceiveaddress();
	});
	$("#receivecity").bind("blur", function() {
		checkreceivecity();
	});
	$("#receivecountry").bind("blur", function() {
		checkreceivecountry();
	});
	$("#receiveemail").bind("blur", function() {
		checkreceiveemail();
	});
	$("#receivephone").bind("blur", function() {
		checkreceivephone();
	});
	
});

function checkreceivename(){
	var str = $("#receivename").val();
	if (str.length == 0) {
		$("#error1font").text("input is empty");
		$("#error1font").show(500);
		$("#errorfont1").hide(500);
		i++;
	} else if (str.length > 20) {
		$("#error1font").text("input is too long");
		$("#error1font").show(500);
		$("#errorfont1").hide(500);
		i++;
	} else{
		$("#error1font").hide(500);
		$("#errorfont1").show(500);
	}
		
}
function checkreceiveaddress(){
	var str = $("#receiveaddress").val();
	if (str.length == 0) {
		$("#error2font").text("input is empty");
		$("#error2font").show(500);
		$("#errorfont2").hide(500);
		i++;
	} else if (str.length > 30) {
		$("#error2font").text("input is too long");
		$("#error2font").show(500);
		$("#errorfont2").hide(500);
		i++;
	} else{
		$("#error2font").hide(500);
		$("#errorfont2").show(500);
	}
}
function checkreceivecity(){
	var str = $("#receivecity").val();
	if (str.length == 0) {
		$("#error3font").text("input is empty");
		$("#error3font").show(500);
		$("#errorfont3").hide(500);
		i++;
	} else if (str.length > 20) {
		$("#error3font").text("input is too long");
		$("#error3font").show(500);
		$("#errorfont3").hide(500);
		i++;
	} else{
		$("#error3font").hide(500);
		$("#errorfont3").show(500);
	}
}
function checkreceivecountry(){
	var str = $("#receivecountry").val();
	if (str.length == 0) {
		$("#error4font").text("input is empty");
		$("#error4font").show(500);
		$("#errorfont4").hide(500);
		i++;
	} else if (str.length > 20) {
		$("#error4font").text("input is too long");
		$("#error4font").show(500);
		$("#errorfont4").hide(500);
		i++;
	} else{
		$("#error4font").hide(500);
		$("#errorfont4").show(500);
	}
		
}
function checkreceiveemail(){
	var str = $("#receiveemail").val();
	var patt1 = /[A-Za-z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+/m;
	var str1 = str.match(patt1);
	if (str.length == 0) {
		$("#error5font").text("input is empty");
		$("#error5font").show(500);
		$("#errorfont5").hide(500);
		i++;
	} else if (str1 == null || str1[0].length != str.length) {
		$("#error5font").text("email address format is not correct");
		$("#error5font").show(500);
		$("#errorfont5").hide(500);
		i++;
	} else if (str.length > 30) {
		$("#error5font").text("input is too long");
		$("#error5font").show(500);
		$("#errorfont5").hide(500);
		i++;
	} else {
		$("#error5font").hide(500);
		$("#errorfont5").show(500);
	}
}
function checkreceivephone(){
	var str = $("#receivephone").val();
	var patt1 = /[0-9]+/m;
	var str1 = str.match(patt1);
	if (str.length == 0) {
		$("#error6font").text("input is empty");
		$("#error6font").show(500);
		$("#errorfont6").hide(500);
		i++;
	} else if (str1 == null || str1[0].length != str.length) {
		$("#error6font").text("phonenumber format is not correct");
		$("#error6font").show(500);
		$("#errorfont6").hide(500);
		i++;
	} else if (str.length > 30) {
		$("#error6font").text("input is too long");
		$("#error6font").show(500);
		$("#errorfont6").hide(500);
		i++;
	} else {
		$("#error6font").hide(500);
		$("#errorfont6").show(500);
	}
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
					<li><a id="index_checkout" href="#" class="selected">Checkout</a></li>
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
				<h2>Checkout</h2>
				<h5>
					<strong>BILLING DETAILS</strong>
				</h5>
				<form action="" name="form1" id="form1" method="post">
					<input type="hidden" name="product_id_all"
						value="${requestScope.product_id_all}"> <input
						type="hidden" name="product_quantity_all"
						value="${requestScope.product_quantity_all}">
					<div class="content_half float_l checkout">
						Enter your full name as it is on the credit card: <input
							id="receivename" type="text" name="receivename"
							style="width: 300px; margin-bottom: 0px" />
						<div id="error1" style="padding-left: 0px">
							<font style="display: none" id="error1font" color="red"></font> <font
								id="errorfont1">&nbsp;</font>
						</div>
						Address: <input id="receiveaddress" type="text"
							name="receiveaddress" style="width: 300px; margin-bottom: 0px" />
						<div id="error2" style="padding-left: 0px">
							<font style="display: none" id="error2font" color="red"></font> <font
								id="errorfont2">&nbsp;</font>
						</div>
						City: <input id="receivecity" type="text" name="receivecity"
							style="width: 300px; margin-bottom: 0px" />
						<div id="error3" style="padding-left: 0px">
							<font style="display: none" id="error3font" color="red"></font> <font
								id="errorfont3">&nbsp;</font>
						</div>
						Country: <input id="receivecountry" type="text"
							name="receivecountry" style="width: 300px; margin-bottom: 0px" />
						<div id="error4" style="padding-left: 0px">
							<font style="display: none" id="error4font" color="red"></font> <font
								id="errorfont4">&nbsp;</font>
						</div>
					</div>

					<div class="content_half float_r checkout">
						Email: <input id="receiveemail" type="text" name="receiveemail"
							style="width: 300px; margin-bottom: 0px" />
						<div id="error5" style="padding-left: 0px; margin-bottom: 0px">
							<font style="display: none" id="error5font" color="red"></font> <font
								id="errorfont5">&nbsp;</font>
						</div>
						Phone:<br /> <span style="font-size: 10px">Please, specify
							your reachable phone number. YOU MAY BE GIVEN A CALL TO VERIFY
							AND COMPLETE THE ORDER.</span> <input id="receivephone" type="text"
							name="receivephone" style="width: 300px; margin-bottom: 0px" />
						<div id="error6" style="padding-left: 0px">
							<font style="display: none" id="error6font" color="red"></font> <font
								id="errorfont6">&nbsp;</font>
						</div>
						<input id="useraccount" name="useraccount" type="hidden"
							value="${requestScope.total_price}" />
					</div>
				</form>
				<div class="cleaner h50"></div>
				<h3>Shopping Cart</h3>
				<h4>
					TOTAL: <strong>$${requestScope.total_price}</strong>
				</h4>
				<!-- <p><input type="checkbox" />I have accepted the Terms of Use.</p>  -->
				<table style="border: 1px solid #CCCCCC;" width="100%">
					<tr>
						<td height="80px"><img src="images/paypal.gif" alt="paypal" /></td>
						<td width="400px;" style="padding: 0px 20px;">Recommended if
							you have a PayPal account. Fastest delivery time.</td>
						<td><a name="paybutton" class="more">PAYPAL</a></td>
					</tr>
					<tr>
						<td height="80px"><img src="images/2co.gif" alt="paypal" />
						</td>
						<td width="400px;" style="padding: 0px 20px;">Inc. is an
							authorized retailer of goods and services provided by
							Template-Guide.com CheckOut accepts customer orders via online
							checks, Visa, MasterCard, Discover, American Express, Diners, JCB
							and debit cards with the Visa, Mastercard logo. Sed laoreet
							ornare ligula eu blandit.
						<td><a name="paybutton" class="more">CHECKOUT</a></td>
					</tr>
				</table>
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