<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'modify_product.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
	    String id=request.getParameter("modify_id");
	    String name=request.getParameter("modify_name");
	    String type=request.getParameter("modify_type");
	    String desc=request.getParameter("modify_desc");
		String price=request.getParameter("modify_price");
		String stock=request.getParameter("modify_stock");
	 %>

<script language="javascript">
	  function confirm(a)
	  {
	      var mp=document.mf.pprice.value;
	      var ms=document.mf.pstock.value;
	      if(mp && ms)
	      {
	        this.mf.method="post";
	        this.mf.action="servlet/ModifyProductServlet?mid="+arguments[0]+"&mprice="+mp+"&mstock="+ms;
	        this.mf.submit();
	      }
	      else
	      {
	      	alert("Please fill in the information!");
	      }
	  }
	</script>

</head>

<body bgcolor="#EEF2FB">
	&nbsp;

	<form name="mf">
		<img src="<%=request.getParameter("modify_img") %>" width="200px"
			height="200px" style="margin-left: 420px">
		<table align="center">
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">ProductId:</td>
				<td><%=id%></td>
			</tr>
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">ProductName:</td>
				<td><%=name%></td>
			</tr>
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">ProductType:</td>
				<td><%=type%></td>
			</tr>
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">Description:</td>
				<td><textarea style="resize: none;" rows="4" cols="30"
						name="description" id="description" maxlength="100" readonly><%=desc%></textarea></td>
			</tr>
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">Price:</td>
				<td><input type="text" name="pprice" value="<%=price%>"
					onfocus="if(value==<%=price%>) {value=''}" maxlength="12"
					onkeyup="if(isNaN(value))execCommand('undo')"
					onafterpaste="if(isNaN(value))execCommand('undo')"></td>
			</tr>
			<tr>
				<td align="right" style="color: #333333; font-size: 18px">Stock:</td>
				<td><input type="text" name="pstock" value="<%=stock%>"
					onfocus="if(value==<%=stock%>) {value=''}" maxlength="11"
					onkeyup="this.value=this.value.replace(/\D/g,'')"
					onblur="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
			</tr>

		</table>
		<input type="button" value="submit" onclick="confirm(<%=id%>)"
			style="margin-left: 500px; color: #333333; font-size: 18px">
	</form>
</body>
</html>
