<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
</head>
<body>
<center>
	<h2>添加产品</h2>
	<s:form action="add">
		<s:textfield label="产品ID" name="id"></s:textfield>
		<s:textfield label="产品名" name="name"></s:textfield>
		<s:textfield label="产品价格" name="price"></s:textfield>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</center>
</body>
</html>