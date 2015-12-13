<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.seller.vo.*,com.seller.servlet.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>cangku</title>
<style type="text/css">
body {
	margin: 0 auto;
	padding-top: 10px;
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 12px;
}

.input1 {
	width: 150px;
	height: 20px;
}

.input2 {
	width: 80px;
	height: 20px;
	border: 1px #999 dashed;
	background-color: #333;
	color: #fff
}

.input3 {
	width: 250px;
	height: 100px;
}
</style>

<%
		     Shopinfo si=new Shopinfo();
		    if(session.getAttribute("shopinfo")==null)
		    {
		        //刚刚登陆
		    	si=(Shopinfo)request.getAttribute("shopinfo");
		    	session.setAttribute("shopinfo",si);
		    }
		    else
		    {
		    	si=(Shopinfo)session.getAttribute("shopinfo");
		    } 
		    /* Shopinfo si=(Shopinfo)session.getAttribute("shopinfo");
		    if(si==null)
		    {
		    	si=new Shopinfo();
		    	session.setAttribute("shopinfo", si);
		    } */
	%>
<script language="javascript">
	function cmp_stock(oEvent)
	{
		var e=event || oEvent;
		 if(e.keyCode>95 && e.keyCode<106)
		 {
		 	return true;
         }
         return false;
	}
	function check()
	{

	  // var typeId=document.form1.typeId.value;
	  var typeid=document.getElementById("typeId").value;
	  var productname=document.getElementById("productName").value;
	  var stock=document.getElementById("stock").value;
	  var price=document.getElementById("price").value;
	  var description=document.getElementById("description").value;
      var shopid=document.getElementById("hide").value;
      if(productname==null || productname=="")
      {
      	alert("Please fill in the information");
      	return ;
      }
      if(stock==null || stock=="")
      {
      	alert("Please fill in the information");
      	return ;
      }
      if(price==null || price=="")
      {
      	alert("Please fill in the information");
      	return ;
      }
      this.form1.action="../servlet/AddproductServlet?sid="+shopid+"&typeId="+typeid+"&productName="+productname+"&stock="+stock+"&price="+price+"&description="+description;
      this.form1.enctype="multipart/form-data";
      this.form1.submit();
	}
	</script>


</head>

<body bgcolor="#EEF2FB">
	<div align="center">
		<form name="form1" method="post">

			<h1 style="color: #333333; font-size: 20px">Add new commodities</h1>

			<table>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">CommodityType：</td>
					<td><select name="typeId" id="typeId">
							<option value="1" selected>dress</option>
							<option value="2">shoes</option>
							<option value="3">bags</option>
							<option value="4">underwear</option>
							<option value="5">outdoor</option>
							<option value="6">Fitness equipment</option>
							<option value="7">Snacks</option>
							<option value="8">care</option>
							<option value="9">alcohol</option>
							<option value="10">drink</option>
							<option value="11">phone</option>
							<option value="12">Camera</option>
							<option value="13">Computer</option>
							<option value="14">Skin care</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">CommodityName：</td>
					<td><input name="productName" type="text" class="input1"
						id="productName" size="20" maxlength="30"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">stock：</td>
					<td><input name="stock" type="text" class="input1" id="stock"
						size="20" maxlength="11"
						onkeyup="this.value=this.value.replace(/\D/g,'')"
						onblur="this.value=this.value.replace(/\D/g,'')"
						onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">price：</td>
					<td><input name="price" type="text" class="input1" id="price"
						size="20" maxlength="12"
						onkeyup="if(isNaN(value))execCommand('undo')"
						onafterpaste="if(isNaN(value))execCommand('undo')"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">Commodity
						Description:</td>
					<td><textarea style="resize: none;" rows="4" cols="30"
							name="description" id="description" maxlength="100"></textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" style="color: #333333; font-size: 18px">Image:</td>
					<td><input type="file" name="uploadfile" id="uploadfile"></td>
				</tr>

			</table>
			<br /> <input name="sub" type="button" onclick="check()"
				class="input2" value="add">&nbsp;&nbsp; <input name="res"
				type="reset" class="input2" value="reset">&nbsp;&nbsp; <input
				type="button" name="btn2" value="back"
				onClick="window.history.go(-1)" class="input2"> <input
				type="hidden" name="hide" id="hide" value="<%=si.getShopinfoid()%>">


		</form>
	</div>
</body>
</html>
