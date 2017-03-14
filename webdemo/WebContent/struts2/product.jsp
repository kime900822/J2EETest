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

<s:form action="product">
	<s:textfield label="请输入产品信息" name="product1"/>
	<s:textfield label="请输入产品信息" name="product2"/>
	<s:submit value="提交"></s:submit>

</s:form>

</body>
</html>