<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>register</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">

</head>
<body>
	<%@ include file="header.html"%>
	<div class="row-fluid">
		<div class="span4"></div>

		<div class="span4">
			<h2>Please Register</h2>
			<br /> <br />
			<form class="form-horizontal" action="register" method="post">
				<div class="control-group">
					<label class="control-label" for="input1">USERNAME</label>
					<div class="controls">
						<input id="input1" type="text" name="name" value="${ param.name }" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input2">PASSWORD</label>
					<div class="controls">
						<input id="input2" type="password" name="password" value="${ param.password }"
							autoComplete="off" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input3">CONFIRM PASSWORD</label>
					<div class="controls">
						<input id="input3" type="password" />
					</div>
				</div>

				<!-- 
				<div class="control-group">
					 <label class="control-label" for="inputPassword">SEX</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">BIRTHDAY</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">TELEPHONE</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">ADDRESS</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">EMAIL</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				 -->

				<div class="control-group">
					<div class="controls">
						<!-- <label class="checkbox"><input type="checkbox" />
							customer</label> <label class="checkbox"><input type="checkbox" />
							seller</label>
 						-->
						<br />
						<button type="submit" class="btn-warning">submit</button>
					</div>
				</div>

				<div class="control-group" align="center">
					<c:if test="${ not empty r_error_user_exists }">
						<label style="color: red;">user name already exists</label>
					</c:if>
					<c:if test="${ not empty r_error_parameters }">
						<label style="color: red;">6-20 characters for name and password only</label>
					</c:if>
					<c:if test="${ not empty r_is_register_success }">
						<c:choose>
							<c:when test="${ r_is_register_success }">
								<label style="color: red;">register success!<a
									href="login" style="color: blue;">click here to log-in</a></label>
							</c:when>
							<c:otherwise>
								<label style="color: red;">register failed</label>
							</c:otherwise>
						</c:choose>
					</c:if>
				</div>
			</form>

		</div>
		<div class="span4"></div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>