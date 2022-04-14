$(function(){
	var $text = $('.text-title').val();
	
	$('.text-title').focus(function(){
		if($(this).val() == $text){
			$(this).attr('value','');
		}
	})
	$('.text-title').blur(function(){
		if($(this).val() == ''){
			$(this).val($text);
		}
		
	
	})
	
	$(".isTrue").click(function(){
		if(confirm("Are you sure you choose this topic?") == true){
			return true;
		}else{
			return false;
		}
	})
	