<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PARKnSHOP</title>

<link type="text/css" href="css/Logindiv.css" rel="stylesheet" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
var login=0;
var customername="";
var Ajaxresult="";
var session_customer_name="${sessionScope.customername}";
$(document).ready(function() {
	
	pagestart();
	function pagestart(){
		$("#login_div1").hide();
		$("#div3").hide();
		cartcountAjax();
		if(session_customer_name!=""){
			customername=session_customer_name;
			$("#userName").text("hi,"+customername);
			$("#login").text("Log Out");
		}
	}
	
	$("#login").bind("click",function(){
		if(session_customer_name=="")
			logininstart();
		else
			logoutAjax();
	});
	$("#loginsubmit").bind("click",function(){
		login=0;
		checkloginname();
		checkloginpassword();
		if(login==0){
			loginAjax();
			//loginsuccess();
		}
	});
	
	function loginAjax(){
		Ajaxresult=null;
		customername=$("#loginusername").val();
		var password=$("#loginpassword").val();
		var logintype=$("input[name='typechoose']").val();
		$.ajax({
			type: "post",
			url: "UserLoginAjax?customername="+customername+"&password="+password+"&logintype="+logintype,
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				loginresult(result);
				cartcountAjax();
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {  
				alert("login false");
				//alert(errorThrown);    
			}    
		});
	}
	function logoutAjax(){
		Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "UserLogoutAjax",
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				logoutresult();
				cartcountAjax();
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				//alert(errorThrown);    
			}    
		});	
	}
	function cartcountAjax(){
		Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "CartCountAjax",
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				changecartcount(result);
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				//alert(errorThrown);    
			}    
		});	
	}
	
	$("#loginusername").bind("blur",function(){
		checkloginname();
	});
	
	$("#loginpassword").bind("blur",function(){
		checkloginpassword();
	});
	$("#login_registered").bind("click",function(){
       window.location.href="user_registered.html";
    });
	
	$("#loginclose").hover(function() {
		this.style.cursor = "pointer";
	});
	$("#loginclose").bind("click",function(){
		loginclose();
	});
	$("input[name='choose']").bind("click",function(){
		$("#typechoose").val(this.value);
	});
	
	
	$("#userName").bind("click",function(){
		if($("#session_customername").val()=="")
			alert("please login");
		else
			window.location.href="MyHomeServlet";
	});
	$("#head_myfavorite").bind("click",function(){
		if($("#session_customername").val()=="")
			alert("please login");
		else
			window.location.href="MyHomeServlet?divtype=2";
	});
	$("a[name='movetocart']").bind("click",function(){
		if($("#session_customername").val()=="")
			alert("please login");
		else
			window.location.href="ShoppingCartServlet";
	});
	$("#index_checkout").bind("click",function(){
		if($("#session_customername").val()=="")
			alert("please login");
		else
			window.location.href="ShoppingCartServlet";
	});
	$("#index_contact").bind("click",function(){
		window.location.href="ContactServlet";
	});
	$("#searchbutton").bind("click",function(){
		var str = $("#keyword").val();
		if(str.length == 0)
			$("#keyword").val("input is empty");
		else{
			if(str.length > 20)
				str = str.substring(0,20);
			window.location.href="SearchProductServlet?keyword="+str;
		}
	});
});

