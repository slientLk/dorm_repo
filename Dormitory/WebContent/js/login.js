$(function() {
	Victor("container", "output"); //登陆背景函数
	$("#username").focus();
	$(document).keydown(function(event) {
		if(event.keyCode == 13) {
			$("#entry_btn").click();
		}
	});
	
	$("#entry_form").submit(function(){
		checkUserName();
		if(checkUserName()){
			checkPassw();
		}		
		if(checkUserName() && checkPassw())
			return true;
		else
			return false;
	})
	function checkUserName() {
		var $username = $("#username");
		var $errorTips = $("#username_errorTips");
		$errorTips.html("");
	
		if($username.val() == "") {
			$errorTips.html("用户名不能为空！");
			return false;
		}
	
		return true;
	}
	function checkPassw() {
		var $passwd = $("#password");
		var $errorTips = $("#password_errorTips");
		$errorTips.html("");
	
		if($passwd.val() == "") {
			$errorTips.html("密码不能为空！");
			return false;
		}
	
		return true;
	}
	
	$("#entry_form2").submit(function(){
		if(checkId() && checkResisterPassw() && checkRePassw() && checkName() && checkCalender())
			return true;
		else
			return false;
	})
	function checkId() {
		var $registerName = $("#registerName");
		var $errorTips = $("#registerName_errorTips");
		$errorTips.html("");
	
		if($registerName.val() == "") {
			$errorTips.html("用户名不能为空！");
			return false;
		}
	
		return true;
	}
	function checkResisterPassw() {
		var $passwd = $("#registerPasswd");
		var $errorTips = $("#registerPasswd_errorTips");
		$errorTips.html("");
	
		if($passwd.val() == "") {
			$errorTips.html("密码不能为空！");
			return false;
		}else if($passwd.val().length < 6){
			$errorTips.html("密码长度不能小于6位！");
			return false;
		}
	
		return true;
	}
	function checkRePassw(){
		var $registerPasswd = $("#registerPasswd");
		var $repasswd = $("#repasswd");
		var $errorTips = $("#repasswd_errorTips");
		$errorTips.html("");
	
		if($repasswd.val() == "") {
			$errorTips.html("确认密码不能为空！");
			return false;
		}else if($registerPasswd.val() != $repasswd.val()) {
			$errorTips.html("两次输入的密码不一致！");
			return false;
		}	
	
		return true;
	}
	function checkName(){
		var $stuName = $("#stuName");
		var $errorTips = $("#stuName_errorTips");
		$errorTips.html("");
	
		if($stuName.val() == "") {
			$errorTips.html("姓名不能为空！");
			return false;
		}
	
		return true;
	}
	function checkCalender(){
		var $calender = $("#calender");
		var $errorTips = $("#calender_errorTips");
		$errorTips.html("");
	
		if($calender.val() == "") {
			$errorTips.html("日期不能为空！");
			return false;
		}
		
		return true;
	}
	
	$('#switch_qlogin').click(function() {
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({
			left: '-12px',
			width: '70px'
		});
		$('#entry_form2').css('display', 'none');
		$('#entry_form').css('display', 'block');

		$("#username").focus();
	});
	$('#switch_login').click(function() {
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({
			left: '100px',
			width: '70px'
		});
		$('#entry_form2').css('display', 'block');
		$('#entry_form').css('display', 'none');

		$("#registerName").focus();
	});

	$('.user-card input').each(function(){
        var self = $(this),
                label = self.next(),
                label_text = label.text();

        label.remove();
        self.iCheck({
            checkboxClass: 'icheckbox_sm-blue',
            radioClass: 'radio_sm-blue',
            insert: label_text
        });
    });
	
	$('.user-sex input').each(function() {
		var self = $(this),
			label = self.next(),
			label_text = label.text();

		label.remove();
		self.iCheck({
			checkboxClass: 'icheckbox_sm-blue',
			radioClass: 'radio_sm-blue',
			insert: label_text
		});
	});
	
	laydate.render({
		  elem: '#calender' //指定元素
	});
});