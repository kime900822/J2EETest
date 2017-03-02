package kime.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewSession extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 根据URL追踪Session
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//获得指向性SessionServlet的RequestDispatche
		RequestDispatcher sessionServlet=getServletContext().getNamedDispatcher("/servlt/SessionServlet");
		sessionServlet.include(request, response);
		//向客户端输出被重写的URL
		out.println("<br><a href='"+response.encodeURL("SessionServlet")+"'>SessionServlet</a>");
	}

}
