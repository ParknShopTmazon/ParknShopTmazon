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
	font-size: 22px;
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
<script type="text/javascript">
    <!--  
      function submit1(){           
        this.form1.action="ADsServlet?Type=2";
      this.form1.enctype="multipart/form-data";
      this.form1.submit(); 
       }

      function submit2(){  
     	 var url=document.getElementById("URL").value;         
       this.form2.action="ADsServlet?Type=3&URL="+url+"";
      this.form2.enctype="multipart/form-data";
      this.form2.submit(); 
       }
       
       function submit3(){ 
       
     var ProductID=document.getElementById("ProductID").value;      
       this.form3.action="ADsServlet?Type=1&ProductID="+ProductID+"";
      this.form3.enctype="multipart/form-data";
      this.form3.submit(); 
       }
    -->  
</script>

<base href="<%=basePath%>">
<title>AddADs</title>
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

	<p align="center" class="STYLE2">For Products</p>
	<!--商品广告  -->
	<form method="post" name="form3">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td align="center">Upload the picture:</td>
				<td><input name="uoloadfile" type="FILE" id="uploadfile"></td>
			</tr>
			<tr>
				<td align="center">Input the productID:</td>
				<td><input type="text" id="ProductID" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" class="STYLE3" onclick="submit3()"
					value="Confirm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: blue">${msg1}</span></td>
			</tr>
		</table>
	</form>


	<p align="center" class="STYLE2">Only For Pictures</p>
	<!-- 图片广告 -->
	<form method="post" name="form1">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td align="center">Upload the picture:</td>
				<td><input name="uploadfile" type="FILE" id="uploadfile"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" class="STYLE3" onclick="submit1()"
					value="Confirm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: blue">${msg2}</span></td>
			</tr>
		</table>
	</form>




	<p align="center" class="STYLE2">For special links</p>
	<!-- 外链广告 -->
	<form method="post" name="form2">
		<table border="0" align="center" class="STYLE3">
			<tr>
				<td align="center">Upload the picture:</td>
				<td><input name="uoloadfile" type="FILE" id="uploadfile"></td>
			</tr>
			<tr>
				<td align="center">Input the url:</td>
				<td><input type="text" id="URL" name="URL" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" class="STYLE3" onclick="submit2()"
					value="Confirm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span style="color: blue">${msg3}</span></td>
			</tr>
		</table>
	</form>

</body>
</html>
