package kime.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends DBServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=null;
		if (request.getParameter("login")!=null) {
			response.sendRedirect("/webdemo/login/login.jsp");
			return;
		}
		
		try {
			super.service(request, response);
			userName=request.getParameter("username");
			String passWord=request.getParameter("password");
			String email=request.getParameter("email");
			String validationCode=request.getParameter("validation_code");
			if (userName==null||passWord==null||email==null) {
				return;
			}
			if (userName.equals("")||passWord.equals("")||validationCode.equals("")) {
				return;						
			}
			userName=new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			request.setAttribute("page", "/webdemo/login/register.jsp");
			
			if (!checkValidationCode(request, validationCode)) {
				return;
			}
			
			email=email==null?"":email;
			String passworMD5=Encrypter.md5Encrypter(passWord);
			String sql="insert into t_users values (?,?,?)";
			execSql(sql, userName,passworMD5,email);
			request.setAttribute("info", "用户注册成功");
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("info", userName+"已经被使用");
		}finally {
			RequestDispatcher rd=request.getRequestDispatcher("/login/result.jsp");
			rd.forward(request, response);
		}
		
	}

	
	
}
