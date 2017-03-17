<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="register">
	<s:textfield label="用户名" name="username"> </s:textfield>
	<s:textfield label="密码" name="password"> </s:textfield>
	<s:textfield label="重写输入密码" name="repassword"> </s:textfield>
	<s:textfield label="年龄" name="age"> </s:textfield>
	<s:textfield label="生日" name="birthday"> </s:textfield>
	<s:submit value="注册"></s:submit>
</s:form>


</body>
</html>