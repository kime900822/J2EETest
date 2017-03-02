package kime.test1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class ReadComplexCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BASE64Decoder base64Decoder=new BASE64Decoder();
			Cookie cookie=getCookieValue(request.getCookies(),"mycookie");
			if (cookie==null) {
				return;
			}
			String classStr=cookie.getValue();
			byte[] classByte=base64Decoder.decodeBuffer(classStr);
			ObjectInputStream oos=new ObjectInputStream(new ByteArrayInputStream(classByte));
			Mycookie mycookie=(Mycookie)oos.readObject();
			response.setContentType("text/htm:charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println(mycookie.getMsg());						

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Cookie getCookieValue(Cookie[] cookies,String name){
		if (cookies !=null) {
			for(Cookie c:cookies){
				if (c.getName().equals(name)) {
					return c;
				}
				
			}
		}
		return null;
		
	}

	
	
}
