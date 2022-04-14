function loginCheck(){
	var name = $("#loginUser").attr("value");
	var password = $("loginPW").attr("value");
	var datas = new Object();
	$.ajax({
	    type: "post",
	    contentType: "application/string",
	    dataType: "json",
	    async: false,
	    url : "${base}/loginResult.html" name="+name+"&password="+password+", 
	    success: function (data){
	    	datas = eval("("+data+")");
	    }
	});
	if(datas.result =="nameFalse"){
		layer.tips('Username does not exist!'，'#loginUser'，{ 
			tips: [2，'#FF3030'], 
			time: 2000
		});
		return false;
	}else if(datas.result == "passwordFalse"){
		layer.tips('Incorrect password!'，'#loginPW',{
			tips:[2，'#FF3030'],
			time: 2000
		});
		return false;
	}else{
		return true;
	}
}