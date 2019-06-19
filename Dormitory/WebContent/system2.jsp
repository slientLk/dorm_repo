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
		<style type="text/css">
			#title{
				height: 28px;
				background-color: #E1E1E1;
				padding-left: 10px;
				line-height: 28px;
			}
			#main_icon{
				float: left;
				margin-top: 4px;
			}
			#upload_content{
				width: 415px;
				height: 318px;
				margin: 0 auto;
				padding: 80px 20px 56px;
				position: relative;
			}
			#img_wrap{
				width: 182px;
			    height: 182px;
			    float: left;
			}
			.upload_control{
				cursor: pointer;
			    background: #E1E1E1;
			    width: 180px;
			    height: 180px;
			    position: absolute;
			    border: 1px solid #e5e9ef;
			    border-radius: 4px;
			    -webkit-transition: all .6s ease;
			    transition: all .6s ease;
			}
			#img_upload{
				 width: 180px;
				 display: none;
			}
			#selectImg{
				width: 180px;
				text-align: center;
				margin-top: 55px;
			}
			#imgText{
				display: block;
				text-align: center;
				font-size: 16px;
				color: #6d757a;
			}
			#img_line{
				height: 182px;
			    width: 1px;
			    background:#E1E1E1;
			    margin-left: 30px;
			    float: left;
			}
			#tou{
				margin-left: 40px;
			    margin-top: 30px;
			    float: left;
			}
			#infor{
				margin-top: 20px;
			    font-size: 12px;
			    color: #99a2aa;
			    text-align: center;
			}
			#descript{
				clear: both;
				line-height: 16px;
    			color: #99a2aa;
    			position: relative;
    			top: 25px;
			}
			#modal-footer{
				text-align: center;
				margin-top: 40px;
			}
			#u-button{
				border: 1px solid #00a1d6;
			    color: #fff;
			    background-color: #00a1d6;
				display: inline-block;
			    width: 140px;
			    height: 40px;
			    font-size: 14px;
			    line-height: 32px;
			    border-radius: 4px;
			    cursor: pointer;
			    text-decoration: none;
			}
		</style>

		<script type="text/javascript">
			$(function(){
				$(".upload_control").hover(function(){
					$(this).css("background","#E5E9EF")
				},function(){
					$(this).css("background","#f1f2f5");
				})
			})
		</script>
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
										<s:if test="#session.type != '2'.toString()">
											<a href="system2.jsp?type=<s:property value="#session.type"/>&id=<s:property value="#user.id"/>" id="my_img">上传头像</a>
										</s:if>
										<s:if test="#session.type == '2'.toString()">
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
							<dd class="first_dd"><a href="#">首页列表</a></dd>
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
					<s:actionerror />
					<div id="title">
						<div id="main_icon"><img src="img/main.svg"/></div>
						<a href="${pageContext.request.contextPath }/system.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
						<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
						<a href="${pageContext.request.contextPath }/show/game.jsp" style="color: #868686;">轻松时刻</a>
					</div>
					<form action="${pageContext.request.contextPath }/upload.action" enctype="multipart/form-data" method="post">
							   <input name="type" value="<s:property value="#session.type"/>" type="hidden"/>
						<s:if test="#session.type != '2'.toString()">
							<s:iterator value="#session.list" var="user">
								<input name="id" value="<s:property value="#user.id"/>" type="hidden"/>
							</s:iterator>
						</s:if>
						<s:if test="#session.type == '2'.toString()">
							<s:iterator value="#session.list" var="user">
								<input name="id" value="<s:property value="#user.username"/>" type="hidden"/>
							</s:iterator>
						</s:if>
						<div id="upload_content">
							<div id="img_wrap">
								<label class="upload_control" for="img_upload">
									<input type="file" name="photo" id="img_upload"/>
									<div id="selectImg">
										<img src="img/imgUpload.svg"/>
									</div>
									<span id="imgText">
										选择图片
									</span>
								</label>
							</div>
							<div id="img_line"></div>
							<div id="tou">
								<s:iterator value="#session.list" var="user">
									<img src="<s:property value="#user.img"/>" width="98px" height="98px" />
								</s:iterator>
								<div id="infor">
									当前头像
								</div>
							</div>
							<p id="descript">请选择图片上传：大小180 * 180像素支持JPG、PNG等格式，图片需小于2M</p>
							<div id="modal-footer">
								<input type="submit" id="u-button" value="更新" />
							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="footer">
				Copyright &nbsp;：粤ICP备19034008号 @ lk
			</div>
		</div>
	</body>
</html>