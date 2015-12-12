<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="data-spm" content="a1z0a" />
<title>money back</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<table>
		<tr>
			<td>order number :</td>
			<td><input type="text" id="order_id" value=""></td>
			<td>time :</td>
			<td><select>
					<option value="0">the last 3 month</option>
					<option value="1">3 month ago</option>
			</select></td>
		</tr>
		<tr>
			<td>back number :</td>
			<td><input type="text" id="refund_id" value=""></td>
			<td>back state :</td>
			<td><select>
					<option value="all">all</option>
					<option value="STATUS_WAIT_SELLER_AGREE">appling</option>
					<option value="STATUS_SELLER_REFUSE_BUYER">seller not
						agree</option>
					<option value="STATUS_WAIT_BUYER_RETURN_GOODS">waiting
						for commodity</option>
					<option value="STATUS_SUCCESS">success</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="3"><button class="small-btn J_MakePoint"
					id="J_SearchOrders">search</button></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>back number</th>
			<th>order number</th>
			<th>buyer</th>
			<th>money</th>
			<th>back money</th>
			<th><select>
					<option value="0">time</option>
					<option value="1">from far to near</option>
					<option value="2">from near to far</option>
			</select></th>
			<th>state</th>
			<th>operate</th>
		</tr>
	</table>

	<p class="refund-order-tips">
		if you didn't find ,please go to<a href='#'>all informations</a>
	</p>




</body>

</html>
