<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/operate.css"/>
<script src="../laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	laydate.render({
		  elem: '#calender' //指定元素
	});
</script>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="../img/main.svg"/></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="admin.action" style="color: #868686;">管理员列表</a>
	</div>
	<form action="${pageContext.request.contextPath }/add2.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					增加管理员基本信息
				</th>
			</tr>
			<tr>
				<td width="177" align="right">
					用户名：
				</td>
				<td width="323" align="left">
					<input type="text" name="admin.username">
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					密码：
				</td>
				<td width="323" align="left">
					<input type="password" name="admin.password">
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					状态：
				</td>
				<td width="323" align="left">
					<input type="text" name="admin.status" value="1" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th colspan="2" align="center">
					<input name="submit1" type="submit" value="提交">
					&nbsp;
					<input name="submit2" type="reset" value="重置">
					&nbsp;
					<input name="back" type="button" value="返回"
						onClick="javascript:history.back();">
				</th>
			</tr>
		</table>
		</form>
</body>
</html>