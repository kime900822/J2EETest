package kime.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Cookie tmpCookie=new Cookie("tmp", "87654321");
		tmpCookie.setMaxAge(-1);
		response.addCookie(tmpCookie);
		Cookie cookie=new Cookie("cookie", "666");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		String user=request.getParameter("user");
		if (user != null) {
			Cookie userCookie=new Cookie("user", user);
			userCookie.setMaxAge(60*60*24);
			userCookie.setPath("/");
			response.addCookie(userCookie);
		}
		RequestDispatcher readCookie=getServletContext().getRequestDispatcher("/servlet/ReadCookie");
		readCookie.include(request, response);		
		
		
		
	}

	
	
}
