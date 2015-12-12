<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>delivery</title>
<link href="css/shipment.css" type="text/css" rel="stylesheet" />
<style type="text/css">
<!--
.STYLE1 {
	font-family: Geneva, Arial, Helvetica, sans-serif
}

.STYLE2 {
	font-family: Tahoma
}

.STYLE3 {
	font-family: Verdana, Arial, Helvetica, sans-serif
}
-->
</style>

</head>
<body>
	<div class="item-tab-subtab">
		<div class="item-tab" data-spm="100006">
			<ul>
				<li class="current"><a href="#" class="STYLE1"
					hidefocus="true">Waiting for delivery of orders </a></li>
				<li><a href="delivery2.jsp" class="STYLE1" hidefocus="true">The
						delivery of orders </a></li>
				<li><a href="delivery3.jsp" class="STYLE1" hidefocus="true">Shipped
						orders</a></li>

			</ul>
		</div>
		<div class="item-subtab" style="border-bottom: 0px;" data-spm="100007">
			<ul>
				<li class="current"><a href="#" class="STYLE3"
					hidefocus="true">unfilled orders </a></li>
				<li><a href="delivery1.jsp" class="STYLE3" hidefocus="true"
					onclick="nav()">The cancellation of the order </a></li>
			</ul>
		</div>
	</div>

	<table align="left">
		<tr>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><span class="STYLE1">name of buyer：</span></td>
			<td><input type="text" size="15" id="auctionTitle"
				name="auctionTitle" value="" /></td>
			<td><span class="STYLE2">nickname of buyer：</span></td>
			<td><input type="text" size="15" id="bizOrderDateBegin"
				name="bizOrderTimeBegin" value="" /></td>
			<td><span class="STYLE2">date：</span></td>
			<td><input type="text" size="15" /> <span class="STYLE2">to</span>
			</td>
			<td><input type="text" size="15" /></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><span class="STYLE2">order number ：</span></td>
			<td><input type="text" size="15" id="J_BuyNick" name="buyerNick"
				value=""></td>
			<td><span class="STYLE2">the choice of buyer ：</span></td>
			<td><select name="shipping2">
					<option value="-1">all</option>
					<option value="1">ordinary mail</option>
					<option value="2">fast mail</option>
					<option value="7">EMS</option>
			</select></td>
			<td><span class="STYLE2">type of order：</span></td>
			<td><select name="orderType">
					<option value="-1">all</option>
					<option value="2">virtual goods</option>
					<option value="1">others</option>
			</select></td>
			<td align="center">
				<button>search</button>
			</td>
		</tr>
	</table>

	<table class="logis" id="J_Express" data-spm="100008">
		<tr>
			<td><div align="center">
					<span class="STYLE2">Do not meet the conditions of the
						logistics order！</span>
				</div></td>
		</tr>
	</table>

	</center>




</body>
</html>
