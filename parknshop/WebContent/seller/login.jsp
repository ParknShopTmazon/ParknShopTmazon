<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<base href="<%=basePath%>">
<link href="seller/images/skin.css" rel="stylesheet" type="text/css">
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
-->
</style>

<title>Seller login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->



</head>


<body leftmargin="0" topmargin="0" bgcolor="#EEF2FB">
	<table width="100%" height="64" border="0" cellpadding="0"
		cellspacing="0" class="admin_topbg">
		<tr>
			<td width="61%" height="64"><img src="seller/images/logo.gif"
				width="262" height="64"></td>
			<td width="39%" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="50%" height="38" class="admin_txt">Welcome to you！</td>
					</tr>
					<tr>
						<td height="19" colspan="3">&nbsp;</td>
					</tr>
				</table></td>
	</table>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<form action="servlet/SellerLoginServlet" method="post">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="SellerName" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="SellerPwd" maxlength="20" /></td>
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
