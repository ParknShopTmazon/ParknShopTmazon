<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv=Content-Type content=text/html; charset=UTF-8 />
<title>left</title>
<link href="default.css" rel="stylesheet" type="text/css" />
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
</head>

<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" bgcolor="#EEF2FB">
		<tr>
			<td width="182" valign="top"><div id="container">



					<h1 class="type">
						<a href="javascript:void(0)">Buyer Management</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="CustomersServlet?role=0&type=7" target="main">All
									Buyers</a></li>
							<li><a href="CustomersServlet?role=0&type=0" target="main">Normal
									Buyers</a></li>
							<li><a href="CustomersServlet?role=0&type=1" target="main">BlackListed
									Buyers</a></li>
							<li><a href="CustomersServlet?role=0&type=2" target="main">Delected
									Buyers</a></li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">Seller Management</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="CustomersServlet?role=1&type=7" target="main">All
									Sellers</a></li>
							<li><a href="CustomersServlet?role=1&type=0" target="main">Normal
									Sellers</a></li>
							<li><a href="CustomersServlet?role=1&type=1" target="main">BlackListed
									Sellers</a></li>
							<li><a href="CustomersServlet?role=1&type=2" target="main">Delected
									Sellers</a></li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">Comment Management</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="CommentsServlet?type=7" target="main">All
									Comments</a></li>
							<li><a href="CommentsServlet?type=0" target="main">Normal
									Comments</a></li>
							<li><a href="CommentsServlet?type=1" target="main">Reported
									Comments</a></li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">Shop Management</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="ShopsServlet?type=7" target="main">All
									Shops</a></li>
							<li><a href="ShopsServlet?type=-1" target="main">Normal
									Shops</a></li>
							<li><a href="ShopsServlet?type=1" target="main">Reported
									Shops</a></li>
							<li><a href="ShopsServlet?type=2" target="main">Refused
									Shops</a></li>
							<li><a href="ShopsServlet?type=0" target="main">Examing
									Shops</a></li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">Order Management</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="OrdersServlet?type=7" target="main">All
									Orders</a></li>
							<li><a href="OrdersServlet?type=1" target="main">Non-Payment
									Orders</a></li>
							<li><a href="OrdersServlet?type=2" target="main">Delivered
									Orders</a></li>
							<li><a href="OrdersServlet?type=3" target="main">Finished
									Orders</a></li>
						</ul>
					</div>







					<h1 class="type">
						<a href="javascript:void(0)">Others</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="admin/AddProductType.jsp" target="main">Backup
									Database</a></li>
							<li><a href="RateServlet" target="main">Change Commission Rate</a></li>
							<li><a href="admin/ChangePwd.jsp" target="main">Change
									Password</a></li>
							<li><a href="admin/income.jsp" target="main">Calculate
									income from commission</a></li>
						</ul>
					</div>
				</div> <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script></td>
		</tr>
	</table>
</body>
</html>
