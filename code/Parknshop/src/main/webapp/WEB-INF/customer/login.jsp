<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>login</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<div class="container-fluid">
	<div class="row-fluid" id="head">
		<div class="span4">
			<img src="images/logo.png">

		</div>
		<div class="span3"></div>
		<div class="span5"></div>
	</div>
	<div class="row-fluid">
		<div class="span4"></div>

		<div class="span4">
			<h2>Welcomt to PARKnSHOP</h2>
			</br> 
			<c:if test="${ not empty r_error_name_password }">
						<label style="color: red;">error name or password</label>
					</c:if>
					<c:if test="${ not empty r_error_parameters }">
						<label style="color: red;">no name or password</label>
					</c:if>
			</br>
			<form class="form-horizontal" action="login" method="post">
				<div class="control-group">
					<label class="control-label" for="inputEmail">USERNAME</label>
					<div class="controls">
						<input id="inputEmail" type="text" name="name" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">PASSWORD</label>
					<div class="controls">
						<input id="inputPassword" type="password" name="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox"><input type="checkbox" />
							customer</label> <label class="checkbox"><input type="checkbox" />
							seller</label> <a href="#">forget password?</a> <a href="#">regist</a></br>
						<button type="submit" class="btn-warning">login</button>
					</div>
				</div>
			</form>
		</div>
		<div class="span4"></div>
	</div>
	<div class="row-fluid" id="foot">
		<div class="span12">
			<h3>Copyright&reg; 2015-2015 PARKnSHOP All Rights Reserved.</h3>
		</div>
	</div>
</div>