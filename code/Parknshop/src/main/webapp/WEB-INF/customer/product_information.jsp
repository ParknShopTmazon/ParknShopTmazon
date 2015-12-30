<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>product information</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">
<script text="text/javascript">

</script>
</head>
<div class="container-fluid">
	<%@ include file="header.html"%>
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span4">
					<img src="${ product.picture }">
				</div>
				<div class="span8">
					<p>
						Introduction of products
					</p>
					<table class="table">
						<thead>
							<tr>
								<th>
									price:
								</th>
								<th>
									${ product.price }
								</th>								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									discount price:
								</td>
								<td>
									${ product.discountPrice }
								</td>								
							</tr>
							<tr>
								<td>
									Sales volume
								</td>
								<td>
									${ product.soldNum }
								</td>								
							</tr>
							<tr>
								<td>
									remaining
								</td>
								<td>
									${ product.stockNum }
								</td>								
							</tr>
						</tbody>
					</table>
					<c:if test="${ not expired }">
						<form>
							<fieldset>
								 <input type="hidden" name="pid" value="${ product.productId }" />
								 <c:if test="${ not isExists }">
									 <input name="quantity" type="text" value="1"/> 
									 <span id="quantity" class="help-block">Quantity</span>
									 <button class="btn-warning">Add to cart</button> 	
								</c:if>
								<c:if test="${ isExists }">
									 <span class="help-block">Already in cart</span>
								</c:if>
							</fieldset>
						</form>
					</c:if>
					<c:if test="${ expired }">
						<p><span style="color:red;">Expired</span></p>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<h3>
				Product introduction 
			</h3>
			<p>
				${ product.description }
			</p>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<table class="table">
				<thead>
					<tr>
						<h3>
							Product comments
						</h3>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>					
					</tr>
					<tr>
						<td>
							1
						</td>						
					</tr>
					<tr>
						<td>
							2
						</td>						
					</tr>
					<tr>
						<td>
							3
						</td>					
					</tr>
					<tr>
						<td>
							4
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="footer.html"%>
</div>