<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="images/skin.css" rel="stylesheet" type="text/css" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<base href="<%=basePath%>">

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

a:link {
	text-decoration: underline;
}

.STYLE3 {
	font-size: 14px;
	font-weight: bold;
}
-->
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<c:forEach items="${shop}" var="shop">
		<table class="STYLE3" align="center" width="60%">
			<tr>
				<td align="center" width="20%" class="left_bt2">ShopInfoID:</td>
				<td align="center" width="80%" class="left_bt2">${shop.shopInfoId}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">CustomerName:</td>
				<td align="center" width="80%" class="left_bt2"><a
					href="CustomerServlet?id=${shop.customerName}" target="main">${shop.customerName}</a></td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ShopInfoName:</td>
				<td align="center" width="80%" class="left_bt2">${shop.shopInfoName}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">ShopInfoDescription:
				</td>
				<td align="center" width="80%" class="left_bt2">${shop.shopInfoDescription}</td>
			</tr>
			<tr>
				<td align="center" width="20%" class="left_bt2">Status:</td>
				<td align="center" width="80%" class="left_bt2">${shop.status1}</td>
			</tr>
			<tr>
				<td></td>
				<td align="center" class="left_bt2">
					<a
					style="text-decoration: none;"
					href="ShopServlet?operation=1&id=${shop.shopInfoId}" target="main"><button>Normalize</button></a>
					<a style="text-decoration: none;"
					href="ShopServlet?operation=2&id=${shop.shopInfoId}" target="main"><button>Refuse</button></a>
					<a style="text-decoration: none;"
					href="ProductsServlet?id=${shop.shopInfoId}" target="main"><button>>>See
							Products</button></a>
					<a style="text-decoration: none;"
					href="ShopServlet?operation=0&id=${shop.shopInfoId}" target="main"><button>Approve</button></a>
							</td>
				
					
							
			</tr>
		</table>
	</c:forEach>

</body>
