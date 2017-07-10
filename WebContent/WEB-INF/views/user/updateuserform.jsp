<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>修改用户</h1>
<form action="/hrmapp_v2/user/updateuser">
<input type="hidden" name="id" value="${user.id}" >
姓名<input type="text" name="username" value="${user.username}"/><br><br>
状态<input type="text" name="status" value="${user.status}"/><br><br>
登录名<input type="text" name="loginname" value="${user.loginname}" /><br><br>
密码<input type="text" name="password"  value="${user.password}" /><br><br>
<input type="submit" value="修改" />
</form>
</body>
</html>