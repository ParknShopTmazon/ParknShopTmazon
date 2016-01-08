<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<script language="javascript" type="text/javascript" src="css/WdatePicker.js"></script>
	</head>
	<body>
		<%@ include file="header.html"%>
		<div class="other-container">
			<div id="content" class="container_16 clearfix">
			<form method="post" action="searchHistoryAdminServlet">
				<div class="grid_4">
                		<p>
								<label for="title">Start Date:</label>
								<input name="start"  type="date">
                        </p>
				</div>
                <div class="grid_4">
                         <p>			
								<label for="post">End Date:</label>
								<input name="end"  type="date" > 
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
				<label>Sales History:</label>
					<table>
						<thead>
							<tr>
								<th>ProductName</th>
								<th>ShopName</th>
								<th>BuyerName</th>
								<th>Quantity</th>
								<th>Cost</th>
								<th>Time</th>
							</tr>
						</thead>
						<tfoot>
							<form method="get" action="searchHistoryAdminServlet">
								<td colspan="5" rowspan="1"  class="pagination">
									<input id="prev-btn" type="submit"  value="<<"></input>
									<span name="curIndex" class="active curved">${CurPage }</span>
									<input id="next-btn" type="submit" value=">>"></input>
									<input type="hidden" id="next-val" name="next" value="1"/>
								</td>
							</form>
							<tr>
								<td colspan="5" class="pagination" style="text-align:right">
									<span class="active curved">Total Income：${Income }</span>
								</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${historyList }" var="history">
								<tr>
									<td>${history.product.name}</td>
									<td>${history.shop.name}</td>
									<td>${history.user.name}</td>
									<td>${history.orderInfo.quantity}</td>
									<td>${history.cost}</td>
									<td>${history.dealTime}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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