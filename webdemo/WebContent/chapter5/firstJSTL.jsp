<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="用<c:out>输出字符串" escapeXml="true" />
<br>
<c:set var="scopeVar1" value="为变量赋值，并将变量保存在request" scope="request" />
scopeVar1=<c:out value="${scopeVar1}" escapeXml="true"/>
<br>
<c:set var="scopeVar2" scope="session">
hello ${param.name}
</c:set>
scopeVar2=<c:out value="${scopeVar2}" />


</body>
</html>