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
<c:if test="${param.yzm!=null && param.yzm== validateCode}">
验证成功
</c:if>
<form  method="post">
输入验证码<input type="text" name="yzm"> <img src="code.jsp"/>
<input type="submit" value="确定">
</form>
</body>
</html>