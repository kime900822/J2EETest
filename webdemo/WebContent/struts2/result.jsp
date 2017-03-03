<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>书名</th>
			<th>价格</th>
		</tr>
		<!-- JAVA方式获取 -->
		<%
			Map<String,Integer>result=(Map<String,Integer>)request.getAttribute("result");
			for(Map.Entry<String,Integer> entry:result.entrySet()){ 
		%>
			<tr><td><%=entry.getKey ()%></td>
			<td><%=entry.getValue()%></td></tr>
			
		<% }%>
		
		<!-- JSTL方式 -->
		<c:forEach var="entry" items="${result}">
			<tr>
				<td>${entry.key} </td>
				<td>${entry.value} </td>
			</tr>
		</c:forEach>
		
		<!-- Struts2 标签 -->
		<s:iterator value="result">
			<tr>
				<td><s:property value="key" /></td>
				<td><s:property value="value" /></td>
			</tr>
		</s:iterator>
	
	</table>	
</body>
</html>