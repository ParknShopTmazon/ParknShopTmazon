<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Registered</title>
<style>
.mainbody {
	text-align: center;
	background: url(images/templatemo_body.jpg);
}

.headbody {
	text-align: center;
	background-color: #0099ff;
}

.content {
	width: 960px;
	margin-top: 6px;
	margin-right: auto;
	margin-bottom: 6px;
	margin-left: auto;
}

.content_body {
	text-align: center;
	background-color: #f6f6f6;
	width: 956px;
	padding-top: 30px;
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
	border-color: #ffffff;
	border-width: 2px;
	border-style: solid;
}

.content_table {
	width: 830px;
	height: 200px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 20px;
	margin-left: auto;
}

.maintable {
	text-align: left;
	border-bottom: none;
	font-size: 16px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}

.maintable input {
	width: 100%;
	height: 90%;
	padding-top: 1px;
	padding-bottom: 1px;
	font-size: 18px;
}

.templatemo_footer {
	width: 920px;
	text-align: center;
	padding: 9px 19px;
	background: #ffffff;
	border: 1px solid #0012ff;
	font-size: 14px;
}

.templatemo_footer p a {
	color: #999999;
	text-decoration: none;
}

.templatemo_footer b {
	font-size: 12;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}

.header_right {
	float: right;
	margin-top: 6px;
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 12px;
	line-height: 1.4em;
}

