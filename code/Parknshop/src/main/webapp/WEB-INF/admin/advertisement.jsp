<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
		
					
		
		<ul id="navigation">
			<li><img src="css/logo.png"></li>
			<li><a href="overview.html">Overview</a></li>
			<li><a href="user.html">User Management</a></li>
			<li><a href="shopApply.html">Shop-Apply Management</a></li>
			<li><span class="active">Advertisement Management</span></li>
			<li><a href="other.html">Other</a></li>
		</ul>
		
			<div id="content" class="container_16 clearfix">
				<div class="grid_4">
					<p>
						<label>Cost</label>
						<select>
							<option>ALL</option>
							<option>0-99</option>
							<option>100-999</option>
							<option>1000-9999</option>
						</select>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Company</label>
						<select>
							<option>ALL</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
						</select>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Type</label>
						<select>
							<option>ALL</option>
							<option>Food</option>
							<option>Clothes</option>
							<option>Book</option>
						</select>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<label>&nbsp;</label>
						<input type="submit" value="Search" />
					</p>
				</div>
				<div class="grid_16">
					<table>
						<thead>
							<tr>
								<th>Company</th>
								<th>Type</th>
								<th>Cost</th>
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
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>	
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		
		<div id="foot">
			Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
		</div>
	</body>
</html>
