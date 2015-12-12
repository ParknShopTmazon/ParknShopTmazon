<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
<base href="<%=basePath%>">
<title>admin_top</title>
<link href="default.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body leftmargin="0" topmargin="0">
	<table width="100%" height="64" border="0" cellpadding="0"
		cellspacing="0" class="admin_topbg">
		<tr>
			<td width="80%" height="64"><a href="AdminLoginServlet"
				target="_parent"><img src="images/templatemo_logo.png"
					width="248" height="55"></a></td>
			<td width="20%" valign="top">

				<form action="SearchServlet" target="main" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr align="right">
							<td width="5%" height="35" align="right"><select
								name="SearchType" size="1">
									<option value=0 selected>All</option>
									<option value=1>Customers</option>
									<option value=2>Comments</option>
									<option value=3>Shops</option>
									<option value=4>Orders</option>
									<option value=5>Products</option>
							</select></td>
							<td width="75%"><input id="searchinput" type="text"
								name="SearchInput" value="" /></td>
							<td width="20%"><input name="submit" type="submit"
								id="search" value="Search" /></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>
</body>
</html>
