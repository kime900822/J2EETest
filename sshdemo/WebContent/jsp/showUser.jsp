<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
</head>
<body>
<center>
	<h2>用户详细信息</h2>
	<table border="1">
		<s:set var="user" value="#request.user"/>
		<tr>
			<td>用户ID</td>
			<td><s:property value="#user.id"/> </td>
		</tr>
		<tr>
			<td>用户名</td>
			<td><s:property value="#user.username"/> </td>
		</tr>
		<tr>
			<td>密码</td>
			<td><s:property value="#user.password"/> </td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><s:property value="#user.age"/> </td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><s:property value="#user.birth"/> </td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><s:property value="#user.email"/> </td>
		</tr>
	</table>
	<a href="showAll.action">返回用户列表</a>
</center>
</body>
</html>