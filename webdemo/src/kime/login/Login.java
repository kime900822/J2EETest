package kime.login;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends DBServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("register")!=null) {
			response.sendRedirect("/webdemo/login/register.jsp");
			return;
		}
		String page="/login/login.jsp";
		String userName="";
		try {
			super.service(request, response);
			userName=request.getParameter("username");
			userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
			String passWord=request.getParameter("password");
			String validationCode=request.getParameter("validation_code");
			if (userName==null||passWord==null||validationCode==null) {
				return;
			}
			if (userName.equals("")||passWord.equals("")||validationCode.equals("")) {
				return;						
			}
			
			
			
			if (!checkValidationCode(request, validationCode)) {
				request.setAttribute("codeError", "验证码错误");
				return;
			}
			
			
			String sql="select user_name,password_md5 from t_users where user_name=?";
			ResultSet rs=execSql(sql, userName);
			if (rs.next()==false) {
				request.setAttribute("userError", userName+"不存在");
			}else {
				String passWordMD5=Encrypter.md5Encrypter(passWord);
				if (!rs.getString("password_md5").equals(passWordMD5)) {
					request.setAttribute("passwordError", "密码错误");
				}
				else{
					page="/login/main.jsp";										
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			request.setAttribute("username", userName);
			RequestDispatcher rd=request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
	}

}