function logininstart(){
	var x=Math.round($("#enddiv").offset().left)+"px";
	var x2=Math.round($("#angle").offset().left)+"px";
	var y2=Math.round($("#angle").offset().top)+"px";
	$("#login_div2").css("left",x);
	$("#div3").css("width",x2);
	$("#div3").css("height",y2);
	$("#loginusername").val("");
	$("#loginpassword").val("");
	$("#loginerror1").hide();
	$("#loginerror2").hide();
	$("#login_div1").show();
	$("#div3").show();
};
function checkloginname(){
	var str=$("#loginusername").val();
	if(str.length>30){
		$("#loginerror1").text("input too long");
		$("#loginerror1").show(500);
		login++;
	} else
	if(str==""){
		$("#loginerror1").text("user name is empty");
		$("#loginerror1").show(500);
		login++;
	}
	else
		$("#loginerror1").hide(500);
}
function checkloginpassword(){
	var str=$("#loginpassword").val();
	if(str.length>30){
		$("#loginerror2").text("input too long");
		$("#loginerror2").show(500);
		login++;
	} else
	if(str==""){
		$("#loginerror2").text("password is empty");
		$("#loginerror2").show(500);
		login++;
	}
	else
		$("#loginerror2").hide(500);
}
function loginresult(result){
	if(result=="1"){
		var res=$("input[name='typechoose']").val();
		loginsuccess();
		session_customer_name=customername;
		if(res==1){
			$("#userName").text("hi,"+customername);
			$("#login").text("Log Out");
			$("#session_customername").val(customername);
		} 
		else if(res==2) {
			window.location.href="seller/index.jsp";
		} 
		else {
			window.location.href="AdminLoginServlet";
		}
	}
	else{
		alert("login false");
	}
}
function logoutresult(){
	session_customer_name="";
	customername="";
	$("#userName").text("My Home");
	$("#login").text("Log In");
	$("#session_customername").val("");
}
function changecartcount(result){
	$("#shopping_cart_count").text(result);
}
function loginsuccess(){
	loginclose();
}
function loginclose(){
	$("#login_div1").hide();
	$("#div3").hide();
}
</script>
<script src="js/account.js" type="text/javascript"></script>
</head>
<body>

	<input id="session_customername" type="hidden"
		value="${sessionScope.customername}" />
	<input id="Account_Balance" type="hidden" value="" />
	<div id="login_div1" class="loginin_div1" style="display: none">
		<div id="login_div2" class="loginin_div2">
			<div align="right">
				<img id="loginclose" src="images/false.png" width="20px"
					height="20px" />
			</div>
			<div style="padding-top: 10px; padding-bottom: 10px">
				<font size="+3" color="#CCCCCC" style="font-weight: 900">Log
					In</font>
			</div>
			<table width="500px" height="100px" class="logintable">
				<tr>
					<td width="120">user name:</td>
					<td width="260"><input id="loginusername" type="text" />
						<div style="width: 260px;" align="center">
							<font id="loginerror1" style="display: none; color: red">abc</font>
						</div></td>
					<td width="20"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input id="loginpassword" type="password" />
						<div style="width: 260px;" align="center">
							<font id="loginerror2" style="display: none; color: red">abc</font>
						</div></td>
				</tr>
			</table>
			<div style="padding-top: 10px; padding-bottom: 15px;">
				<div>
					<input id="loginsubmit" type="button" value="submit"
						style="width: 95px; color: #FFFFFF; font-size: 20px; background: #0033FF;" />
					<input id="" type="checkbox" value="" style="margin-left: 30px" /><font
						size="+1" color="#0011E1">Auto login next time</font>
				</div>
			</div>

			<div>
				<div style="float: right; padding-right: 100px; padding-top: 0px;">
					<a id="login_registered" style="color: #FF6600"
						href="user_registered.jsp">Instantly Registered</a>
				</div>
				<div align="left" style="padding-bottom: 20px; padding-left: 95px;">
					<input type="hidden" name="typechoose" id="typechoose" value="1" />
					<input type="radio" checked="checked" name="choose" value="1" /> <font
						color="#0099FF">User Login</font><br> <input type="radio"
						name="choose" value="2" /> <font color="#0099FF">Shopowner
						Login</font><br> <input type="radio" name="choose" value="3" /> <font
						color="#0099FF">Administrator Login</font>



				</div>
			</div>

		</div>
	</div>
	<div id="div3" style="display: none" class="loginin_div3"></div>

</body>
</html>