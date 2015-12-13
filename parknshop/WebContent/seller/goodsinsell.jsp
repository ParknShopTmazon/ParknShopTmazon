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
					hidefocus="true">the commodities in sales</a></li>
			</ul>
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
