package kime.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 根据Cookie跟踪Session
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(60*60*24);
		if (session.isNew()) {
			session.setAttribute("session", "宇宙");
			out.println("对象已建立");
		}
		else {
			out.print("会话属性值:"+session.getAttribute("session"));
		}
				
		
	}

	
	
}
