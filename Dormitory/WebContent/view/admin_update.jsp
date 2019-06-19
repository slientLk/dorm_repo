<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员列表</title>
<link rel="stylesheet" type="text/css" href="css/operate.css"/>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="img/main.svg"/></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="admin.action" style="color: #868686;">管理员列表</a>
	</div>
	<form action="${pageContext.request.contextPath }/update2.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					修改管理员基本信息
				</th>
			</tr>
			<s:iterator value="list" var="admin">
				<tr>
					<td width="177" align="right">
						用户名：
					</td>
					<td width="323" align="left">
						<input type="text" name="admin.username" value="<s:property value="#admin.username"/>" readonly="true">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						密码：
					</td>
					<td width="323" align="left">
						<input type="password" name="admin.password" value="<s:property value="#admin.password"/>">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						状态：
					</td>
					<td width="323" align="left">
						<input type="text" name="admin.status" value="<s:property value="#admin.status"/>" readonly="true">
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
			</s:iterator>
		</table>
		</form>
</body>
</html>