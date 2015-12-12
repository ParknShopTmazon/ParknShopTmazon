<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>评价管理</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="seller/images/skin.css" type="test/css" rel="stylesheet">


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
		 %>

<style>
.comments {
	margin-left: 80px;
	margin-top: 20px;
}
</style>
<script language="javascript">
		 function confirm(level)
		 {
		    var sid=document.comment.shopid.value;
		 	this.comment.method="post";
		 	this.comment.action="servlet/ShowcommentsServlet?shopid="+sid+"&level="+arguments[0];
		 	this.comment.submit();
		 }
		 
		 function mouseDown()
		 {
		 	
		 }
		 </script>
</head>

<body bgcolor="#EEF2FB">
	<form name="comment">
		<div class="comments">
			<button onclick="javascript:confirm(0)">Total</button>
			<button onclick="javascript:confirm(1)">favourable comment</button>
			<button onclick="javascript:confirm(2)">the comment</button>
			<button onclick="javascript:confirm(3)">negative comment</button>
			<input type="hidden" value="<%=si.getShopinfoid()%>" name="shopid">
		</div>
	</form>

	<div align="center">
		<form name="form1" method="post" target="_self">
			<input type="hidden" name="showPage">
			<table class="line_table" width="85%" align="center">
				<tr>
					<th width="41%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Comments</th>
					<th width="16%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductName</th>
					<th width="11%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductType</th>
					<th width="11%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Time</th>
					<th width="6%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">CustomerName</th>
				</tr>
				<c:forEach items="${requestScope.commentlist}" var="commentlist">
					<tr align="center">
						<td background="seller/images/news-title-bg.gif" class="left_bt2">
							${commentlist.commentary}</td>
						<td align="center" background="seller/images/news-title-bg.gif"
							class="left_bt2">${commentlist.pName}</td>
						<td align="center" background="seller/images/news-title-bg.gif"
							class="left_bt2">${commentlist.ptname}</td>
						<td align="center" background="seller/images/news-title-bg.gif"
							class="left_bt2">${commentlist.time}</td>
						<td align="center" background="seller/images/news-title-bg.gif"
							class="left_bt2">${commentlist.cName}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<p>
</body>
</html>



