<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>登录与注册</title>
		<link rel="stylesheet" href="css/style.css" />

		<link rel="stylesheet" type="text/css" href="css/radio/icheck.css" />
		<link rel="stylesheet" type="text/css" href="css/radio/icommon.css" />

		
		<script src="js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/background/vector.js"></script>
		
		<script src="js/radio/icheck.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/radio/icheck.min.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="laydate/laydate.js" type="text/javascript" charset="utf-8"></script>

		<script type="text/javascript">
			var type = 0;
			$(function(){
				$(".iCheck-helper").click(function(){
					$(":input[name='id']").focus();
					type = $(this).siblings().val();
				})
				
				$(":input[name='id']").blur(function(){
					var id = $(":input[name='id']").val();
					$.ajax({
						url:"loginValidate.action",
						type:"post",
						data:{
							id:id,
							type:type},	
						dateType:"json",
						success:function(data){
							$("#username_errorTips").html(data.msg);
						},
						error:function(data){
							$("#username_errorTips").html(data.msg);
						}
					})
				})
			});
		</script>
	</head>
	<body>
		<div id="container">
			<div id="output">
				<div class="containerT">
					<div class="header">
						<div class="switch" id="switch">
							<a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
							<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
							<div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: -12px;"></div>
						</div>
					</div>
					<form action="${pageContext.request.contextPath }/login.action" class="form" id="entry_form" method="post">
						<input type="text" placeholder="用户名" class="type1" name="id" id="username">
						<span id="username_errorTips"><s:property value="sign"/></span>
						<input type="password" placeholder="密码" class="type1" name="password" id="password">
						<span id="password_errorTips"></span>
						<div class="user-card">
							<div class="card" id="s1">
								<input type="radio" id="card-stu" name="type" value="0" checked>
								<label for="card-stu">学生</label>
							</div>
							<div class="card" id="s2">
								<input type="radio" id="card-manager" name="type" value="1">
								<label for="card-manager">宿管</label>
							</div>
							<div class="card" id="s3">
								<input type="radio" id="card-admin" name="type" value="2">
								<label for="card-admin">管理员</label>
							</div>
						</div><br />
						<button type="submit" id="entry_btn">登录</button>
						<div id="prompt" class="prompt"></div>
					</form>
					<form action="${pageContext.request.contextPath }/register.action" class="form2" id="entry_form2" style="display: none;" method="post">
						<input type="text" name="student.id" class="type1" id="registerName" placeholder="用户名">
						<span id="registerName_errorTips"></span>
						<input type="password" name="student.password" placeholder="密码" class="type1" id="registerPasswd">
						<span id="registerPasswd_errorTips"></span>
						<input type="password" name="student.repasswd" id="repasswd" class="type1" placeholder="确认密码" />
						<span id="repasswd_errorTips"></span>
						<input type="text" name="student.username" id="stuName" class="type1" placeholder="姓名" />
						<span id="stuName_errorTips"></span>
						<input type="text" name="student.livetime" class="type1" placeholder="请选择日期" id="calender" autocomplete="off" value="2019-09-01" readonly="readonly">
						<span id="calender_errorTips"></span>
						<div class="user-sex">
							<div class="sex" id="s1">
								<input type="radio" id="sex-man" name="student.gender" value="男" checked>
								<label for="sex-man">男</label>
							</div>
							<div class="sex" id="s2">
								<input type="radio" id="sex-woman" name="student.gender" value="女">
								<label for="sex-woman">女</label>
							</div>
						</div><br />
						<button type="submit" id="entry_register">提交</button>
						<div id="prompt" class="prompt"></div>
					</form>
				</div>
			</div>
		</div>
		<canvas width="1365" height="920" style="display: block;"></canvas>

	</body>

</html>