<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>search products</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">

</head>
<body>
<%@ include file="header.html"%>
<div class="container-fluid">
	<br>
	<form class="form-search">
		<input class="input-medium search-query" type="text" name="name" value="${param.name}"/>
		<select name="type" >
    		<c:if test="${param.type=='' ||empty param.type}">
    			<option value="" selected="selected">ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='TV& Home Theater'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater" selected="selected">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Computers & Tablets'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" selected="selected">Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Cell Phones'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" selected="selected">Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Cameras & Camcorders'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" selected="selected">Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Audio'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" selected="selected">Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Car Electronics & GPS'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" selected="selected" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Video, Games, Movies & Music'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" selected="selected">Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Health, Fitness & Sports'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music">Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports"  selected="selected">Health, Fitness & Sports</option>
    			<option value="Home & Office" >Home & Office</option>
    		</c:if>
    		<c:if test="${param.type=='Home & Office'}">
    			<option value="" >ALL</option>
    			<option value="TV& Home Theater">TV& Home Theater</option>
    			<option value="Computers & Tablets" >Computers & Tablets</option>
    			<option value="Cell Phones" >Cell Phones</option>
    			<option value="Cameras & Camcorders" >Cameras & Camcorders</option>
    			<option value="Audio" >Audio</option>
    			<option value="Car Electronics & GPS" >Car Electronics & GPS</option>
    			<option value="Video, Games, Movies & Music" >Video, Games, Movies & Music</option>
    			<option value="Health, Fitness & Sports" >Health, Fitness & Sports</option>
    			<option value="Home & Office" selected="selected">Home & Office</option>
    		</c:if>
      	</select>
		<button type="submit" class="btn-warning">search</button>
	</form>
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<h3>All Products</h3>
					<c:if test="${num == 0}">
						<p>not found</p>
					</c:if>
					<c:if test="${num >0}">
						<c:forEach var="product" items="${productList}" >
							<c:if test="${test%4==0 }">
								<div class="row-fluid">
							</c:if>
								<div class="span3">
									<a href="./productInfo?pid=${ product.productId }" ><img src="${ product.picture }" height="" width=""></a>
									<h4>${ product.price } dollar</h4>
									<h4>${ product.name }</h4>
								</div>
							<c:if test="${test%4==3 }"></div></c:if>
						</c:forEach>
					</c:if>
			</div>
		</div>
	</div>
	<c:if test="${num <=4 }">
		<div class="row-fluid" id = "foot"  style="position:absolute; bottom:0; left:0">
			<div class="span12">
				<h3>
					Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
				</h3>
			</div>
		</div>			
	</c:if>
	<c:if test="${num >4 }">
		<div class="row-fluid" id = "foot">
			<div class="span12">
				<h3>
					Copyright&reg;  2015-2015 PARKnSHOP All Rights Reserved.
				</h3>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>