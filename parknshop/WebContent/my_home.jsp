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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js"></script>

<script language="javascript" type="text/javascript">
var divtype="${requestScope.divtype}";
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}

	$(document).ready(function() {
		
		changestate();
		
		function changestate(){
			var inputlist=$("input[name='order_product']");
			for(var i=0;i<inputlist.length;i++){
				var order_id=inputlist[i].id.substring(14,inputlist[i].id.length);
				var product_id=inputlist[i].value;
				var state=$("#stateinput"+product_id+order_id).val();
				if(state==1){
					$("#statefont"+product_id+order_id).text("Paid");
					$("#orderremove"+order_id).hide();
					$("#comment"+product_id+order_id).hide();
				}
				if(state==2){
					$("#statefont"+product_id+order_id).text("Shipped");
					$("#orderremove"+order_id).hide();
					$("#comment"+product_id+order_id).hide();
				}
				if(state==3){
					$("#statefont"+product_id+order_id).text("Not receiving");
					$("#orderremove"+order_id).hide();
					$("#comment"+product_id+order_id).hide();
					$("#confirm"+product_id+order_id).show();
				}
				if(state==4){
					$("#statefont"+product_id+order_id).text("No comment");
					$("#orderremove"+order_id).hide();
				}
				if(Number(state)>=5){
					$("#statefont"+product_id+order_id).text("Have comments");
					$("#comment"+product_id+order_id).hide();
				}
			}
		};
		
		if(divtype=="2"){
			$("#content").hide(); //历史记录

			$("#openshopDiv").hide();
			$("#myfavouriteDiv").show();
		}
		
		$("a[name='confirm']").click(function(){
			var order_id=this.id.substring(11,this.id.length);
			var product_id=$("#ordertoproduct"+order_id).val();
			confirmAjax(order_id,product_id);
		});
		
		function confirmAjax(order_id,product_id){
			var Ajaxresult=null;
			$.ajax({  
				type: "post",    
				url: "ConfirmGoodAjax?order_id="+order_id,
				contentType: "application/json; charset=utf-8",  
				success: function (data) {
					
					Ajaxresult=eval("("+data+")");
					var result=Ajaxresult.result;
					if(result==1){
						$("#statefont"+product_id+order_id).text("No comment");
						$("#confirm"+product_id+order_id).hide();
						$("#stateinput"+product_id+order_id).val(4);
						$("#comment"+product_id+order_id).show();
					}	
				},    
				error: function (XMLHttpRequest, textStatus, errorThrown) {   
					alert(errorThrown);    
				}    
			});	
		}
		
		$("a[name='orderremove']").click(function() {
			var order_id=this.id.substring(11,this.id.length);
			orderremoveAjax(order_id);
		});
		
		function orderremoveAjax(order_id){
			var Ajaxresult=null;
			$.ajax({  
				type: "post",    
				url: "UserOrderRemoveAjax?order_id="+order_id,
				contentType: "application/json; charset=utf-8",  
				success: function (data) {		
					Ajaxresult=eval("("+data+")");
					var result=Ajaxresult.result;
					if(result==1){
						$("#ordertr"+order_id).remove();
					}	
				},    
				error: function (XMLHttpRequest, textStatus, errorThrown) {   
					alert(errorThrown);    
				}    
			});	
		}
		
		$("#myhistory").click(function() {
			$("#content").show(); //历史记录

			$("#openshopDiv").hide();
			$("#myfavouriteDiv").hide();
		});

		$("#openshop").click(function() {
			$("#content").hide(); //历史记录

			$("#openshopDiv").show();
			$("#myfavouriteDiv").hide();
		});

		$("#myfavourite").click(function() {
			$("#content").hide(); //历史记录

			$("#openshopDiv").hide();
			$("#myfavouriteDiv").show();
		});

	});
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

