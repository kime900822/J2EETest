package kime.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class ReadCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//遍历获取Cookie
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
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Cookie tempCookie=getCookieValue(request.getCookies(), "tmp");
		if (tempCookie != null) {
			out.println("临时Cookie值："+tempCookie.getValue());
		}else{
			out.println("临时Cookie未设置</br>");
		}
		
		Cookie cookie=getCookieValue(request.getCookies(), "cookie");
		if (cookie != null) {
			out.println("cookie:"+cookie.getValue());
		}else{
			out.println("cookie已被删除</br>");
		}
		
		Cookie userCookie=getCookieValue(request.getCookies(), "user");
		if (userCookie != null) {
			out.println("user:"+userCookie.getValue());
		}else{
			out.println("userCookie未设置</br>");
		}
	}

}
