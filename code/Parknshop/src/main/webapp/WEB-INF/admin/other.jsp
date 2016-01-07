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
		<link href="css/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script language="javascript" type="text/javascript" src="css/WdatePicker.js"></script>
	</head>
	<body>
		<%@ include file="header.html"%>
		<div class="other-container">
			<div id="content" class="container_16 clearfix">
			<form method="post">
				<div class="grid_4">
                		<p>
								<label for="title">Start Date:</label>
								<input name="start" class="Wdate" type="text" onClick="WdatePicker()">
                        </p>
				</div>
                <div class="grid_4">
                         <p>			
								<label for="post">End Date:</label>
								<input name="end" class="Wdate" type="text" onClick="WdatePicker()"> 
				         </p>
                </div>
                <div class="grid_2">	
                         <p>	
                         <label>&nbsp;</label>	
								<input type="submit" value="search" />
						</p>
                       
				</div>
			</form>
			<div class="grid_16">
				<label>Sales History</label>
					<table>
						<thead>
							<tr>
								<th>Picture</th>
								<th>Name</th>
								<th>Cost</th>
								<th colspan="2" width="10%">Actions</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="5" class="pagination">
									<span class="active curved">1</span><a href="#" class="curved">2</a><a href="#" class="curved">3</a><a href="#" class="curved">4</a> ... <a href="#" class="curved">10 million</a>
								</td>
							</tr>
							<tr>
								<td colspan="5" class="pagination" style="text-align:right">
									<span class="active curved">Total Income：1000458</span>
								</td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td><img src='css/food.png' height="30" width="30"></td>
								<td>Food</td>
								<td>1$</td>
								<td><a href="#" class="edit">Edit</a></td>
								<td><a href="#" class="delete">Delete</a></td>
								 
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="footer.html"%>
	</body>
</html>