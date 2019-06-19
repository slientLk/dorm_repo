<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/operate.css"/>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="img/main.svg"/></div>
			<a href="#" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="#" style="color: #868686;">宿舍列表</a>
	</div>
	<form action="${pageContext.request.contextPath }/update5.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					修改宿舍基本信息
				</th>
			</tr>
			<s:iterator value="list" var="dorm">
				<tr>
					<td width="177" align="right">
						宿舍号：
					</td>
					<td width="323" align="left">
						<input type="text" name="dormitory.buildingId" value="<s:property value="#dorm.buildingId"/>">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						楼宇：
					</td>
					<td width="323" align="left">
						<input type="text" name="dormitory.buildingName" value="<s:property value="#dorm.buildingName"/>">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						宿舍楼层：
					</td>
					<td width="323" align="left">
						<input type="text" name="dormitory.buildingFloor" value="<s:property value="#dorm.buildingFloor"/>">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						最大可住：
					</td>
					<td width="323" align="left">
						<input type="text" name="dormitory.max_num" value="<s:property value="#dorm.max_num"/>" readonly="true">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						已经入住：
					</td>
					<td width="323" align="left">
						<input type="text" name="dormitory.lived_num" value="<s:property value="#dorm.lived_num"/>" readonly="true">
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