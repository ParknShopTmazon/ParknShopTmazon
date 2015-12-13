<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>意见反馈</title>

</head>
<body leftmargin="8" topmargin="8" marginwidth="0" marginheight="0"
	scroll="auto">
	<table width="100%" border="0">

		<tr>
			<td>
				<hr size="1" color="#DADADA">
			</td>
		</tr>
		<tr>
			<td align="center">
				<!-- //TODO 根据后台需要修改控件名称，和生成控件数据 -->
				<center>
					<form action="" method="post">
						<table bgcolor="#B3B3FF">
							<tr>
								<td>content:</td>
								<td><textarea name="content" rows="10" cols="40"></textarea></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><div align="right">
										<input name="submit" type="submit" value="提交">
									</div></td>
							</tr>
						</table>
					</form>
				</center>