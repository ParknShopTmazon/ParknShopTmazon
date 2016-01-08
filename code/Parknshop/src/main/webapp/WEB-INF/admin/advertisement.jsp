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
				<div class="grid_4">
					<p>
						<label>Product_Name</label>
						<input type="text" name="" value=""/>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Company</label>
						<input type="text" name="" value=""/>
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>Type</label>
						<select>
							<option>ALL</option>
							<option>Food</option>
							<option>Clothes</option>
							<option>Book</option>
						</select>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<label>&nbsp;</label>
                        <a href="#" class="Add" onclick="mischief()" id="mischief">Add</a>
					</p>
				</div>
                
                
                
				<div class="grid_16">
                    <h2>advertisement</h2>
					<table>
						<thead>
							<tr>
								<th>Company</th>
								<th>Type</th>
								<th>Cost</th>
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
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>

								<td><a href="#" class="delete">Delete</a></td>	
								<td><a href="#" class="delete">Modified</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td>50</td>
								<td><a href="#" class="delete">Delete</a></td>
								<td><a href="#" class="delete">Modified</a></td>
							</tr>
							
						</tbody>
					</table>
                    
                    <!-- 商品列表 -->
                    <h2>Product</h2>
                    <table>
						<thead>
							<tr>
								<th>shop</th>
								<th>price</th>
								<th>style</th>
								<th colspan="3" width="10%">Action</th>
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
								<td>taobao</td>
								<td>60</td>
								<td><img src='css/food.png' height="30" width="30"></td>				
								<td><a href="#" class="delete">Add</a></td>
							</tr>
							<tr class="alt">
								<td>A Company</td>
								<td>Food</td>
								<td><img src='css/food.png' height="30" width="30"></td>
								<td><a href="#" class="delete">Add</a></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
        
		<div id="addBox" style="display:none;"> 
        <form>                      
                		      <p>
								<label for="post" id="meme">Image </label>
								<input  name="imgfile"  type="file" id="imgfile" size="40" onchange="viewmypic(showing,this.form.imgfile);"/>
                                <img name="showing" id="showing" src="" style="display:none" alt="viewpic"/>
                             </p>
				       
                             <p>			
								<label for="post"  id="meme1">Cost</label>
								<input type="text" class="mystyle"/> 
				             </p>
                        	
                            	
                                <label>&nbsp;</label>	
								<input type="submit" value="Add"  onclick="vanish()"/>						  
                                                 
		 </form>      
         </div>
        <%@ include file="footer.html"%>
        
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
			function mischief(){
			 document.getElementById('mischief').style.backgroundColor="#36F";
			 document.getElementById('addBox').style.display="block";	 
			 }
			 
			 function vanish(){
			 document.getElementById('addBox').style.display="none";	 
			 }
			 
			 function viewmypic(mypic,imgfile)
			 {
				if(imgfile.value)
				{ 
				mypic.src=imgfile.value;
				mypic.style.display="block";
				mypic.style.border=1;
				 }
			 }
			 /*$(document)
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
					});*/

	</script>
	</body>
</html>