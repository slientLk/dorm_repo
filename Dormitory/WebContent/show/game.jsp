<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>见缝插针</title>
		<!-- AA -->
		<style type="text/css">
			html,
			body {
				padding: 0;
				margin: 0;
				border: 0;
				overflow: hidden;
				text-align: center;
				background-color: #EEEEEE;
				-moz-user-select: none;
				-webkit-user-select: none;
				user-select: none;
				font-size: 12px;
			}
			
			body {
				overflow: visible;
			}
			/* for Android Native Browser bug */
			
			a {
				text-decoration: none;
			}
			
			#title {
				height: 28px;
				background-color: #E1E1E1;
				padding-left: 10px;
				line-height: 28px;
				text-align: left;
			}
			
			#main_icon {
				float: left;
				margin-top: 4px;
			}
			
			canvas {
				background-color: #EEEEEE;
				vertical-align: middle;
				opacity: 1;
				border-top: solid 1px #000;
			}
			
			.title {
				font-size: 24px;
				font-family: 微软雅黑, 黑体;
				color: #000;
				letter-spacing: 4px;
				margin-bottom: 4px;
			}
			
			@media all and (min-width: 480px) and (max-height: 479px) {
				canvas {
					-webkit-transform: translateY(-80px) rotate(-90deg);
					-moz-transform: translateY(-80px) rotate(-90deg);
					transform: translateY(-80px) rotate(-90deg);
					border-top: 0;
					border-right: solid 1px #000;
				}
			}
		</style>
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
		<meta name="Author" content="cxp">
		<meta name="Date" content="2015-02-04">
		<meta name="renderer" content="webkit">
		<!-- for 360 browser -->
	</head>

	<body>
		<div id="title">
			<div id="main_icon"><img src="../img/main.svg" /></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;" target="mainFrame">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="${pageContext.request.contextPath }/show/game.jsp" style="color: #868686;">轻松时刻</a>
		</div>
		<div class="title">见缝插针</div>
		<canvas id="canvas1" width="320" height="480"></canvas>
		<script src="../js/game/MyCtx.min.js"></script>
		<script src="../js/game/aa.cc.min.js"></script>

	</body>

</html>