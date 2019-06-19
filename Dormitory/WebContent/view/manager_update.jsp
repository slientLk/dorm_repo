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
			var $password = $(".password");
			var $telephone = $(".telephone");
			if($password.val() == ""){
				alert("密码不能为空");
				return false;
			}
			if($telephone.val() == ""){
				alert("联系电话不能为空");
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
			<a href="manager.action" style="color: #868686;">宿管列表</a>
	</div>
	<form action="${pageContext.request.contextPath }/update1.action" method="post" id="t1">
		<table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
			<tr>
				<th colspan="2" scope="col">
					修改宿管基本信息
				</th>
			</tr>
			<s:iterator value="list" var="man">
				<tr>
					<td width="177" align="right">
						编号：
					</td>
					<td width="323" align="left">
						<input type="text" name="manager.id" value="<s:property value="#man.id"/>" readonly="true">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						密码：
					</td>
					<td width="323" align="left">
						<input type="password" name="manager.password" value="<s:property value="#man.password"/>" class="password">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						姓名：
					</td>
					<td width="323" align="left">
						<input type="text" name="manager.username" value="<s:property value="#man.username"/>" readonly="true">
					</td>
				</tr>
				<tr>
					<td width="177" align="right">
						联系电话：
					</td>
					<td width="323" align="left">
						<input type="text" name="manager.telephone" value="<s:property value="#man.telephone"/>" class="telephone">
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