<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
	
	<!-- Model返回值 -->
	model返回值：<s:property value="model.result"/> <br>
	${requestScope.model.result }
	     <br>
	<!--  -->
	本站访问次数：${applicationScope.counter}</p>
	用户名：${sessionScope.username }</p>
	${requestScope.info}
	
</body>
</html>