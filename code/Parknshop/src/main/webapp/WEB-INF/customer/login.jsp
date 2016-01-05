<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">

</head>
<body>
	<%@ include file="header.html"%>
	<div class="login-container">
		<div class="page-title">
		    <span class="back-btn button"></span>
		    <span class="parknshop">PARKnSHOP</span>
		    <span class="main-title">Login</span>
		</div>
		<div class="login-area">
			<form class="form-horizontal" action="login" method="post">
				<div class="control-group">
					<label class="control-label" for="inputEmail">USERNAME</label>
					<div class="controls">
						<input id="inputEmail" type="text" name="name" value="${ param.name }" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">PASSWORD</label>
					<div class="controls">
						<input id="inputPassword" type="password" name="password" value="${ param.password }" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<a href="register">register?</a>
						<button type="submit" class="btn-warning">login</button>
					</div>
				</div>

				<div class="control-group" align="center">
					<c:if test="${ not empty r_error_name_password }">
						<label style="color: red;">error name or password</label>
					</c:if>
					<c:if test="${ not empty r_error_parameters }">
						<label style="color: red;">6-20 characters for name and password only</label>
					</c:if>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			customer.init();
		});
	</script>
</body>
</html>