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
<script src="js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$("#t1").submit(function(){
			var $buildingId = $(".buildingId");
			var $buildingFloor = $(".buildingFloor");
			if($buildingId.val() == ""){
				alert("宿舍号不能为空");
				return false;
			}
			if($buildingFloor.val() == ""){
				alert("宿舍楼层不能为空");
				return false;
			}
			return true;
		})
	})
</script>
</head>
<body>
	<div id="title">
			<div id="main_icon"><img src="img/main.svg"/></div>
			<a href="${pageContext.request.contextPath }/show/main.jsp" style="color:#2dc3e8; margin-left: 8px;">首页</a>
			<span id="content" style="color: #868686;">&nbsp;/&nbsp;</span>
			<a href="dormitory.action" style="color: #868686;">宿舍列表</a>
	</div>
	<form action="${pageContext.request.contextPath }/add5.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					增加宿舍基本信息
				</th>
			</tr>
			<tr>
				<td width="177" align="right">
					宿舍号：
				</td>
				<td width="323" align="left">
					<input type="text" name="dormitory.buildingId" placeholder="如：(男生宿舍1栋101)" class="buildingId">
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					楼宇：
				</td>
				<td width="323" align="left">
					<select name="dormitory.buildingName" id="select" style="padding:2px;" class="buildingName">
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
					宿舍楼层：
				</td>
				<td width="323" align="left">
					<input type="text" name="dormitory.buildingFloor" placeholder="如：(一楼)" class="buildingFloor">
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					最大可住：
				</td>
				<td width="323" align="left">
					<input type="text" name="dormitory.max_num" value="6" readonly="readonly" class="max_num"> 
				</td>
			</tr>
			<tr>
				<td width="177" align="right">
					已经入住：
				</td>
				<td width="323" align="left">
					<input type="text" name="dormitory.lived_num" value="0" readonly="readonly" class="lived_num">
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