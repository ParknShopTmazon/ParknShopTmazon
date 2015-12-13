var total_price=0;
var count_product=0;
var product_ID="";
var Ajaxresult="";
var useraccount=0;
$(document).ready(function() {
	checkcount();
	countprice();
	checkproductcount();
	useraccount = accountAjax();
	function removeAjax(product_ID){
		Ajaxresult=null;
		$.ajax({  
			type: "post",    
			url: "CartRemoveAjax?product_ID="+product_ID,
			contentType: "application/json; charset=utf-8",  
			success: function (data) {
				
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				if(result==1){
					//alert("success");
					$("#tr"+product_ID).remove();
				}	
				else
					alert("false");
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				alert(errorThrown);    
			}    
		});	
	}
	
	$("#allcheck").bind("click",function(){
		if($("#allcheck").is(':checked')==true)
			$("input[name='check_product']").attr("checked",true);
		else
			$("input[name='check_product']").attr("checked",false);
		counttotalprice();
	});
	
	$("#customer_checkout").bind("click",function(){
		var inputlist=$("input[name='check_product']");
		var product_id_all="";
		var product_quantity_all="";
		for(var i=0;i<inputlist.length;i++){
			if(inputlist[i].checked==true){
				var product_id=inputlist[i].id.substring(8,inputlist[i].id.length);
				var product_quantity=Number($("#quantity"+product_id).val());
				product_id_all=product_id_all+product_id+",";
				product_quantity_all=product_quantity_all+product_quantity+",";	
			}
		}
		if(product_id_all.length!=0)
			product_id_all=product_id_all.substring(0, product_id_all.length-1);	
		if(product_quantity_all.length!=0)
			product_quantity_all=product_quantity_all.substring(0, product_quantity_all.length-1);
		
		var total_price = Number($("#total_price").text());
		if(Number(useraccount) < total_price )
			alert("Lack of balance");
		else if(product_id_all.length==0)
			alert("There is no selected items");
		else
			location.href = "CheckoutServlet?product_id_all=" + product_id_all + 
			"&product_quantity_all=" + product_quantity_all + "&total_price=" + total_price;
	});
	
	function accountAjax(){
		var Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "UserAccountAjax",
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				useraccount = result;
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				alert(errorThrown);    
			}    
		});	
	}
	
	$("input[name='check_product']").bind("click",function(){
		counttotalprice();
	});
	
	$("input[name='input_quantity']").bind("change",function(){
		var product_id=this.id.substring(8,this.id.length);
		var quantity_id="quantity"+product_id;
		var font_1_id="font_1"+product_id;
		var font_2_id="font_2"+product_id;
		var price=Number($("#"+quantity_id).val())*Number($("#"+font_1_id).text());
		$("#"+font_2_id).text(price);
		counttotalprice();
	});
	
	$("a[name='remove_a']").hover(function() {
		this.style.cursor = "pointer";
	});
	$("a[name='remove_a']").bind("click",function(){
		product_ID=this.id.substring(6,this.id.length);
		removeAjax(product_ID);
		checkproductcount();
	});
	
	function checkcount(){
		var inputlist=$("input[name='check_product']");
		for(var i=0;i<inputlist.length;i++){
			var product_id=inputlist[i].id.substring(8,inputlist[i].id.length);
			var quantity_id="quantity"+product_id;
			var stock_id = "product_stock"+product_id;
			if(Number($("#"+quantity_id).val()) > Number($("#"+stock_id).text()))
				$("#"+quantity_id).val($("#"+stock_id).text());
		}
	};
	
	function countprice(){
		var inputlist=$("input[name='check_product']");
		for(var i=0;i<inputlist.length;i++){
			var product_id=inputlist[i].id.substring(8,inputlist[i].id.length);
			var quantity_id="quantity"+product_id;
			var font_1_id="font_1"+product_id;
			var font_2_id="font_2"+product_id;
			var price=Number($("#"+quantity_id).val())*Number($("#"+font_1_id).text());
			$("#"+font_2_id).text(price);
		}
	};
	
	function counttotalprice(){
		total_price=0;
		var inputlist=$("input[name='check_product']");
		for(var i=0;i<inputlist.length;i++){
			if(inputlist[i].checked==true){
				var product_id=inputlist[i].id.substring(8,inputlist[i].id.length);
				var quantity_id="quantity"+product_id;
				var font_1_id="font_1"+product_id;
				total_price=total_price+Number($("#"+quantity_id).val())*Number($("#"+font_1_id).text());		
			}
		}
		$("#total_price").text(total_price);
	};
	function checkproductcount(){
		var inputlist=$("input[name='check_product']");
		if(inputlist.length==0){
			$("#cart_empty_div").show();
		}
		else{
			$("#cart_empty_div").hide();
		}
		
	}
});
