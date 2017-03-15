<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:property value="product1.name"/><p/>
	<s:property value="product1.price"/><p/>
	<s:property value="product1.count"/><p/>
	<s:property value="product2.name"/><p/>
	<s:property value="product2.price"/><p/>
	<s:property value="product2.count"/><p/>
	<s:iterator  var="product" status="i" value="products">
		产品数组[${i.index}]<p>
		名称：${product.name}&nbsp;&nbsp;
		价格：${product.price}&nbsp;&nbsp;
		数量：${product.count}&nbsp;&nbsp;<p>
	</s:iterator>

</body>
</html>