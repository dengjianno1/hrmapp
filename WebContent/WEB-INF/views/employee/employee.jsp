<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工查询</title>
</head>
<body>
<%@ include file="../menu.html" %>
	<table border="1" cellspacing="0" cellpadding="10">
	<tr><th>姓名</th><th>性别</th><th>手机号码</th><th>邮箱</th><th>职位</th><th>学历</th>
	<th>身份证号码</th><th>部门</th><th>联系地址</th><th>建档日期</th><th colspan="2">操作</th></tr>
	<c:forEach var="employee" items="${employees}">
	<tr><td>${employee.name}</td><td>${employee.sex}</td><td>${employee.tel}</td>
	<td>${employee.email}</td><td>${employee.job.name}</td><td>${employee.education}</td>
	<td>${employee.cardId}</td><td>${employee.dept.name}</td><td>${employee.address}</td>
	<td>${employee.createDate}</td>
	<td><a href="/hrmapp_v2/employee/updateemployeeform?id=${employee.id}">修改</a></td>
	<td><a href="/hrmapp_v2/employee/removeemployee?id=${employee.id}">删除</a></td></tr>
	</c:forEach>
	</table>
</body>
</html>