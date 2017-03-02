<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkRegister(){
	var username=document.getElementById("username");
	var password=document.getElementById("password");
	var repassword=document.getElementById("repassword");
	var email=document.getElementById("email");
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
	
	if(repassword.value!=password.value){		
		alert("输入的密码不一致！");
		repassword.focus();
		return;
	}
	
	
	if(email.value!=""){		
		if(!checkEmail(email)) return;
	}
		
	
	if(validation_code.value==""){		
		alert("验证码必须输入！");
		validation_code.focus();
		return;
	}
	
	register_form.submit();
	
}


function checkEmail(email){
	
	var email=email.value;
	var pattern=/^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	flag=pattern.test(email);
	if(!flage){
		alert("Email格式不正确");
		email.focus();
		return false;
		
	}
	
}


function refresh(){
	var img=document.getElementById("img_validation_code");
	img.src="<%=request.getContextPath() %>/servlet/validation_code?"+Math.random();		
}
</script>
</head>
<body>
<form name="register_form" action="<%=request.getContextPath() %>/servlet/register" method="post">
<span>*</span>用户名
<input type="text" id="username" name="username" size="30" maxLength="30"/><br>
<span>*</span>输入密码
<input type="password" id="password" name="password" size="30" maxLength="30"/><br>
<span>*</span>请再次输入密码
<input type="password" id="repassword" name="repassword" size="30" maxLength="30"/><br>
邮箱地址：
<input type="text" id="email" name="email" size="30" maxLength="30"/><br>
<span>*</span>验证码
<input type="text" id="validation_code" name="validation_code" size="30" maxLength="30" style="width:60px;margin-top:2px"/>
<img id="img_validation_code" src="<%=request.getContextPath() %>/servlet/validation_code" />
<input type="button" value="刷新" onclick="refresh()"><br>
<input type="button" value="注册" onclick="checkRegister()">
<input type="submit" value="登录" name="login">
</form>
</body>
</html>
