$(".leftsidebar_box dt").css({"background-color":"#FFFFFF"});
$(".leftsidebar_box dt img").attr("src","img/left/right.png");
$(function(){
	var flag = true;
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
	$(".leftsidebar_box dt").css({"background-color":"#ffffff"})
	$(this).css({"background-color": "#eeeeee"});
	$(this).parent().find('dd').removeClass("menu_chioce");
	if(flag){
		$(".leftsidebar_box dt img").attr("src","img/left/right.png");
		$(this).parent().find('img').attr("src","img/left/under.png");
		flag = false;
	}else{
		$(".leftsidebar_box dt img").attr("src","img/left/under.png");
		$(".leftsidebar_box dt img").attr("src","img/left/right.png");
		flag = true;
	}
	
	$(".menu_chioce").slideUp(); 
	$(this).parent().find('dd').slideToggle();
	$(this).parent().find('dd').addClass("menu_chioce");
	});
	
	$(".leftsidebar_box dt").hover(function(){
		$(this).css("background-color","#e7e5e5");
		$(this).css("color","#000000");
	},function(){
		$(this).css("background-color","#ffffff");
		$(this).css("color","#737373");
	});
	
	$(".leftsidebar_box dd a").hover(function(){
		$(this).css("color","#000000");
	},function(){
		$(this).css("color","#737373");
	});
	
	$(".leftsidebar_box dd").hover(function(){
		$(this).css("background-color","#eeeeee");
	},function(){
		$(this).css("background-color","#fbfbfb");
	});
})