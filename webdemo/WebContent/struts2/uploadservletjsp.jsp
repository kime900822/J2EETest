<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传单个文件</title>
</head>
<body>
普通上传文件<p>
	<form action="UploadServlet" method="post" enctype="multipart/form-data" >
		上传文件：<input type="file" name="file" /><p>
		新文件名：<input type="text" name="filename" /><p>
		<input type="submit" value="提交" />
	
	</form><p>
Struts2 上传文件<p>
	<s:form action="UploadAction" enctype="multipart/form-data">
		<s:file label="上传文件" name="upload"></s:file>
		<s:textfield label="新文件名" name="filename"></s:textfield>
		<s:submit value="上传"></s:submit>
	
	</s:form>

</body>
</html>