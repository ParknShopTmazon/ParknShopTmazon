<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<base href="<%=basePath%>">
<style type="text/css">
<!--
.STYLE2 {
	font-size: 36px;
	font-weight: bold;
}

.STYLE3 {
	font-size: 16px;
	font-weight: bold;
}

body {
	background-image: url(images/1.jpg);
	background-size: 100% 100%;
}
-->
</style>

<base href="<%=basePath%>">
<title>Administrator login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="default.css" rel="stylesheet" type="text/css">
</head>


<body leftmargin="0" topmargin="0">
	<table width="100%" height="64" border="0" cellpadding="0"
		cellspacing="0" class="admin_topbg">
		<tr>
			<td width="63%" height="64"><a href="admin/login.jsp"
				target="_parent"><img src="images/templatemo_logo.png"
					width="248" height="55"></a></td>
			<td width="37%" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">

				</table></td>
		</tr>
	</table>
	<br>
	<br>

	<p align="center" class="STYLE2">Parknshop Management system</p>
	<br>
	<br>

	<form action="AdminLoginServlet" method="post">//adminloginsevelet处理这个表单//没了
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="AdminName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="AdminPwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					class="STYLE3" value="Log in" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: blue">${msg}</span></td>
			</tr>
		</table>
	</form>



</body>
</html>
