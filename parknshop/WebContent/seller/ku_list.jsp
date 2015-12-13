<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.seller.vo.*"%>
<%@ page import="com.seller.dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="seller/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		    ProductDao pd=new ProductDao();
		    List<Productinfo> plist=new ArrayList<Productinfo>();
		    plist=pd.showproductList(si);
		    
		 %>
</head>
<body bgcolor="#EEF2FB">
	<div align="center" style="margin-top: 15px">
		<form name="form1" method="post">
			<table align="center" width="90%" class="line_table">
				<tr>
					<th width="10%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductId</th>
					<th width="21%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductName</th>
					<th width="16%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">ProductType</th>
					<th width="11.5%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Price</th>
					<th width="11.5%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Stock</th>
					<th width="10%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Modify</th>
					<th width="10%" align="center"
						background="seller/images/news-title-bg.gif" class="left_bt2">Delete</th>
				</tr>
				<%
			for (Productinfo p : plist) {
		%>
				<tr>
					<td width="10%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><a
						href="seller/modify_product.jsp?modify_id=<%=p.getP_id()%>&modify_name=<%=p.getP_name()%>&modify_type=<%=p.getP_type()%>&modify_price=<%=p.getP_price()%>&modify_stock=<%=p.getP_stock()%>&modify_desc=<%=p.getP_desc()%>&modify_img=<%=p.getImg_path()%>"><%=p.getP_id() %></a></td>
					<td width="21%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><%=p.getP_name() %></td>
					<td width="16%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><%=p.getP_type() %></td>
					<td width="11.5%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center">￥<%=p.getP_price() %></td>
					<td width="11.5%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><%=p.getP_stock() %></td>
					<td width="10%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><font color="#0000FF"><a
							style="TEXT-DECORATION: underline"
							href="seller/modify_product.jsp?modify_id=<%=p.getP_id()%>&modify_name=<%=p.getP_name()%>&modify_type=<%=p.getP_type()%>&modify_price=<%=p.getP_price()%>&modify_stock=<%=p.getP_stock()%>&modify_desc=<%=p.getP_desc()%>&modify_img=<%=p.getImg_path()%>">modify</a></font></td>
					<td width="10%" background="seller/images/news-title-bg.gif"
						class="left_bt2" align="center"><font color="#0000FF"><a
							style="TEXT-DECORATION: underline"
							href="servlet/DeleteproductServlet?del_productid=<%=p.getP_id()%>">delete</a></font></td>
				</tr>
				<%} %>
			</table>
		</form>
	</div>
</body>
</html>
