<%@page import="chapter5.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Java Bean</title>
</head>
<body>
<jsp:useBean id="myClass" class="chapter5.MyClass"></jsp:useBean>
<jsp:setProperty property="name" name="myClass" value="bill" />
<jsp:setProperty property="age" name="myClass" value="32" />

<%
	String name=((MyClass)pageContext.getAttribute("myClass")).getName();
	int age=((MyClass)pageContext.getAttribute("myClass")).getAge();
	String tmp="aaaa";
	request.setAttribute("tmp", tmp);
	out.print("name:"+name);
	out.print("<br>age:"+age);	
	//out.flush();
	
%>
 <p>
name:<jsp:getProperty property="name" name="myClass"/><br>
age:<jsp:getProperty property="age" name="myClass"/>
 <p>
name:${myClass.name} <br>
age:${myClass.age}<p>
${tmp} 
</body>
</html>