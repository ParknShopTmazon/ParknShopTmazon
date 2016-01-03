<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.tmazon.domain.User,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Customer Management</title>
		<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<!--<link rel="stylesheet" href="css/fluid.css" type="text/css" media="screen" charset="utf-8" />-->
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
		
		
		</script>
	</head>
	<body>
		
		
		
		<ul id="navigation">
			<li><img src="css/logo.png"></li>
			<li><a href="overview">Overview</a></li>
			<li><span class="active">User Management</span></li>
			<li><a href="shopApply">Shop-Apply Management</a></li>
			<li><a href="advertisement">Advertisement Management</a></li>
			<li><a href="other">Other</a></li>
		</ul>
		<form method="post" action="searchUserAdmin">
			<div id="content" class="container_16 clearfix">
				<div class="grid_4">
					<p>
						<label>UserName:<small></small></label>
						<input name="UserName"  type="text" value="${sessionScope.searchInfo.name }" />
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Role:</label>
						
						<select name="select_role" 
								id ="select_role">
							<c:if test="${sessionScope.searchInfo.role eq '' || sessionScope.searchInfo.role eq null }">
							<option value="" selected="selected">---------</option>
							<option value="shop_owner">ShopOwner</option>
							<option value="customer">Customer</option>
							</c:if>
							<c:if test="${sessionScope.searchInfo.role eq 'shop_owner' }">
							<option value="" >---------</option>
							<option value="shop_owner" selected="selected">ShopOwner</option>
							<option value="customer">Customer</option>
							</c:if>
							<c:if test="${sessionScope.searchInfo.role eq 'customer' }">
							<option value="" >---------</option>
							<option value="shop_owner" >ShopOwner</option>
							<option value="customer" selected="selected">Customer</option>
							</c:if>
						</select>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<label>&nbsp;</label>
						<input   type="submit" value="Search" />
					</p>
				</div>
				<div class="grid_2">
					<p>
						<label>&nbsp;</label>
						<input type="reset" value="Reset" />
					</p>
				</div>
		</form>
 <!--		<form method="post" action="updateUTableServlet">   --> 
				<div class="grid_16">
					<table  >
						<thead>
							<tr>
								<th align="left">UserName</th>
								<th align="left">UserPassword</th>
								<th align="left">UserRole</th>
								<th colspan="3" width="10%">Actions</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="5" class="pagination">
									<span class="active curved">1</span><a href="#" class="curved">2</a><a href="#" class="curved">3</a><a href="#" class="curved">4</a> ... <a href="#" class="curved">10 million</a>
								</td>
							</tr>
						</tfoot>
						<tbody>
						<%-- show the user list --%>
					
						<c:forEach items="${sessionScope.userList}" var="user" >
							<tr>
								<td align="left">${ user.name }</td>
								<td align="left">${ user.password }</td>
								<td align="left">${ user.role }</td>
							
								
								<c:choose>
									<c:when test="${user.role eq 'admin' }">
									<td></td>
									<td></td>
									</c:when>
									<c:when test="${user.status eq 'normal' }">
									<form method="post" action="updateUTableServlet"> 	
										<td>
										<input type="hidden" name="status" value="delete"/>
										<input type="hidden" name="user_name" value="${user.name}"/>
										<input type="submit" value="  Delete  " ></input></td>
									</form>
									<form method="post" action="updateUTableServlet"> 
										
										<td>
										<input type="hidden" name="status" value="black"/>
										<input type="hidden" name="user_name" value="${user.name}"/>
										<input  type="submit" value="BlackList"></input></td>	
									</form>
									</c:when>
									<c:otherwise>
									<form method="post" action="updateUTableServlet"> 
										<td>
										<input type="hidden" name="status" value="normal"/>
										<input type="hidden" name="user_name" value="${user.name}"/>
											<input type="submit" value="Activate">
											</input>
										
										</td>
									</form>
									</c:otherwise>
								</c:choose>
							</tr>
						
						</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>
		
		<div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
		</div>
	</body>
</html>