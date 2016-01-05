<%@ page language="java" import="java.util.* ,com.tmazon.domain.Advertisement" pageEncoding="UTF-8"%>
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
		<%@ include file="header.html"%>
		<div class="ad-container">
			<div id="content" class="container_16 clearfix">

			  <form action="AddAdvertisementServlet" method="post">
				<div class="grid_4">
					<p>
						<label>Product_ID</label>
						<input type='text' name="productID" value=""/>
					</p>
				</div>
			
				<div class="grid_4">
					<p>
						<label>Cost</label>
						<input type='text' name="cost" value=""/>
					</p>
				</div>
				<div class="grid_4">
					<p>
						<label>&nbsp;</label>
						<input type="submit" value="Add" />
					</p>
				</div>
			  </form>

				<div class="grid_16">
					<table>
						<thead>
							<tr>
								<th>AD_ID</th>
								<th>Product_ID</th>
								<th>Cost</th>
								<th colspan="3" width="10%">Actions</th>
							</tr>
						</thead>
						
						<tbody>
							<%
								if (session.getAttribute("showAd") != null) {
									List<Advertisement> ls = (List<Advertisement>) session.getAttribute("showAd");
									if (ls.size() > 0) {
										for (Advertisement s : ls) {
							%>
							<tr>
								<td><%=s.getAdId()%></td>
								<td><%=s.getProductID()%></td>
								<td><input type='text' class="grid_4"  value=<%=s.getCost() %> ></td>
								<td><a href="javascript: void(0);" class="edit">Modify</a></td>
								<td><a href="javascript: void(0);" class="delete" type="del">Delete</a></td>	
							</tr>
							<%
								}
									}
								}
							%>
						</tbody>

						<tfoot>
							<tr>
								<td colspan="5" class="pagination">
									<span class="active curved">1</span><a href="#" class="curved">2</a><a href="#" class="curved">3</a><a href="#" class="curved">4</a> ... <a href="#" class="curved">10 million</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>		
		<%@ include file="footer.html"%>
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
			$(document)
				.ready(
						function() {
							$('.grid_16 .delete')
									.click(
											function() {
												$(this).parent().parent()
														.hide();

													var url = 'DeleteAdvServlet';
													var sid = $(this).parent()
																.prev().prev()
																.prev().prev()
																.html();

											$.ajax({
													url : url,
													type : 'POST',
													data : {
														sid : sid
													},
													dataType : 'json'
												}).done(function() {
													console.log('success');
												}).fail(function() {
													console.log('error');
												});
											});
						});
			$(document)
			.ready(
					function() {
						$('.grid_16 .edit')
								.click(
										function() {
											var url = 'ModifyAdvServlet';
											var advId = $(this).parent()
															.prev().prev()
															.prev()
															.html(); 
											var cost = $(this).parent()
															.prev().children().val();
										$.ajax({
												url : url,
												type : 'POST',
												data : {
													advId : advId ,
													cost : cost
												},
												dataType : 'json'
											}).done(function() {
												console.log('success');
											}).fail(function() {
												console.log('error');
											});alert("修改成功");
										});
					});

	</script>
	</body>
</html>