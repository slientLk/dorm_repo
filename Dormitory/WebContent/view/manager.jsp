<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表</title>
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
			<a href="manager.action" style="color: #868686;">宿管列表</a>
	</div>
	<table width="700" border="0" cellspacing="0" cellpadding="3" align="center" id="t1">
		<tr align="center">
				<td width="152">
					<a href="view/manager_add.jsp">
						<img title="增加" src="img/add.png" align="middle">&nbsp;<span style="position:relative;top:5px;color:#2dc3e8">增加</span>
					</a> 
				</td>
				<form action="${pageContext.request.contextPath }/query1.action" method="post" name="inqForm" border="0">
					<td width="548">
						关键字: 
						<label> 
							<input name="strKey" type="text" size="15" value="<s:property value="strKey"/>" autocomplete="off">
							<select name="strType" id="select" style="padding:2px;">
								<option value="id">
									编号
								</option>
								<option value="username">
									姓名
								</option>
								<option value="status">
									状态
								</option>
							</select> 
							<input type="button" name="button" id="button" value="重置" onClick="clearData()">
							<input type="submit" name="button" id="button" value="搜索">
						</label>
					</td>
				</form>
		</tr>
	</table>	
	<table width="700" cellspacing="0" cellpadding="3" align="center" id="t2">
		<tr>
			<th>编号</th>
			<th>密码</th>
			<th>姓名</th>
			<th>性别</th>
			<th>联系电话</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" var="man">
			<tr>
				<td width="20%">
					<s:property value="#man.id"/>
				</td>
				<td width="20%">
					<s:property value="#man.password"/>
				</td>
				<td width="15%">
					<s:property value="#man.username"/>
				</td>
				<td width="10%">
					<s:property value="#man.gender"/>
				</td>
				<td width="16%">
					<s:property value="#man.telephone"/>
				</td>
				<td width="9%">
					<s:if test="#man.status == 1">
						在职
					</s:if>
					<s:elseif test="#man.status == 0">
						离职
					</s:elseif>
				</td>
				<td width="10%">
					<a href="${pageContext.request.contextPath }/current1.action?id=<s:property value="#man.id"/>"><img title="修改" src="img/update.png"></a>
					<a href="${pageContext.request.contextPath }/delete1.action?id=<s:property value="#man.id"/>"><img title="删除" src="img/delete.png"></a>
				</td>
			</tr>
		</s:iterator>
		<tr>
			<th colspan="7">
				当前页数<s:property value="page"/>/<s:property value="pageCnt"/>&nbsp; 
				<s:if test="page > 1">
				<a href="manager.action?page=1">第一页</a>
				<a href="manager.action?page=<s:property value="page - 1"/>">上一页</a>
				</s:if>
				<s:if test="page < pageCnt">
				<a href="manager.action?page=<s:property value="page + 1"/>">下一页</a>
				<a href="manager.action?page=<s:property value="pageCnt"/>">页尾</a>
				</s:if>
			</th>
		</tr>
	</table>
</body>
</html>