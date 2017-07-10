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
	<%@ include file="menu.html" %>
	<h1>当前在线用户</h1>
	<p>用户姓名：<c:out value="${user.username}"></c:out></p><br>
	<p>登录名：<c:out value="${user.loginname}"></c:out></p><br>
	<p>创建时间:<c:out value="${user.createDate}"></c:out></p><br>
</body>
</html>