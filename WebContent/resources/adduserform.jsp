<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.html" %>
<h1>添加用户</h1>
<form action="../user/adduser">
姓名<input type="text" name="username" /><br><br>
状态<input type="text" name="status" /><br><br>
登录名<input type="text" name="loginname" /><br><br>
密码<input type="password" name="password" /><br><br>
<input type="submit" value="添加" />
</form>
</body>
</html>