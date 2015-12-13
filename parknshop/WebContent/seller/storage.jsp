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
					hidefocus="true">Waiting for sale </a></li>
				<li><a href="#" class="STYLE1" hidefocus="true">The
						commodity of seel out </a></li>

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
			<td><span class="STYLE1">name of commodity：</span></td>
			<td><input type="text" size="20" id="auctionTitle"
				name="auctionTitle" value="" /></td>
			<td><span class="STYLE2">number of seller：</span></td>
			<td><input type="text" size="20" id="bizOrderDateBegin"
				name="bizOrderTimeBegin" value="" /></td>
			<td><span class="STYLE2">type ：</span></td>
			<td><select name="shipping2">
					<option value="-1">all</option>
					<option value="1">ordinary</option>
					<option value="2">discount</option>
					<option value="7">vip discount</option>
			</select>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><span class="STYLE2">price：</span></td>
			<td><input type="text" size="4" /> <span class="STYLE2">to</span>
				<input type="text" size="4" /></td>

			<td><span class="STYLE2">sales ：</span></td>
			<td><input type="text" size="4" /> <span class="STYLE2">to</span>
				<input type="text" size="4" /></td>

			</td>
			<td><span class="STYLE2">state ：</span></td>
			<td><select name="shipping2">s
					<option value="-1">all</option>
					<option value="1">waiting for sale</option>
					<option value="7">not for sale</option>
			</select></td>
			<td>&nbsp;</td>
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
