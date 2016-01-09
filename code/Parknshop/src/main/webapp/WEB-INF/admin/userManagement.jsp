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
	</head>
	<body>
	<!--<script type="text/javascript">
			document.getElemntById('select_role')
		</script>  -->	
		<%@ include file="header.html"%>
		<div class="user-container">
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
								<c:if test="${searchInfo.role eq '' || sessionScope.searchInfo.role eq null }">
								<option value="" selected="selected">---------</option>
								<option value="shop_owner">ShopOwner</option>
								<option value="customer">Customer</option>
								</c:if>
								<c:if test="${searchInfo.role eq 'shop_owner' }">
								<option value="" >---------</option>
								<option value="shop_owner" selected="selected">ShopOwner</option>
								<option value="customer">Customer</option>
								</c:if>
								<c:if test="${searchInfo.role eq 'customer' }">
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
			</form>
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
							<td colspan="3" rowspan="2" class="pagination">
							  
							<form method="post" action="searchUserAdmin">
									<input id="prev-btn" type="submit"  value="<<"></input>
									<span name="curIndex" class="active curved">${curPage }</span>
									<input id="next-btn" type="submit" value=">>"></input>
									<input name="UserName"  type="hidden" value="${searchInfo.name }" />
									<input name="select_role"  type="hidden" value="${searchInfo.role }" />
									<input name="curPage"  type="hidden" value="${curPage }" />
									<input type="hidden" id="next-val" name="next" value="1"/>
							</form>
						</td>
						</tr>
					
					</tfoot>
					<tbody>
					<%-- show the user list --%>
				
					<c:forEach items="${userList}" var="user" >
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
									<input type="hidden" name="Page" value="${sessionScope.curPage }"/>
									<input type="hidden" name="status" value="black"/>
									<input type="hidden" name="user_name" value="${user.name}"/>
									<input  type="submit" value="BlackList"></input></td>	
								</form>
								</c:when>
								<c:when test="${user.role eq 'shop_owner' && user.status eq 'checking' }">
								</c:when>
								<c:otherwise>
								<form method="post" action="updateUTableServlet"> 
									<td>
									<input type="hidden" name="Page" value="${sessionScope.curPage }"/>
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
		<%@ include file="footer.html"%>
	<script type="text/javascript">
		document.getElementById('next-btn').addEventListener('click', function() {
			document.getElementById('next-val').setAttribute('value', 1);
		});
		
		document.getElementById('prev-btn').addEventListener('click', function() {
			document.getElementById('next-val').setAttribute('value', -1);
		});
	</script>
	</body>
</html>