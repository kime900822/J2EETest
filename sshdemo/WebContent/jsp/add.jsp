<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<center>
	<h2>添加用户</h2>
	<s:form action="addUser.action"  validate="true">
		<s:actionerror/>
		<s:textfield label="用户名" name="username"></s:textfield>
		<s:textfield label="密码" name="password"></s:textfield>
		<s:textfield label="年龄" name="age"></s:textfield>
		<s:textfield label="生日" name="birth"></s:textfield>
		<s:textfield label="邮箱地址" name="email"></s:textfield>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</center>
</body>
</html>