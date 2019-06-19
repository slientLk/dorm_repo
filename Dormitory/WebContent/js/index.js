$(function() {
	$("#bar_control").hover(function() {
		$(this).css("background-color", "#52ceed");
	}, function() {
		$(this).css("background-color", "#2dc2e7");
	});

	var flag = true;
	$("#bar_control").click(function() {
		if(flag) {
			$("dt").hide();
			$("dd").hide();
			$("#left").animate({
				width: '0px'
			});
			flag = false;
		} else {
			$("#left").animate({
					width: "165px"
				},
				function() {
					$("dt").show();
				}
			);
			flag = true;
		}
	});
	
	$("#img_retan").hide();
	$("#img_control").hover(
		function(){
			$("#img_control img").animate({
				width:"45px",
				height:"45px",
				top:"35px"
			},100);
			$("#img_retan").show();
		},function(){
			$("#img_control img").animate({
				width:"30px",
				height:"30px",
				top: "3.11%",
			},100);
			$("#img_retan").hide();
		}
	)
})