.header_right a {
	color: #08aee3;
	font-weight: normal;
	text-decoration: none;
}
</style>
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script>
var nameAjax="";
var i = 0;
var Ajaxresult="";

	$(document).ready(function() {

		$("#user_name").bind("blur", function() {
			checkusername();
		});
		$("#password_1").bind("blur", function() {
			checkpassword1();
			var str1 = $("#password_1").val();
			var str2 = $("#password_2").val();
			if(str1.length!=0 && str2.length!=0)
				checkpassword2();
		});
		$("#password_2").bind("blur", function() {
			checkpassword1();
			checkpassword2();
		});
		$("#checkimg").bind("blur", function() {
			checkimg();
		});
		
		$("#realname").bind("blur", function() {
			checkrealname();
		});
		$("#e_mail").bind("blur", function() {
			checkemail();
		});
		$("#phonenumber").bind("blur", function() {
			checkphonenumber();
		});
		$("#identityid").bind("blur", function() {
			checkidentityid();
		});

		$("img[name='logoimg']").hover(function() {
			this.style.cursor = "pointer";
		});
		$("img[name='logoimg']").bind("click", function() {
			window.location.href = "IndexServlet";
		});

		$("#button1").bind("click", function() {
			i = 0;
			checkusername();
			checkpassword1();
			checkpassword2();
			checkimg();
			if (i == 0) {
				$("#table_1").hide();
				$(this).hide();
				$("img[name='bigimg']").attr("src", "images/register_2.jpg");
				$("#table_2").show();
				$("#button2").show();
			}
		});

		$("#button2").bind("click", function() {
			i = 0;
			checkrealname();
			checkemail();
			checkphonenumber();
			checkidentityid();
			if (i == 0) {
				submitAjax();
				$("#finname").text($("#user_name").val());
				$("#table_2").hide();
				$(this).hide();
				$("img[name='bigimg']").attr("src", "images/register_3.jpg");
				$("#table_3").show();
			}
		});
		
	});
	
	function checknameAjax(str){
		Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "CheckNameAjax?name="+str,
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				nameAjax=result;
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				alert(errorThrown);    
			}    
		});	
	}
	
	function submitAjax(){
		var username = $("#user_name").val();
		var password = $("#password_1").val();
		var realname = $("#realname").val();
		var email = $("#e_mail").val();
		var phonenumber = $("#phonenumber").val();
		var identityid = $("#identityid").val();
		Ajaxresult=null;
		$.ajax({
			type: "post",
			url : "UserRegisteredAjax?username=" + username + "&password="
					+ password + "&realname=" + realname + "&email=" + email
					+ "&phonenumber=" + phonenumber + "&identityid=" + identityid,
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				Ajaxresult = eval("(" + data + ")");
				var result = Ajaxresult.result;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}

	function checkusername() {
		var str = $("#user_name").val();
		if (str.length == 0) {
			$("#error1").text("input is empty");
			$("#error1").show(500);
			i++;
		} else if (str.length > 30) {
			$("#error1").text("input is too long");
			$("#error1").show(500);
			i++;
		} else {
			checknameAjax(str);
			timedCount();
		}
	}
	function checkpassword1() {
		var str = $("#password_1").val();
		if (str.length == 0) {
			$("#error2").text("input is empty");
			$("#error2").show(500);
			i++;
		} else if (str.length > 20) {
			$("#error2").text("input is too long");
			$("#error2").show(500);
			i++;
		} else
			$("#error2").hide(500);
	}
	function checkpassword2() {
		var str1 = $("#password_1").val();
		var str2 = $("#password_2").val();
		if (str1 != str2) {
			$("#error3").text("confirm password is not correct");
			$("#error3").show(500);
			i++;
		} else
			$("#error3").hide(500);
	}
	function checkimg() {
		var str = $("#checkimg").val();
		if (str != "VTSK") {
			$("#error4").text("verification code is not correct");
			$("#error4").show(500);
			i++;
		} else
			$("#error4").hide(500);
	}
	function checkrealname() {
		var str = $("#realname").val();
		if (str.length == 0) {
			$("#error5").text("input is empty");
			$("#error5").show(500);
			i++;
		} else if (str.length > 20) {
			$("#error5").text("input is too long");
			$("#error5").show(500);
			i++;
		} else
			$("#error5").hide(500);
	}
	function checkemail() {
		var str = $("#e_mail").val();
		var patt1 = /[A-Za-z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+/m;
		var str1 = str.match(patt1);
		if (str.length == 0) {
			$("#error6").text("input is empty");
			$("#error6").show(500);
			i++;
		} else if (str1 == null || str1[0].length != str.length) {
			$("#error6").text("email address format is not correct");
			$("#error6").show(500);
			i++;
		} else if (str.length > 30) {
			$("#error6").text("input is too long");
			$("#error6").show(500);
			i++;
		} else {
			$("#error6").hide(500);
		}
	}
	function checkphonenumber() {
		var str = $("#phonenumber").val();
		var patt1 = /[0-9]+/m;
		var str1 = str.match(patt1);
		if (str.length == 0) {
			$("#error7").text("input is empty");
			$("#error7").show(500);
			i++;
		} else if (str1 == null || str1[0].length != str.length) {
			$("#error7").text("phonenumber format is not correct");
			$("#error7").show(500);
			i++;
		} else if (str.length > 30) {
			$("#error7").text("input is too long");
			$("#error7").show(500);
			i++;
		} else {
			$("#error7").hide(500);
		}
	}
	function checkidentityid() {
		var str = $("#identityid").val();
		var patt1 = /[0-9]+/m;
		var str1 = str.match(patt1);
		if (str.length == 0) {
			$("#error8").text("input is empty");
			$("#error8").show(500);
			i++;
		} else if (str1 == null || str1[0].length != str.length) {
			$("#error8").text("identityid format is not correct");
			$("#error8").show(500);
			i++;
		} else if (str.length > 30) {
			$("#error8").text("input is too long");
			$("#error8").show(500);
			i++;
		} else {
			$("#error8").hide(500);
		}
	}
	function timedCount() {
		var t = setTimeout("checknameajaxresult()", 1000);
	}
	function checknameajaxresult() {
		if (nameAjax == "1") {
			$("#error1").text("name already exists");
			$("#error1").show(500);
			i++;
		} else
			$("#error1").hide(500);
	}
</script>
</head>
<body
	style="padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; margin-top: 0px; margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">


	<div id="div1" class="mainbody" align="center">

		<div style="padding-top: 42px"></div>

		<div class="content">

			<div align="left">
				<table border="0" cellpadding="1" cellspacing="1">
					<tr>
						<td><img name="logoimg" src="images/templatemo_logo.png" /></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div
				style="background: url(images/templatemo_menu.jpg); width: 960px; height: 40px; margin-top: 8px;">
				<div align="center"
					style="background: url(images/templatemo_menu_hover.jpg); width: 340px; height: 33px; float: left; padding-top: 7px">
					<font color="#666666" size="+2" style="font-weight: bold;">User
						Registered</font>
				</div>
				<div align="center"
					style="display: none; width: 340px; height: 33px; float: left; padding-top: 7px">
					<font color="#666666" size="+2" style="font-weight: bold">Shopowner
						Registered</font>
				</div>
			</div>
			<img name="bigimg" src="images/register_1.jpg" width="960"
				style="padding-top: 1px" />
		</div>

		<div class="content_body">

			<div class="content_table">
				<table id="table_1" width="100%" height="200" border="0"
					cellpadding="0" cellspacing="5" class="maintable">
					<tr>
						<td width="25%">User Name</td>
						<td width="35%"><input id="user_name" type="text" /></td>
						<td width="40%"><div style="float: left; padding-left: 20px">
								<font id="error1" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input id="password_1" type="password" /></td>
						<td><div style="float: left; padding-left: 20px">
								<font id="error2" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>Confirm Password</td>
						<td><input id="password_2" type="password" /></td>
						<td><div style="float: left; padding-left: 20px">
								<font id="error3" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>Verification Code</td>
						<td><div style="float: left">
								<input id="checkimg" type="text"
									style="width: 120px; height: 30px;" />
							</div>
							<div style="float: left; padding-left: 5px; padding-top: 2px;">
								<img name="bigimg" src="images/checkimg.jpg" height="31px" />
							</div></td>
						<td>
							<div style="float: left; padding-left: 20px">
								<font id="error4" style="display: none" color="red"></font>
							</div>
						</td>
					</tr>
				</table>
				<table id="table_2" style="display: none" width="100%" height="200"
					border="0" cellpadding="0" cellspacing="5" class="maintable">
					<tr>
						<td width="25%">RealName</td>
						<td width="35%"><input id="realname" type="text" /></td>
						<td width="40%"><div style="float: left; padding-left: 20px">
								<font id="error5" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>E-mail For Applying</td>
						<td><input id="e_mail" type="text" /></td>
						<td><div style="float: left; padding-left: 20px">
								<font id="error6" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>PhoneNumber</td>
						<td><input id="phonenumber" type="text" /></td>
						<td><div style="float: left; padding-left: 20px">
								<font id="error7" style="display: none" color="red"></font>
							</div></td>
					</tr>
					<tr>
						<td>IdentityID</td>
						<td><input id="identityid" type="text" /></td>
						<td><div style="float: left; padding-left: 20px">
								<font id="error8" style="display: none" color="red"></font>
							</div></td>
					</tr>
				</table>
				<div id="table_3" align="center"
					style="display: none; padding-right: 200px">
					<br>
					<table>
						<tr>
							<td><img src="images/true.png" width="100" height="100" />&nbsp;</td>
							<td><font id="finname" size="+2" color="#0033FF"
								style="font-weight: bold"></font> <font size="+2"
								style="font-weight: bold"> , Registration is successful!</font></td>
						</tr>
					</table>
					<div>
						<br> <a id="gohomepage" href="IndexServlet">Go home page
							to have a look</a>
					</div>
				</div>
			</div>


			<div align="center"
				style="height: 60px; padding-top: 20px; padding-bottom: 30px;">
				<input id="button1" type="button" value="Approval and Registration"
					style="font-weight: bold; width: 200px; height: 45px; background-color: #FFCC00; color: #FFFFFF; border-color: #FF0000" />
				<input id="button2" type="button" value="Submission"
					style="display: none; font-weight: bold; width: 110px; height: 45px; background-color: #FFCC00; color: #FFFFFF; border-color: #FF0000" />
			</div>

		</div>

		<div align="center" style="padding-bottom: 40px; padding-top: 40px">

			<div class="templatemo_footer">
				<p>
					<a href="IndexServlet">Home</a> | <a href="NewProductsServlet">Products</a>
					| <a href="AboutUsServlet">About</a> | <a href="FaqsServlet">FAQs</a>
					| <a href="ContactServlet">Contact</a>
				</p>

				Copyright © 2014 &nbsp;&nbsp; <b>PARKnSHOP </b>
			</div>
			<!-- END of templatemo_footer -->
		</div>

	</div>
</body>
</html>