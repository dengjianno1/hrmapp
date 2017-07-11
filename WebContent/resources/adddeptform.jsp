<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门</title>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.html" %>
<h1>添加部门</h1>
<form action="../dept/adddept">
部门名称：<input type="text" name="name" /><br><br>
详细描述：<input type="text" name="remark" /><br><br>
<input type="submit" value="添加" />
</form>
</body>
</html>