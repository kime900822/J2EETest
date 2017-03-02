<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="myelfun" prefix="elfun" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调用EL函数</title>
</head>
<body>
	<form method="post">
		请输入一个字符
		<input type="text" name="text">
		<p>
		<input type="submit" value="提交">
 	</form>
 	<p>
 	直接输出文本框的内容
 	<p>
  	${param.text} <!-- 输出亲求参数text的值 -->
  	<p>
  	使用定制函数输出文本框中的内容
  	<p>
  	<!-- 调用EL函数来替换字符串中的符号 -->
  	${elfun:ps(param.text)}  	
	
</body>
</html>