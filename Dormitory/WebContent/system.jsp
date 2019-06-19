<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生宿舍管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="shortcut icon" href="img/favicon.png"/>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/nav/nav.css"/>
		
		<script src="js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nav/nav.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container">
			<div id="header">
				<div id="dorm_control">
					<a href="#"><img src="img/iconfonts/dorm.png" width="30px" height="30px" /></a>
				</div>
				
				<a href="#"><h1>学生宿舍管理系统</h1></a>
				<div id="bar_control">
					<a href="#"><img src="img/iconfonts/bar.png" width="30px" height="30px" /></a>
				</div>
				<div id="set_control">
					<a href="#"><img src="img/iconfonts/set.png" width="30px" height="30px" /></a>
				</div>
				<span id="user">
					<s:iterator value="#session.list" var="user">
						<s:property value="#user.username"/>
					</s:iterator>
				</span>
				<div id="img_control">
					<a href="#">
						<s:iterator value="#session.list" var="user">
							<img src="<s:property value="#user.img"/>" width="30px" height="30px" />
						</s:iterator>
						<div id="img_retan">
							<span id="username">
								<s:iterator value="#session.list" var="user">
									<s:property value="#user.username"/>
								</s:iterator>
							</span><hr style="margin-top: 70px;opacity: 0.2;">
							<div id="beauty">
								<div id="i1">
									<span id="stu">个人信息</span><span id="live">住宿信息</span>
								</div>
								<div id="i2">
									<span id="buil">楼宇信息</span><span id="dorm">宿舍信息</span>
								</div>
								<div id="i3">
									<span id="first">后台首页</span><span id="sys">系统管理</span>
								</div>
								<div id="i4">
									<s:iterator value="#session.list" var="user">
										<s:if test="type != '2'.toString()">
											<a href="system2.jsp?type=<s:property value="#session.type"/>&id=<s:property value="#user.id"/>" id="my_img">上传头像</a>
										</s:if>
										<s:if test="type == '2'.toString()">
											<a href="system2.jsp?type=<s:property value="#session.type"/>&id=<s:property value="#user.username"/>" id="my_img">上传头像</a>
										</s:if>
									</s:iterator>
								</div>
							</div>
							<div id="background">
								<a href="quit.action" id="exit">
									退出
								</a>		
							</div>
						</div>
					</a>
				</div>
			</div>
			<div id="middle">
				<div id="left">
					<div class="leftsidebar_box">
						<dl class="first_manage">
							<dt ><span>后台首页</span><img src="img/left/right.png"></dt>
							<dd class="first_dd"><a href="${pageContext.request.contextPath }/show/main.jsp" target="mainFrame">首页列表</a></dd>
						</dl>
						<dl class="stu_manage">
							<dt ><span>学生管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd">
								<s:if test="type != '0'.toString()">
									<a href="st.action" target="mainFrame">学生列表</a>
								</s:if>
								<s:if test="type == '0'.toString()">
									<a href="st1.action?id=<s:property value="id"/>" target="mainFrame">学生列表</a>
								</s:if>
							</dd>
						</dl>
						<s:if test="type != '0'.toString()">
						<dl class="tube_manage">
							<dt ><span>宿管管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd"><a href="manager.action" target="mainFrame">宿管列表表</a></dd>
						</dl>
						</s:if>
						<s:if test="type != '0'.toString()">
						<dl class="buil_manage">
							<dt><span>楼宇管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd"><a href="building.action" target="mainFrame">楼宇列表</a></dd>
						</dl>
						</s:if>
						<s:if test="type != '0'.toString()">
						<dl class="dorm_manage">
							<dt ><span>宿舍管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd"><a href="dormitory.action" target="mainFrame">宿舍列表</a></dd>
						</dl>
						</s:if>
						<dl class="live_manage">
							<dt><span>住宿管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd">
								<s:if test="type != '0'.toString()">
									<a href="live.action" target="mainFrame">住宿列表</a>
								</s:if>
								<s:if test="type == '0'.toString()">
									<s:iterator value="list1" var="st">
										<a href="live2.action?id=<s:property value="#st.username"/>" target="mainFrame">住宿列表</a>
									</s:iterator>
								</s:if>
							</dd>
						</dl>
						<s:if test="type == '2'.toString()">
						<dl class="sys_manage">
							<dt><span>系统管理</span><img src="img/left/right.png"></dt>
							<dd class="first_dd"><a href="admin.action" target="mainFrame">管理员列表</a></dd>
							<dd class="first_dd"><a href="quit.action">安全退出</a></dd>
						</dl>
						</s:if>
					</div>
				</div>
				<div id="right">
					<iframe name="mainFrame" id="mainFrame" src="show/main.jsp" width="100%" height="100%" scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
					</iframe>
				</div>
			</div>
			<div id="footer">
				Copyright &nbsp;：粤ICP备19034008号 @ lk
			</div>
		</div>
	</body>
</html>