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

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

$(document).ready(function(){
	$("input[type='submit']").bind("click",function(){
		$("#form1").attr("action","CommentEndServlet");
		$("#form1").submit();
	});
	$("input[name='commentlevel']").bind("click",function(){
		$("#level").val(this.value);
	});
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
			<div id="myorder">
				<h1>Comment</h1>

				<table width="900px" cellspacing="0" cellpadding="5">
					<tr bgcolor="#dddddd">
						<th width="300" align="left">Image</th>
						<th width="500" align="center">Description</th>
						<th width="100" align="center">Price</th>
					</tr>
					<tr>
						<td><a
							href="ProductDetailServlet?product_ID=${requestScope.product_ID}">
								<img src="${requestScope.product_img_url}"
								style="height: 150px; width: 200px;" />
						</a></td>
						<td align="center">${requestScope.product_description}</td>
						<td align="center"><b style="color: red">
								$${requestScope.product_price}</b></td>

					</tr>
				</table>


				<!-- 评价-->
				<form id="form1" method="post">
					<table width="900px" height="200px" cellspacing="0" cellpadding="5">
						<tr>
							<th width="800" align="center">Evaluation</th>
						</tr>

						<tr>
							<td align="center"><textarea rows="5" cols="100"
									name="commenttext">
                             Please enter the evaluation contents
                       </textarea></td>
						</tr>

						<tr>
							<td align="center"><input type="hidden" name="order_id"
								value="${requestScope.order_id}" /> <input type="hidden"
								name="level" id="level" value="1" /> <input type="radio"
								name="commentlevel" value="1" checked="checked">good <input
								type="radio" name="commentlevel" value="2">General <input
								type="radio" name="commentlevel" value="3">Bad</td>
						</tr>
						<tr>
							<td align="center"><input type="submit" value="submit">
								<input type="reset" value="reset"></td>
						</tr>
					</table>
				</form>

				<table width="900px" cellspacing="0" cellpadding="5">
					<tr bgcolor="#dddddd">
						<th width="100" align="center">UserName</th>
						<th width="300" align="center">Comment Content</th>
						<th width="100" align="center">Date</th>
					</tr>
					<c:forEach items="${requestScope.commentlist}" var="list">
						<tr>
							<th width="100" align="center">${list.customername}</th>
							<th width="300" align="center">${list.level}</th>
							<th width="100" align="center">${list.time}</th>
						</tr>
					</c:forEach>
				</table>
			</div>

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