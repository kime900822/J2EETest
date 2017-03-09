package kime.Interceptor;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter(filterName="/PermissionFilter",urlPatterns="/Interceptor/*")
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String servletpath=req.getServletPath();
		String flag=session.getAttribute("flag")!=null? session.getAttribute("flag").toString():"";
		
		if (servletpath.equals("/Interceptor/login.jsp")||servletpath.equals("/Interceptor/index.jsp")||servletpath.equals("/Interceptor/loginServlet")||servletpath.equals("/Interceptor/logoutServlet") ) {
			chain.doFilter(request, response);
		}else{
			if (flag!=null && flag.equals("success")) {
				chain.doFilter(request, response);
			}else{
				req.setAttribute("msg", "登录失败，请重新登录");
				req.setAttribute("url", servletpath);
				req.getRequestDispatcher("/Interceptor/login.jsp").forward(req, resp);
			}
			
		}
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
