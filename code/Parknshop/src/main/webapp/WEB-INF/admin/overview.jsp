<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%
    	String path=request.getContextPath();
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Steal My Admin</title>
		<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
		<!--[if IE]><![if gte IE 6]><![endif]-->
		<script src="js/glow/1.7.0/core/core.js" type="text/javascript"></script>
		<script src="js/glow/1.7.0/widgets/widgets.js" type="text/javascript"></script>
		<link href="js/glow/1.7.0/widgets/widgets.css" type="text/css" rel="stylesheet" />
		<style>
		table{font-size:20px;}
		</style>
		<script type="text/javascript">
			glow.ready(function(){
				new glow.widgets.Sortable(
					'#content .grid_5, #content .grid_6',
					{
						draggableOptions : {
							handle : 'h2'
						}
					}
				);
			});
		</script>
		<!--[if IE]><![endif]><![endif]-->
	</head>
	<body>
		<%@ include file="header.html"%>
		<br><br>
		<div class="overview-container">
			<div id="content" class="container_16 clearfix">
				<div class="grid_5">
					<div class="box">
						<h2>Database</h2>
						<div class="utils">
							<a href="#">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>DB</td>
									<td>MySQL</td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
					<div class="box">
						<h2>Advertisement</h2>
						<div class="utils">
							<a href="advertisement">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>total:</td>
									<td>${adNum }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
					
				<div class="grid_6">
					<div class="box">
						<h2>UserManagement</h2>
						<div class="utils">
							<a href="user">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>1.ShopOwner:</td>
									<td>${shopOwnerNumber}</td>
								</tr>
								<tr>
									<td>2.Customer:</td>
									<td>${customerNumber }</td>
								</tr>
							</tbody>

						</table>
					</div>
					<br>
					<div class="box">
						<h2>Shop-Apply</h2>
						<div class="utils">
							<a href="shopApply">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>Number:</td>
									<td>${shopApplyNum }</td>
								</tr>
							</tbody>
						</table>
					</div>
					
				</div>
				
				
				<div class="grid_5">
					<div class="box">
						<h2>Rate</h2>
						<form action="ModifyRateServlet" method="post">
						<table>
							<tbody>
								<tr>
									<td>Rate:</td>
									<td>${rate }%</td>
								</tr>
								<tr>
									<td><input type='text' name="rate" style="width:120px"/></td>
									<td>
										<div class="grid_2">
											<input type="submit"  value="Modify"/>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						</form>
					</div>
					
				 </div>
				</div>
			</div>
		</div>
		<%@ include file="footer.html"%>
	</body>
</html>