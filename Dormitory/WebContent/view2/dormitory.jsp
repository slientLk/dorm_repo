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
	function warn(){
		alert("该功能不可用！");
	}
</script>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="img/main.svg"/></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="dormitory.action" style="color: #868686;">宿舍列表</a>
	</div>
	<table width="750" border="0" cellspacing="0" cellpadding="3" align="center" id="t1">
		<tr align="center">
				<td width="152">
					<a href="beforeAdd.action">
						<img title="增加" src="img/add.png" align="middle">&nbsp;<span style="position:relative;top:5px;color:#2dc3e8">增加</span>
					</a> 
				</td>
				<form action="${pageContext.request.contextPath }/query5.action" method="post" name="inqForm" border="0">
					<td width="598">
						关键字: 
						<label> 
							<input name="strKey" type="text" size="15" value="<s:property value="strKey"/>" autocomplete="off">
							<select name="strType" id="select" style="padding:2px;">
								<option value="buildingId">
									宿舍号
								</option>
								<option value="buildingName">
									楼宇
								</option>
							</select> 
							<input type="button" name="button" id="button" value="重置" onClick="clearData()">
							<input type="submit" name="button" id="button" value="搜索">
						</label>
					</td>
				</form>
		</tr>
	</table>	
	<table width="750" cellspacing="0" cellpadding="3" align="center" id="t2">
		<tr>
			<th>宿舍号</th>
			<th>楼宇</th>
			<th>宿舍楼层</th>
			<th>最大可住</th>
			<th>已经入住</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" var="dorm">
			<tr>
				<td width="22%">
					<s:property value="#dorm.buildingId"/>
				</td>
				<td width="22%">
					<s:property value="#dorm.buildingName"/>
				</td>
				<td width="10%">
					<s:property value="#dorm.buildingFloor"/>
				</td>
				<td width="18%">
					<s:property value="#dorm.max_num"/>
				</td>
				<td width="18%">
					<s:property value="#dorm.lived_num"/>
				</td>
				<td width="10%">
					<a href="#" id="warn" onclick="warn()"><img title="修改" src="img/update.png"></a>
					<a href="${pageContext.request.contextPath }/delete5.action?id=<s:property value="#dorm.buildingId"/>"><img title="删除" src="img/delete.png"></a>
				</td>
			</tr>
		</s:iterator>
		<tr>
			<th colspan="6">
				当前页数<s:property value="page"/>/<s:property value="pageCnt"/>&nbsp; 
				<s:if test="page > 1">
				<a href="dormitory.action?page=1">第一页</a>
				<a href="dormitory.action?page=<s:property value="page - 1"/>">上一页</a>
				</s:if>
				<s:if test="page < pageCnt">
				<a href="dormitory.action?page=<s:property value="page + 1"/>">下一页</a>
				<a href="dormitory.action?page=<s:property value="pageCnt"/>">页尾</a>
				</s:if>
			</th>
		</tr>
	</table>
</body>
</html>