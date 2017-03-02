<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.*,java.util.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示服务器当前时间</title>

</head>
<body>
现在服务器的时间时：
<font color="red">
<%
SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
out.print(format.format(new Date()));
%>
</font>
</body>
</html>