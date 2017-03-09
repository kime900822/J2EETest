<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
<%
if(request.getAttribute("url")!=null){	
	%>
	<input type="hidden" value="<%=request.getAttribute("url") %>" name="url" />
	<% 
}

if(request.getSession().getAttribute("msg")!=null){
	%>
	<%=request.getAttribute("msg")%><br/>
	<% 
}
%>
<h4>登录</h4>
<form action="<%=request.getContextPath()%>/Interceptor/loginServlet" method="post">
	<table border="1">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="uname" />  </td>
		</tr>
		<tr>
			<td>密码名</td>
			<td><input type="password" name="upwd" />  </td>
		</tr>
		<tr>
			<td rowspan=2 ><input type="submit" value="提交"/> </td>
		</tr>
	</table>
</form>

</body>
</html>