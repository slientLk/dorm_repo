<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>住宿列表</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
<script>
	function clearData() {
		window.inqForm.strKey.value = "";
		window.inqForm.strType.options[0].selected = true;
	}
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
	<s:if test="list.size() != 1">
		<table width="600" border="0" cellspacing="0" cellpadding="3" align="center" id="t1">
			<tr align="center">
					<td width="152">
						<a href="beforeAdd2.action">
							<img title="增加" src="img/add.png" align="middle">&nbsp;<span style="position:relative;top:5px;color:#2dc3e8">增加</span>
						</a> 
					</td>
					<form action="${pageContext.request.contextPath }/query6.action" method="post" name="inqForm" border="0">
						<td width="648">
							关键字: 
							<label> 
								<input name="strKey" type="text" size="15" value="<s:property value="strKey"/>" autocomplete="off">
								<select name="strType" id="select" style="padding:2px;">
									<option value="username">
										姓名
									</option>
									<option value="buildingId">
										宿舍号
									</option>
								</select> 
								<input type="button" name="button" id="button" value="重置" onClick="clearData()">
								<input type="submit" name="button" id="button" value="搜索">
							</label>
						</td>
					</form>
			</tr>
		</table>	
	</s:if>
	<table width="600" cellspacing="0" cellpadding="3" align="center" id="t2">
		<tr>
			<th>姓名</th>
			<th>宿舍号</th>
			<th>入住日期</th>
			<s:if test="list.size() != 1"><th>操作</th></s:if>
		</tr>
		<s:iterator value="list" var="live">
			<tr>
				<td width="20%">
					<s:property value="#live.username"/>
				</td>
				<td width="40%">
					<s:property value="#live.buildingId"/>
				</td>
				<td width="30%">
					<s:date name="#live.livetime" format="yyyy-MM-dd"/>
				</td>
				<s:if test="list.size() != 1">
				<td width="10%">
					<a href="${pageContext.request.contextPath }/current6.action?id=<s:property value="#live.username"/>"><img title="修改" src="img/update.png"></a>
					<a href="${pageContext.request.contextPath }/delete6.action?id=<s:property value="#live.username"/>"><img title="删除" src="img/delete.png"></a>
				</td>
				</s:if>
			</tr>
		</s:iterator>
		<tr>
			<s:if test="list.size() != 1">
				<th colspan="4">
				当前页数<s:property value="page"/>/<s:property value="pageCnt"/>&nbsp; 
				<s:if test="page > 1">
				<a href="live.action?page=1">第一页</a>
				<a href="live.action?page=<s:property value="page - 1"/>">上一页</a>
				</s:if>
				<s:if test="page < pageCnt">
				<a href="live.action?page=<s:property value="page + 1"/>">下一页</a>
				<a href="live.action?page=<s:property value="pageCnt"/>">页尾</a>
				</s:if>
				</th>
			</s:if>
			<s:if test="list.size() == 1">
				<th colspan="3">
				当前页数<s:property value="page"/>/<s:property value="pageCnt"/>&nbsp; 
				<s:if test="page > 1">
				<a href="live.action?page=1">第一页</a>
				<a href="live.action?page=<s:property value="page - 1"/>">上一页</a>
				</s:if>
				<s:if test="page < pageCnt">
				<a href="live.action?page=<s:property value="page + 1"/>">下一页</a>
				<a href="live.action?page=<s:property value="pageCnt"/>">页尾</a>
				</s:if>
				</th>
			</s:if>
		</tr>
	</table>
</body>
</html>