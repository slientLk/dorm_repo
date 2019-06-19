<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>学生宿舍管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="shortcut icon" href="img/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/nav/nav.css" />

<script src="js/jquery-3.4.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav/nav.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
	#title {
		height: 28px;
		background-color: #E1E1E1;
		padding-left: 10px;
		line-height: 28px;
	}
	
	#main_icon {
		float: left;
		margin-top: 4px;
	}
</style>

<script type="text/javascript">
	
</script>
</head>

<body>
	<s:actionerror />
	<div id="title">
		<div id="main_icon">
			<img src="img/main.svg" />
		</div>
		<a href="${pageContext.request.contextPath }/system.jsp" style="color: #2dc3e8; margin-left: 8px;">首页</a> 
		<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span> 
		<a href="${pageContext.request.contextPath }/show/main.jsp" style="color: #868686;">轻松时刻</a>
	</div>
	<form action="${pageContext.request.contextPath }/upload.action"
		enctype="multipart/form-data" method="post">
		<input name="type" value="<s:property value="#session.type"/>"
			type="hidden" />
		<s:if test="#session.type != '2'.toString()">
			<s:iterator value="#session.list" var="user">
				<input name="id" value="<s:property value="#user.id"/>"
					type="hidden" />
			</s:iterator>
		</s:if>
		<s:if test="#session.type == '2'.toString()">
			<s:iterator value="#session.list" var="user">
				<input name="id" value="<s:property value="#user.username"/>"
					type="hidden" />
			</s:iterator>
		</s:if>
		头像：<input type="file" name="photo"> <input type="submit"
			value="上传">
	</form>

</body>
</html>