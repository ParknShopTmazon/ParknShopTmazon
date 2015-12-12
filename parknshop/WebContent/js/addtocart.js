var Ajaxresult="";
var product_ID="";
var product_quantity=1;
$(document).ready(function() {
	function addtocartAjax(){
		Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "AddToCartAjax?product_ID="+product_ID+"&product_quantity="+product_quantity+"&customername="+customername,
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				if(result>=1)
					alert("add to cart success");
				else
					alert("add to cart false");
				cartcountAjax();
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				alert(errorThrown);    
			}    
		});	
	}
	
	$("a[class='add_to_card']").hover(function() {
		this.style.cursor = "pointer";
	});
	$("a[class='add_to_card']").bind("click",function(){
		if($("#session_customername").val()=="")
			alert("please login");
		else{
			product_ID=this.id.substring(9,this.id.length);
			product_quantity=$("#buycount").val();
			addtocartAjax();
		}
	});
});