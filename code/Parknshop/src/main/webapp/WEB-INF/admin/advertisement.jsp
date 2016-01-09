<%@ page language="java" import="java.util.* ,com.tmazon.domain.Advertisement" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Advertisement Management</title>
		<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
	</head>
	<body>
		
		<%@ include file="header.html"%>
		<%@ include file="box.html" %>
		<div class="ad-container">
			<div id="content" class="container_16 clearfix">
				<form action="searchProductAdmin" method="post">
					<div class="grid_4">
						<p>
							<label>ProductName:</label>
							<input type="text" name="searchProductName" value="${searchProductName }">
						</p>
					</div>
					<div class="grid_5">
						<p>
							<label>Type:</label>
							<select id="select_type" name="select_type" >
								<c:if test="${select_type=='' ||empty select_type}">
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
						    		<c:if test="${select_type=='TV& Home Theater'}">
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
						    		<c:if test="${select_type=='Computers & Tablets'}">
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
						    		<c:if test="${select_type=='Cell Phones'}">
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
						    		<c:if test="${select_type=='Cameras & Camcorders'}">
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
						    		<c:if test="${select_type=='Audio'}">
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
						    		<c:if test="${select_type=='Car Electronics & GPS'}">
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
						    		<c:if test="${select_type=='Video, Games, Movies & Music'}">
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
						    		<c:if test="${select_type=='Health, Fitness & Sports'}">
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
						    		<c:if test="${select_type=='Home & Office'}">
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
						</p>
					</div>
					<div class="grid_2">
						<p>
							<label>&nbsp;</label>
	                        <input   type="submit" value="Search" />
						</p>
					</div>
				</form> 
				<div class="grid_16">
                    <h2>Advertisement:</h2>
					<table>
						<thead>
							<tr>
								<th>ID</th>
								<th>ProductName</th>
								<th>ShopName</th>
								<th>Type</th>
								<th>Cost</th>
								<th colspan="3" width="10%">Actions</th>
							</tr>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<c:forEach items="${sessionScope.showAdList }" var="ad">
								<tr>
									<td>${ad.ad.adId }</td>
									<td>${ad.product.name }</td>
									<td>${ad.shop.name }</td>
									<td>${ad.product.category }</td>
									<td>${ad.ad.cost }</td>
									<td><div class="delete">Delete</div></td>	
									<td><div class="edit">Modified</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
                    
                    <!-- 商品列表 -->
                   
                    <h2>Product:</h2>
                    <table>
						<thead>
							<tr>
								<th></th>
								<th>ProductId</th>
								<th>ProductName</th>
								<th>ShopName</th>
								
								<th colspan="3" width="10%">Action</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="3" rowspan="2" class="pagination">
									<form method="post" action="searchProductAdmin">
										<input id="prev-btn" type="submit"  value="<<"></input>
										<span name="curIndex" class="active curved">${curPage }</span>
										<input id="next-btn" type="submit" value=">>"></input>
										<input name="searchProductName"  type="hidden" value="${searchProductName }" />
										<input name="select_type"  type="hidden" value="${select_type }" />
										<input name="curPage"  type="hidden" value="${curPage }" />
										<input type="hidden" id="next-val" name="next" value="1"/>
								</form>
								</td>
						</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${ productList }"  var="pro" varStatus="status">
							<tr>
								<td><img src="${pro.picture}" height="30" width="30"></td>
								<td>${pro.productId }</td>
								<td>${pro.name }</td>
								<td>${shopList[status.index].name }</td>		
								<td><div id="mischief" class="trigger button">Add</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
        </div>
		<div id="addBox" style="display:none;"> 
	        <form>                      
				<p>
					<label for="post" id="meme">Image </label>
					<input  name="imgfile"  type="file" id="imgfile" size="40" onchange="viewmypic(showing,this.form.imgfile);">
	                	<img name="showing" id="showing" src="" style="display:none" alt="viewpic"/>
				</p>
					       
				<p>			
					<label for="post"  id="meme1">Cost</label>
					<input type="text" class="mystyle"> 
				</p>
	                        	
	                            	
				<label>&nbsp;</label>	
				<input type="submit" value="Add"   onclick="vanish()">						  	
			</form>      
		</div>
        <%@ include file="footer.html"%>
        
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
		
			document.getElementById('next-btn').addEventListener('click', function() {
				document.getElementById('next-val').setAttribute('value', 1);
			});
			document.getElementById('prev-btn').addEventListener('click', function() {
				document.getElementById('next-val').setAttribute('value', -1);
			});
			
			
			function mischief() {
				document.getElementById('mischief').style.backgroundColor="#36F";
				document.getElementById('addBox').style.display="block";	 
			}
			 
			function vanish() {
				document.getElementById('addBox').style.display="none";	 
			}
			 
			function viewmypic(mypic,imgfile) {
				if(imgfile.value) { 
					mypic.src=imgfile.value;
					mypic.style.display="block";
					mypic.style.border=1;
				}
			}
			
			$(document).ready(function () {
				$('.grid_16 .delete').click(function () {
					$(this).parent().parent().hide();
					const url = 'DeleteAdvServlet';
					const sid = $(this).parent().prev().prev().prev().prev().prev().html();
					$.ajax({
						url : url,
						type : 'POST',
						data : {
							sid : sid
						},
						dataType : 'json'
					}).done(function () {
						console.log('success');
					}).fail(function () {
						console.log('error');
					});
				});
				
				$('#somedialog .submit-btn').click(function() {
					$(this).parent().submit();
				});
				
				/** initiate the box */
				var dlgtrigger = document.querySelector('[data-dialog]');
	            if (dlgtrigger) {
	                var somedialog = document.getElementById(dlgtrigger.getAttribute('data-dialog'));
	                var dlg = new DialogFx(somedialog);
	                $trigger = $('.trigger');
	                $edit = $('.edit');
	                $trigger.each(function() {
	                	$(this).click(dlg.toggle.bind(dlg));
	                	$(this).click(function() {
	                		$('#somedialog .picture').show();
	                		$('#somedialog #productName').html($(this).parent().prev().prev().html());
	                		$('#somedialog .picture').css({
	                			'background-image': 'url(' + $(this).parent().prev().prev().prev().prev().children('img').attr('src') + ')'
	                		});
	                		$('#somedialog #productId').val($(this).parent().prev().prev().prev().html());
	                	});
	                });
	                
	                $edit.each(function() {
	                	$(this).click(dlg.toggle.bind(dlg));
	                	$(this).click(function() {
	                		$('#somedialog .picture').hide();
	                		$('#somedialog #productName').html($(this).parent().prev().prev().prev().prev().prev().html());
	                		$('#somedialog #productId').val($(this).parent().prev().prev().prev().prev().prev().prev().html());
	                	});
	                	
	                });
	                // dlgtrigger.addEventListener('click', dlg.toggle.bind(dlg));
	            }
			});

	</script>
	</body>
</html>