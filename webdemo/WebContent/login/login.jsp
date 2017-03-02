<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkLogin(){
	var username=document.getElementById("username");
	var password=document.getElementById("password");
	var validation_code=document.getElementById("validation_code");
	
	if(username.value==""){		
		alert("必须输入用户名！");
		username.focus();
		return;
	}
	
	if(password.value==""){		
		alert("必须输入密码！");
		password.focus();
		return;
	}
	
	
	if(validation_code.value==""){		
		alert("验证码必须输入！");
		validation_code.focus();
		return;
	}
	
	register_form.submit();
	
}



function refresh(){
	var img=document.getElementById("img_validation_code");
	img.src="<%=request.getContextPath() %>/servlet/validation_code?"+Math.random();		
}
</script>
</head>
<body>
<form name="register_form" action="<%=request.getContextPath() %>/servlet/login" method="post">
<span>*</span>用户名
<input type="text" id="username" name="username" value="${requestScope.username} " size="30" maxLength="30"/><br>
<font color="#FF000">${requestScope.userError}</font><br>
<span>*</span>输入密码
<input type="password" id="password" name="password" size="30" maxLength="30"/><br>
<font color="#FF000">${requestScope.passwordError}</font><br>
<span>*</span>验证码
<input type="text" id="validation_code" name="validation_code" size="30" maxLength="30" style="width:60px;margin-top:2px"/>
<img id="img_validation_code" src="<%=request.getContextPath() %>/servlet/validation_code" />
<input type="button" value="刷新" onclick="refresh()"><br>
<font color="#FF000">${requestScope.codeError}</font><br>
<input type="button" value="登录" onclick="checkLogin()">
<input type="submit" value="注册" name="register">
</form>
</body>
</html>
