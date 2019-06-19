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
<script src="laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	laydate.render({
		  elem: '#calender' //指定元素
	});
</script>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="img/main.svg"/></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<s:if test="type != '0'.toString()">
				<a href="live.action" style="color: #868686;">住宿列表</a>
			</s:if>
			<s:if test="type == '0'.toString()">
				<s:iterator value="#session.list1" var="st">
					<a href="live2.action?id=<s:property value="#st.username"/>" style="color: #868686;">住宿列表</a>
				</s:iterator>
			</s:if>
	</div>
	<form action="${pageContext.request.contextPath }/add6.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					增加住宿基本信息
				</th>
			</tr>
			<tr>
				<td width="177" align="right">
					姓名：
				</td>
				<td width="323" align="left">
					<select name="live.username" id="select" style="padding:2px;">
						<s:iterator value="unList">
							<option value="<s:property/>">
								<s:property/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					宿舍号：
				</td>
				<td width="323" align="left">
					<select name="live.buildingId" id="select" style="padding:2px;">
						<s:iterator value="fieldList">
							<option value="<s:property/>">
								<s:property/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					入住日期：
				</td>
				<td width="323" align="left">
					<input type="text" name="live.livetime" id="calender" autocomplete="off" value="2019-09-01" readonly="readonly">
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