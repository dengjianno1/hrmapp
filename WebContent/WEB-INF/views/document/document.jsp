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
	<tr><th>标题</th><th>创建时间</th><th>创建人</th><th>描述</th><th colspan="2">操作</th><th>下载</th></tr>
	<c:forEach var="document" items="${documents}">
	<tr><td>${document.title}</td><td>${document.createDate}</td><td>${document.user.username}</td>
	<td>${document.remark}</td>
	<td><a href="/hrmapp_v2/document/updatedocumentform?id=${document.id}">修改</a></td>
	<td><a href="/hrmapp_v2/document/removedocument?id=${document.id}">删除</a></td>
	<td><a href="/hrmapp_v2/document/download/${document.id}">下载</a></td></tr>
	</c:forEach>
	</table>
</body>
</html>