<script src="js/jquery-2.0.3.js" type="text/javascript"></script>
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
			<div id="sidebar" class="float_l">
				<div class="sidebar_box">
					<span class="bottom"></span>
					<h3>My Home</h3>
					<div class="content">

						<ul class="sidebar_list">
							<li class="first"><a id="myhistory" href="#">Purchased
									Products </a></li>
							<li class="last"><a id="myfavourite" href="#">My
									Favourite</a></li>
							<li class="last" style="display: none"><a id="openshop"
								href="#">Open Shop </a></li>
						</ul>
					</div>
				</div>

			</div>


			<div id="myfavouriteDiv" class="float_r">
				<h1>My Favourite</h1>
				<table width="680px" cellspacing="0" cellpadding="5"
					bordercolor="#FFFFFF">
					<tr bgcolor="#dddddd">
						<th width="220" align="left">Image</th>
						<th width="220" align="left">Description</th>
						<th width="80" align="right">Price</th>
						<th width="90"></th>
					</tr>
					<c:forEach items="${requestScope.myfavorite_list}" var="list2">
						<tr bgcolor="#ffffff">
							<td align="center"><a
								href="ProductDetailServlet?product_ID=${list2.product_ID}">
									<img src="${list2.product_img_url}"
									style="height: 150px; max-width: 200px;" />
							</a></td>
							<td>${list2.product_description}</td>
							<td align="right">$${list2.product_price}</td>
							<td align="center"><div style="display: none">
									<a id="myfavorite${list2.product_ID}" href="#">remove</a>
								</div></td>
						</tr>
					</c:forEach>
				</table>


				<div class="cleaner h20"></div>
				<p></p>
				<div class="cleaner"></div>

			</div>


			<!--  功能：已购买的物品-->
			<div id="content" class="float_r">
				<h1>Purchased Products</h1>
				<table width="680px" cellspacing="0" cellpadding="5"
					bgcolor="#FFFFFF">
					<tr bgcolor="#dddddd">
						<th width="220" align="left">Image</th>
						<th width="120" align="left">Description</th>
						<th width="60" align="right">Price</th>
						<th width="80" align="right">DateTime</th>
						<th width="130"></th>
					</tr>
					<c:forEach items="${requestScope.abc_list}" var="list">
						<tr id="ordertr${list.order_id}">
							<td align="center"><a
								href="ProductDetailServlet?product_ID=${list.product_id}"> <img
									src="${list.product_img_url}"
									style="height: 150px; max-width: 200px;" /></a></td>
							<td>${list.product_description}</td>
							<td align="right">$${list.product_price}</td>
							<td align="right">${list.datetime}</td>
							<td align="center"><input type="hidden"
								id="ordertoproduct${list.order_id}" name="order_product"
								value="${list.product_id}" /> <a><input
									id="stateinput${list.product_id}${list.order_id}"
									name="orderstate" type="hidden" value="${list.order_state}">
									State:<font id="statefont${list.product_id}${list.order_id}"></font></a>
								<div id="confirm${list.product_id}${list.order_id}"
									style="display: none">
									<a id="confirmAjax${list.order_id}" name="confirm" href="#">Confirm
										the goods</a>
								</div>
								<div>
									<a id="orderremove${list.order_id}" name="orderremove" href="#">Remove</a>
								</div>
								<div>
									<a
										href="MyOrderServlet?order_id=${list.order_id}&order_state=${list.order_state}">View
										Order</a>
								</div> <a id="comment${list.product_id}${list.order_id}"
								href="CommentServlet?product_id=${list.product_id}&order_id=${list.order_id}">Comment</a></td>
						</tr>
					</c:forEach>
				</table>
				<div style="float: right; width: 215px; margin-top: 20px;"></div>

				<div class="cleaner h20"></div>
				<p></p>
				<div class="cleaner"></div>
			</div>

			<!--  功能 ：申请开店-->
			<div id="openshopDiv" class="float_r">
				<h1>Open Shop</h1>
				<center>
					Apply state:<span id="applystate" style="color: red;"> not
						apply</span>
				</center>
				<form method="post" id="openshowForm" action="" name="openshowForm">
					<table width="680px" cellspacing="0" cellpadding="5"
						bgcolor="#FFFFFF">
						<tr bgcolor="#dddddd">
							<th width="100px">User Name:</th>
							<td width="100px"><input type="text" name="name"
								value="zhangsan" id="name"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">UserId</th>
							<td width="100px"><input type="text" name="userId"
								value="000001" id="userId"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">ShopName</th>
							<td width="100px"><input type="text" name="userId"
								id="ShopName"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">Shop Password</th>
							<td width="100px"><input type="text" name="shopPwd"
								id="shopPwd" maxlength="30"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">Confirm Password</th>
							<td width="100px"><input id="confirmId" type="text"
								maxlength="30"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">Id Card</th>
							<td width="100px"><input type="text" name="userId"
								id="userId" size="20" maxlength="18"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<th width="100px">Bank Card Id</th>
							<td width="100px"><input type="text" name="userId"
								id="userId" size="20" maxlength="19"></td>
						</tr>
						<tr bgcolor="#dddddd">
							<td colspan="2">
								<center>
									<input type="submit" value="submit"> <input
										type="reset" value="reset">
								</center>
							</td>
						</tr>
					</table>
				</form>
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