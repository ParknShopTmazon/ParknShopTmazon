<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<style type="text/css">
	*{
		margin:5px 5px
	}
	</style>
</head>
<body>
	<form action="../IncomeServlet" method="post">
	<table border="0" align="center" class="STYLE3">
	<tr><h1>Caculate income from Sales<h1><tr>
	<tr>
		<td>Input the time from(xxxx-xx-xx):<td>
		<td><input type="text" name="start" /> </td>
	<tr>	
	<tr>
		<td>to<td>
		<td><input type="text" name="end" /> </td>
	<tr>
	<tr>
		<td colspan="2" align="center">&nbsp;&nbsp;&nbsp;<input
					type="submit" value="Confirm" /></td>
	</tr>
	<tr>	
			<td> The whole sale money in this period is:$</td>
			<td colspan="2" align="center"><span style="color: blue">${msgM*Rate/100}</span></td>
			
	</tr>
	</table>
	</form>
	
	
	
</body>
</html>