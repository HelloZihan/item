require.config({
    paths: {
        'jquery': 'jquery-1.8.0'
    }
});
require(['jquery'], function($) {
	$("#submit").on("click",function(){
		var data = {
		 	"name":$("#account").val(),
		 	"password":$("#password").val()
		 }
		 var url = "http://192.168.1.107:8082/item/api/json/user/login";
		 $.ajax({
            type: "POST",
            dataType: "json",
            url: url,
            data: data,
            success: function (result) {
                if(result.success){
                	window.sessionStorage["wh9527"] = JSON.stringify(result.data);
                	window.location.href = "index.html";
                }else{
                	alert(result.errMsg);
                }
            },
            error: function(data) {
                alert("error:"+data);
             }
         });
	});
});