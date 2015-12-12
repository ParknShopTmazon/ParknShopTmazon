
$(document).ready(function() {
	$("#accountid").click(function() {
		if($("#session_customername").val()=="")
			alert("please login");
		else{
			useraccountAjax();
			$(".account").show();
		}
			
	});

	$(".account img").click(function() {
		$(".account").hide();
	});
	
	function useraccountAjax(){
		var Ajaxresult=null;
		$.ajax({
			type: "post",
			url: "UserAccountAjax",
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				Ajaxresult=eval("("+data+")");
				var result=Ajaxresult.result;
				$("#account_name").text("Hi , "+$("#session_customername").val());
				$("#useraccount").text(result);
				$("#Account_Balance").val(result);
			},    
			error: function (XMLHttpRequest, textStatus, errorThrown) {   
				alert(errorThrown);    
			}    
		});	
	}
	
	
});
