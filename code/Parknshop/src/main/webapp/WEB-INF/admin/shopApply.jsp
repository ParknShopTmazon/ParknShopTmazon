<%@ page language="java" import="java.util.*,com.tmazon.domain.Shop"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Customer Management</title>
<link rel="stylesheet" href="css/960.css" type="text/css" media="screen"
	charset="utf-8" />
<!--<link rel="stylesheet" href="css/fluid.css" type="text/css" media="screen" charset="utf-8" />-->
<link rel="stylesheet" href="css/template.css" type="text/css"
	media="screen" charset="utf-8" />
<link rel="stylesheet" href="css/colour.css" type="text/css"
	media="screen" charset="utf-8" />
</head>
<body>
	<%@ include file="header.html"%>
	<div class="shop-apply-container">
		<div id="content" class="container_16 clearfix">
			<div class="grid_4">
				<p>
					<label>Shop_ID</label> <input type="text" value="all" />
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label>Name</label> <input type="text" value="all" />
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label>Type</label> <input type="text" value="all" />
				</p>
			</div>
			<div class="grid_2">
				<p>
					<label>&nbsp;</label> <input type="submit" value="Search" />
				</p>
			</div>

			<div class="grid_16">
				<table>
					<thead>
						<tr>
							<th>Shop_ID</th>
							<th>Name</th>
							<th>Shop_Owner</th>
							<th>Type</th>
							<th colspan="3" width="10%">Actions</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="5" class="pagination"><span
								class="active curved">1</span><a href="#" class="curved">2</a><a
								href="#" class="curved">3</a><a href="#" class="curved">4</a> ...
								<a href="#" class="curved">10 million</a></td>
						</tr>
					</tfoot>
					<tbody>

					<c:forEach items="${ shopList }" var="shop">
						<tr>
							<td>${shop.shopId }</td>
							<td>${shop.name }</td>
							<td>${shop.owner }</td>
							<td>${shop.type }</td>
							<td><a href="javascript: void(0);" class="delete"
								type="agree">agree</a></td>
							<td><a href="javascript: void(0);" class="delete"
								type="disagree">disagree</a></td>
						</tr>
					</c:forEach>
					</tbody>
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

												var url = $(this).attr('type') == 'agree' ? 'AgreeServlet'
														: 'DisagreeServlet';
												var sid = $(this).attr('type') == 'agree' ? $(
														this).parent().prev()
														.prev().prev().html()
														: $(this).parent()
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
	</script>
</body>
</html>