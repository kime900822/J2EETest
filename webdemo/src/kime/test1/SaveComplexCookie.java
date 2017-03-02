package kime.test1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class SaveComplexCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个用于进行base编码的对象
		BASE64Encoder base64Encoder=new BASE64Encoder();
		//创建用于接收被序列化实例的字节流
		ByteArrayOutputStream classBytes=new ByteArrayOutputStream();
		
		//创建 一个用于向流中写入对象的Object流
		ObjectOutputStream oos=new ObjectOutputStream(classBytes);
		oos.writeObject(new Mycookie());	
		String classStr=base64Encoder.encode(classBytes.toByteArray());
		
		Cookie cookie=new Cookie("mycookie", classStr);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("MyCookie对象已经写入cookie");		
		
		
	}

	
	
}

class Mycookie implements java.io.Serializable{
	public String getMsg(){
		return "MyCookie 对象实例是从Cookie中获取的！";
	}
	
}
