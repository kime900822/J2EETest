<%@page import="com.sun.image.codec.jpeg.JPEGCodec"%>
<%@page import="com.sun.image.codec.jpeg.JPEGImageEncoder"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="image/jpeg; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String s="";
int inicount=0;
inicount=(new Random()).nextInt(8999)+1000;
s=inicount+"";
session.setAttribute("validateCode", s);
response.setContentType("image/gif");
BufferedImage image=new BufferedImage(35,14,BufferedImage.TYPE_INT_RGB);
Graphics gra=image.getGraphics();
//设置背景色
gra.setColor(Color.yellow);
gra.fillRect(1, 1, 33, 12);
//设置字体颜色
gra.setColor(Color.black);
gra.setFont(new Font("宋体",Font.PLAIN,12));
//输出数字
char c;
for(int i=0;i<4;i++){
	c=s.charAt(i);
	//7为宽度，11为高度
	gra.drawString(c+"", i*7+4, 11);
}
OutputStream toClient=response.getOutputStream();
//创建一个和指定输出流关联的JPEGImageEncoder对象。
JPEGImageEncoder encode=JPEGCodec.createJPEGEncoder(toClient);
encode.encode(image);
toClient.close();
out.clear();
out=pageContext.pushBody();


%>