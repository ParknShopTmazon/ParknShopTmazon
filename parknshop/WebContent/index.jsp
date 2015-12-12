<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

</script>

<link rel="stylesheet" type="text/css" media="all"
	href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>
<script src="js/account.js" type="text/javascript"></script>
<script type="text/javascript" src="js/addtocart.js"></script>
<script type="text/javascript">

var picture_size="${requestScope.picture_size}";
var change_img = 1;
$(document).ready(function() {
	change_css();
	timedCount();
	$(".carousel").dualSlider({
		auto:true,
		autoDelay: 6000,
		easingCarousel: "swing",
		easingDetails: "easeOutBack",
		durationCarousel: 1000,
		durationDetails: 600
	});
	
	function change_css(){
		var div_list=$("div[class='product_box no_margin_right']");
		for(var i=0;i<div_list.length;i++){
			if((i+1)%3!=0){
				var product_id=div_list[i].id.substring(6,div_list[i].id.length);
				$("#prodiv"+product_id).removeClass("product_box no_margin_right");
				$("#prodiv"+product_id).addClass("product_box");
			}
		}
	};
	
	function timedCount() {
		$("#adv_img_0").hide();
		for(var i=2;i<=picture_size;i++)
			$("#adv_img_"+i).hide();
		setTimeout("check_adv_img()" , 4000);
	}
	
});

function check_adv_img() {
	$("#adv_img_0").hide();
	if(change_img < picture_size){
		$("#adv_img_"+change_img).hide(800);
		change_img++;
		$("#adv_img_"+change_img).show(800);
	}
	else{
		$("#adv_img_"+change_img).hide(800);
		$("#adv_img_0").show(800);
		setTimeout("$('#adv_img_1').show(); $('#adv_img_0').hide();" , 800);
		change_img = 1;
	}
	
	setTimeout("check_adv_img()", 4000);
}

 function  userType()
 {
     var usertype=document.getElementsByName("choose");
     for(var i=0;i<usertype.length;i++)
     {

        if(usertype[i].checked)
        {
            var  values=usertype[i].value;
           if(values=="Shopowner"){
                alert("Shopowner");
                window.open("seller/index.jsp","_blank");
            }else if(values=="Administrator"){
                window.open("admin/index.jsp","_blank");
                alert("Administrator");
            }else{
                location.href="index.jsp";
            }

        }
     }

 }
</script>


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
					<li><a href="IndexServlet" class="selected">Home</a></li>
					<li><a href="NewProductsServlet">Products</a></li>
					<li><a href="AboutUsServlet">About</a></li>
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

		<div id="templatemo_middle" class="carousel">
			<div class="panel" style="background-image: images/111.jpg">

				<div class="details_wrapper">

					<div class="details">

						<div class="detail">
							<img src="images/slider/03.jpg" max-height="310" width=auto>

						</div>
						<!-- /detail -->

						<div class="detail">
							<img src="images/111.jpg" max-height="260" width="260">
						</div>
						<!-- /detail -->

						<div class="detail">
							<img src="images/111.jpg" max-height="260" width="260">
						</div>
						<!-- /detail -->

					</div>
					<!-- /details -->

				</div>
				<!-- /details_wrapper -->

				<div class="paging" style="display: none">
					<div id="numbers"></div>
					<a href="javascript:void(0);" class="previous" title="Previous">Previous</a>
					<a href="javascript:void(0);" class="next" title="Next">Next</a>
				</div>
				<!-- /paging -->

				<a style="display: none" href="javascript:void(0);" class="play"
					title="Turn on autoplay">Play</a> <a style="display: none"
					href="javascript:void(0);" class="pause" title="Turn off autoplay">Pause</a>

			</div>
			<!-- /panel -->

			<div class="backgrounds" align="left">
				<c:forEach items="${requestScope.picture_list}" var="list">
					<div id="adv_img_${list.num}" class="item item_${list.num}">
						<a href="${list.URL}"><img src="${list.path}" name="adv_img"
							style="max-height: 340px;" /></a>
					</div>
				</c:forEach>

				<div id="adv_img_0" class="item item_1">
					<a href="${requestScope.picture_help.URL}"><img
						src="${requestScope.picture_help.path}" name="adv_img" /></a>
				</div>
				<!-- /item -->
			</div>
			<!-- /backgrounds -->
		</div>
		<!-- END of templatemo_middle -->

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
							<div id="divsellbest${list.product_ID}" class="bs_box">
								<a href="ProductDetailServlet?product_ID=${list.product_ID}">
									<img src="${list.product_img_url}"
									style="border-width: 2px; height: 55px; width: 70px;" />
								</a>
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
				<h1>New Products</h1>
				<input id="buycount" type="hidden" value="1" />
				<c:forEach items="${requestScope.product_list}" var="list">
					<div id="prodiv${list.product_ID}"
						class="product_box no_margin_right">
						<a href="ProductDetailServlet?product_ID=${list.product_ID}">
							<img src="${list.product_img_url}"
							style="height: 150px; max-width: 200px;" />
						</a>
						<h3>${list.product_name}</h3>
						<p class="product_price">$${list.product_price}</p>
						<a id="addtocart${list.product_ID}" class="add_to_card">Add to
							Cart</a> <a id="detail${list.product_ID}"
							href="ProductDetailServlet?product_ID=${list.product_ID}"
							class="detail">Detail</a>
					</div>
				</c:forEach>
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
