<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="data-spm" content="a1z09" />
<title>已卖出的宝贝</title>
<base href="<%=basePath %>">
<link href="seller/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<%@ page import="com.seller.vo.*"%>
<%
		     Shopinfo si=new Shopinfo();
		    if(session.getAttribute("shopinfo")==null)
		    {
		        //刚刚登陆
		    	si=(Shopinfo)request.getAttribute("shopinfo");
		    	session.setAttribute("shopinfo",si);
		    }
		    else
		    {
		    	si=(Shopinfo)session.getAttribute("shopinfo");
		    }		     
		    /* Shopinfo si=(Shopinfo)session.getAttribute("shopinfo");
		    if(si==null)
		    {
		    	si=new Shopinfo();
		    	session.setAttribute("shopinfo", si);
		    } */
 %>


</head>

<body bgcolor="#EEF2FB">
	<form name="search" action="servlet/SearchorderServlet" method="post"
		style="margin-left: 10px; margin-top: 15px;">
		<table cellpadding="0" cellspacing="1" border="0">
			<tr>
				<td>&nbsp;</td>
				<td class="left_bt2">OrderID:</td>
				<td><input type="text" size="13" id="bizOrderId" name="OrderId"
					maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')"
					onblur="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td class="left_bt2">OrderStatus:</td>
				<td><select id="auctionStatus" name="Status"
					style="width: 80px;">
						<option value="0">all</option>
						<option value="1">paid</option>
						<option value="3">shipped</option>
						<option value="4">confirm receipt</option>
				</select></td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td align="center"><input type="submit" value="Search"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="<%=si.getShopinfoid()%>"
					name="hide"></td>
			</tr>
		</table>
	</form>


	<table class="line_table" align="center">
		<tr>
			<th align="center" width="60px"
				background="seller/images/news-title-bg.gif" class="left_bt2">OrderID</th>
			<th align="center" width="60px"
				background="seller/images/news-title-bg.gif" class="left_bt2">TrackingNum</th>
			<th width="100px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">ProductName</th>
			<th width="60px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">Amount</th>
			<th width="100px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">OrderTime</th>
			<th width="100px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneeName</th>
			<th width="120px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneePhoneNumber</th>
			<th width="200px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneeAddress</th>
			<th width="80px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneePostcode</th>
			<th width="80px" align="center"
				background="seller/images/news-title-bg.gif" class="left_bt2">Status
			</th>
		</tr>
		<c:forEach items="${requestScope.soi}" var="soi">
			<tr align="center">
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.orderid}
				</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.trackingnum}
				</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.productname}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi. productbuynum}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.ordertime}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.consigneename}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.consigneephonenumber}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.consigneeaddress}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">${soi.consigneepostcode}</td>
				<td background="seller/images/news-title-bg.gif" class="left_bt2">
					<c:if test="${soi.status==1}">paid</c:if> <c:if
						test="${soi.status==3}">for goods</c:if> <c:if
						test="${soi.status==4}">confirm receipt</c:if>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>