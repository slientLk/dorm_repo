<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>jquery图片轮播</title>
		<link rel="stylesheet" type="text/css" href="../css/main.css"/>
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/scroll/scroll.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/main.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div id="title">
			<div id="main_icon"><img src="../img/main.svg" /></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;" target="mainFrame">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="${pageContext.request.contextPath }/show/game.jsp" style="color: #868686;">轻松时刻</a>
		</div>
		<div class="slider" id="slider">
			<div class="slider-inner">
				<div class="item">
					<img class="img" style="background: url('../img/rotate/01.jpg');">
				</div>
				<div class="item">
					<img class="img" style="background: url('../img/rotate/02.jpg');">
				</div>
				<div class="item">
					<img class="img" style="background: url('../img/rotate/03.jpg');">
				</div>
				<div class="item">
					<img class="img" style="background: url('../img/rotate/04.jpg');">
				</div>
				<div class="item">
					<img class="img" style="background: url('../img/rotate/05.jpg');">
				</div>
			</div>
		</div>
		<div id="text-right">
			<div class="menu" style="text-align: center;line-height: 50px;">
				<a class="cur" href="#" style="font-size: 15px;color: #FC6E52;">宿舍管理条例</a>
			</div>
			<div class="myscroll">
				<ul>
					<li><a href="#">学生入住宿舍，由宿管办统一安排与调度</a></li>
					<li><a href="#">学校确保为每一名全日制学生提供住宿床位</a></li>
					<li><a href="#">每位学生只允许使用一个床位</a></li>
					<li><a href="#">延期毕业的学生需继续住宿，需办理延期住宿手续</a></li>
					<li><a href="#">宿舍内禁止私拉乱接电线</a></li>
					<li><a href="#">宿舍楼内严禁吸烟</a></li>
					<li><a href="#">宿舍内严禁带入和存放管制刀具</a></li>
					<li><a href="#">学生要加强自身物品安全管理</a></li>
					<li><a href="#">学生应当牢固树立防火安全意识日</a></li>
					<li><a href="#">学生之间应团结友爱、相互包容、相互尊重和体谅</a></li>
					<li><a href="#">学生应保持宿舍内的卫生整洁、经常进行室内通风</a></li>
					<li><a href="#">宿舍楼内禁止开展广告、推销等商业活动</a></li>
					<li><a href="#">禁止学生在宿舍内饲养和喂食猫、狗等宠物</a></li>
					<li><a href="#">学生不得在宿舍楼内有高声喧哗、追逐嬉闹</a></li>
					<li><a href="#">严禁在宿舍楼酗酒滋事、 黄赌毒 等不良或违法行为</a></li>
					<li><a href="#">禁止私自改装、拆卸、破坏或处置学校公共设施</a></li>
					<li><a href="#">学生凡在宿舍内使用或存放违禁电器与物品</a></li>
					<li><a href="#">学生应当尊重物业管理服务人员</a></li>
					<li><a href="#">学生不得窃取宿舍楼内水、电等学校公共资源</a></li>
					<li><a href="#">学校开展文明宿舍评比活动，给予物质和精神奖励</a></li>
				</ul>
			</div>
		</div>
	</body>

</html>