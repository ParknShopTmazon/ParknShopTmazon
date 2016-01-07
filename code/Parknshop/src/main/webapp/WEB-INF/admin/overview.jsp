<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path=request.getContextPath();
    %>
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
								<tr>
									<td>Node Num</td>
									<td>50</td>
								</tr>
								<tr>
									<td>Backup</td>
									<td>2015.12.07-15:33:35</td>
								</tr>
								<tr>
									<td>Rate</td>
									<td><%=session.getAttribute("rate") %>%</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="box">
						<h2>Quick Post</h2>
						<div class="utils">
							<a href="#">Advanced</a>
						</div>
						<form action="#" method="post">
							<p>
								<label for="title">Title <small>Alpha-numeric characters only.</small> </label>
								<input type="text" name="title" />
							</p>
							<p>
								<label for="post">Post <small>Parsed by Markdown.</small> </label>
								<textarea name="post"></textarea>
							</p>
							<p>
								<input type="submit" value="post" />
							</p>
						</form>
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
									<td>1 Tom'Shop</td>
									<td>2 xxx'Shop</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="box">
						<h2>Shop-Apply</h2>
						<div class="utils">
							<a href="shopApply">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>1 Tom'Shop</td>
									<td>2 xxx'Shop</td>
								</tr>
							</tbody>
						</table>
					</div>
				
					
				</div>
				<div class="grid_5">
					<div class="box">
						<h2>Income</h2>
						<div class="utils">
							<a href="#">View More</a>
						</div>
						<table>
							<tbody>
								<tr>
									<td>Three months of income</td>
									<td>xxxx.xx$</td>
								</tr>
								<tr>
									<td>Shops num</td>
									<td>xxxxxx</td>
								</tr>
								<tr>
									<td>income</td>
									<td>xxxxxx$</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.html"%>
	</body>
</html>