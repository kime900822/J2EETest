<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计次数</title>
</head>
<body>
<%
int counter=1;
if(application.getAttribute("COUNTER")!=null){
	counter=(Integer)application.getAttribute("COUNTER")+1;	
}
application.setAttribute("COUNTER", counter);
out.print(counter);

%>

</body>
</html>