<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
			<li><a href="overview">Overview</a></li>
			<li><span class="active">User Management</span></li>
			<li><a href="shopApply">Shop-Apply Management</a></li>
			<li><a href="advertisement">Advertisement Management</a></li>
			<li><a href="other">Other</a></li>
		</ul>
		
			<div id="content" class="container_16 clearfix">
				<div class="grid_4">
					<p>
						<label>Username<small>Alpha-numeric values</small></label>
						<input type="text" value="all"/>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>NickName</label>
						<input type="text" value="all"/>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Type</label>
						<select>
							<option>Shop-Owner</option>
							<option>Customer</option>
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
								<th>Username</th>
								<th>E-mail</th>
								<th>Address</th>
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
								<td>Philip</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>	
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Thomas</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Ben</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Richard</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Alon</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Alex</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Nathan</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Habib</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Jeremy</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Ed</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Claire</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Philip</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr class="alt">
								<td>Thomas</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">BlackList</a></td>
							</tr>
							<tr>
								<td>Ben</td>
								<td>xxxxxxxxx@qq.com</td>
								<td>Xi'an</td>
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