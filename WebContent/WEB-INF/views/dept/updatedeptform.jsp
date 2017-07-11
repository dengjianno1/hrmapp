<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改部门</title>
</head>
<body>
<form action="/hrmapp_v2/dept/updatedept">
<input type="hidden" name="id" value="${dept.id}" >
部门名称：<input type="text" value="${dept.name}" name="name" /><br><br>
详细描述：<input type="text" value="${dept.remark}" name="remark" /><br><br>
<input type="submit" value="修改" />
</form>
</body>
</html>