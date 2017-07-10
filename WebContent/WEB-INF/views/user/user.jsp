<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../menu.html" %>
	<table border="1" cellspacing="0" cellpadding="10">
	<tr><th>登录名</th><th>密码</th><th>用户名</th><th>状态</th><th>创建时间</th><th colspan="2">操作</th></tr>
	<c:forEach var="user" items="${users}">
	<tr><td>${user.loginname}</td><td>${user.password}</td><td>${user.username}</td>
	<td>${user.status}</td><td>${user.createDate}</td>
	<td><a href="/hrmapp_v2/user/updateuserform?id=${user.id}">修改</a></td>
	<td><a href="/hrmapp_v2/user/removeuser?id=${user.id}">删除</a></td></tr>
	</c:forEach>
	</table>
</body>
</html>