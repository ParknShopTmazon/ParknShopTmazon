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

a:link {
	text-decoration: underline;
}

.STYLE3 {
	font-size: 16px;
	font-weight: bold;
}
-->
</style>

<base href="<%=basePath%>">
<title>ChangeCommissionRate</title>
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
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p align="center" class="STYLE3" style="color: red">Please input a
		number between 0 and 100.</p>
	<form action="RateServlet" method="post">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td>Current Commission Rate:</td>
				<td>${Rate}%</td>
			</tr>
			<tr>
				<td>New Rate:</td>
				<td><input type="text" name="NewRate" /> %</td>
			</tr>
			<tr>
				<td colspan="2" align="center">&nbsp;&nbsp;&nbsp;<input
					type="submit" class="STYLE3" value="Confirm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: blue">${msg}</span></td>
			</tr>
		</table>
	</form>



</body>
</html>
