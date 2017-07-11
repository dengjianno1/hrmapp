<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位查询</title>
</head>
<body>
	<%@ include file="../menu.html" %>
	<table border="1" cellspacing="0" cellpadding="10">
	<tr><th>职位名称</th><th>详细信息</th><th colspan="2">操作</th></tr>
	<c:forEach var="job" items="${jobs}">
	<tr><td>${job.name}</td><td>${job.remark}</td>
	<td><a href="/hrmapp_v2/job/updatejobform?id=${job.id}">修改</a></td>
	<td><a href="/hrmapp_v2/job/removejob?id=${job.id}">删除</a></td></tr>
	</c:forEach>
	</table>
</body>
</html>