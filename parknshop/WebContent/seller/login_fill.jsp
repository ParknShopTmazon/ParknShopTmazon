<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login_fill.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#EEF2FB">

	<form action="servlet/SellerLoginServlet" method="post">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="SellerName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="SellerPwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					class="STYLE3" value="Log in" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: red">${requestScope.message}</span></td>
			</tr>
		</table>
	</form>

</body>
</html>
