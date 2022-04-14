$(function(){
	$(".sure input").click(function(){
		if(confirm("Are you sure you want to choose this topic?") == true){
			return true;
		}else{
			return false;
		}
	})
})