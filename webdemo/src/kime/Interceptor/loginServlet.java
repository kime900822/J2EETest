package kime.Interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/Interceptor/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String url=request.getParameter("url");
		
		if (uname.equals("aaa")&&upwd.equals("123456")) {
			request.setAttribute("msg", "登录成功");
			request.getSession().setAttribute("flag", "success");
			request.getRequestDispatcher("/Interceptor/index.jsp").forward(request, response);
		}else{
			if (uname==""||upwd=="") {
				request.setAttribute("msg", "用户名或者账号不能为空");
				request.getRequestDispatcher("/Interceptor/login.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "用户名或者密码错误");
				request.getRequestDispatcher("/Interceptor/login.jsp").forward(request, response);
			}
			request.getSession().setAttribute("flag", "");
		}
	}

}
