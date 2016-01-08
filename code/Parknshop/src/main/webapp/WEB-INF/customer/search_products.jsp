<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>search products</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/customer.css">

</head>
<body>
	<%@ include file="header.html"%>
	<c:if test="${ not empty s_user and s_user.role ne 'admin'}">
		<%@ include file="dialog.html"%>
	</c:if>
	<div class="search-container">
		<div class="page-title">
			<span class="back-btn button"></span>
		    <span class="parknshop">PARKnSHOP</span>
		    <span class="main-title">Search</span>
		</div>
		<form class="form-search">
			<input class="input-medium search-query" type="text" name="name" value="${param.name}" placeholder="Search..."/>
			<select name="searchMethod" class="select" id="searchMethod">
				<c:if test="${param.searchMethod=='productName'||empty param.searchMethod}">
					<option value="productName" selected="selected">Product Name</option>
	    			<option value="shopName">Shop Name</option>
				</c:if>
				<c:if test="${param.searchMethod=='shopName'}">
					<option value="productName">Product Name</option>
	    			<option value="shopName" selected="selected">Shop Name</option>
				</c:if>
			</select>
			<select name="type" class="select"<c:if test="${param.searchMethod=='shopName'}">style="display: none;"</c:if>>
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
			<button type="submit" class="btn-warning button"></button>
		</form>
		
		<div class="results">
			<div class="main">Results</div>
			<div class="result-area">
				<c:forEach var="product" items="${productList}" >
					<div class="pic-container">
					    <a href="productInfo?pid=${ product.productId }">
					        <div class="over">
					            <div class="link-btn"></div>
					            <div class="product-name">name:${ product.name } &nbsp;&nbsp;&nbsp;shop:${product.shop.name }</div>
					            <div class="product-price">price:$ ${ product.discountPrice }</div>
					        </div>
					    </a>
					    <div class="shop" style="background-image: url('${ product.picture }');"></div>
					</div>
				</c:forEach>
				<c:if test="${num==0}">
					not found
				</c:if>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			customer.init();
			customer.initSearchPage();
		});
	</script>
</body>
</html>