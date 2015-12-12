<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="seller/images/skin.css" rel="stylesheet" type="text/css" />

<%@ page import="com.seller.vo.*"%>
<%@ page import="com.seller.dao.*"%>
<%@ page import="java.util.*"%>
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
		    
		    UserorderDao uod=new UserorderDao();
		    List<Sendorderinfo> soi=new ArrayList<Sendorderinfo>();
		    soi=uod.showorder(si);    
		 %>
</head>

<body bgcolor="#EEF2FB">
	<div align="center" style="margin-top: 15px">
		<form name="form1" method="post">
			<table width="91%" class="line_table">
				<tr>
					<td width="9%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">OrderID</td>
					<td width="15%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductName</td>
					<td width="4%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Amount</td>
					<td width="9%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">OrderTime
					</td>
					<td width="9%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneeName</td>
					<td width="9%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneePhoneNumber</td>
					<td width="24%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ConsigneeAddress</td>
					<td width="5%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">SonsigneePostcode</td>
					<td width="7%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">delivery</td>
				</tr>
				<% 
			for(Sendorderinfo s:soi) {
	%>
				<tr>
					<td align="center" width="18px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getOrderid() %></td>
					<td align="center" width="16px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getProductname() %></td>
					<td align="center" width="7px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getProductbuynum() %></td>
					<td align="center" width="10px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getOrdertime() %></td>
					<td align="center" width="10px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getConsigneename() %></td>
					<td align="center" width="10px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getConsigneephonenumber() %></td>
					<td align="center" width="25px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getConsigneeaddress() %></td>
					<td align="center" width="6px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><%=s.getConsigneepostcode() %></td>
					<td align="center" width="8px"
						background="seller/images/news-title-bg.gif" class="left_bt2"><a
						style="TEXT-DECORATION: underline"
						href="servlet/DeliveryproductServlet?orderid=<%=s.getOrderid()%>&ordertime=<%=s.getOrdertime()%>">delivery</a></td>
				</tr>
				<% } %>
			</table>
		</form>
	</div>
</body>
</html>
