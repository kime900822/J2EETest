package kime.login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

public class DBServer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Connection conn = null;
	
	/**
	 * 执行各种SQL
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception
	 */
	protected java.sql.ResultSet execSql(String sql,Object ...args)throws Exception{
		java.sql.PreparedStatement pStmt=conn.prepareStatement(sql);
		for(int i=0;i<args.length;i++){			
			pStmt.setObject(i+1, args[i]);
		}
		pStmt.execute();
		return pStmt.getResultSet();
	}
	
	/**
	 * 校对验证码
	 * @param request
	 * @param validationCode
	 * @return
	 */
	protected boolean checkValidationCode(HttpServletRequest request,String validationCode){
		//从session获取验证码
		String validationCodeSession=request.getSession().getAttribute("validation_code").toString();
		//如果验证码为null，则说明验证码过期，需刷新获取
		if(validationCodeSession==null){
			request.setAttribute("info", "验证码过期");
			request.setAttribute("codeError", "验证码过期");			
			return false;
		}
		
		if (!validationCode.equalsIgnoreCase(validationCodeSession)) {
			request.setAttribute("info", "验证码不正确");
			request.setAttribute("codeError", "验证码不正确");			
			return false;
		}
		
		return true;		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			if (conn==null) {
				javax.naming.Context ctx=new javax.naming.InitialContext();
				javax.sql.DataSource ds=(javax.sql.DataSource) ctx.lookup("java:/comp/env/jdbc/webdb");
				conn=ds.getConnection();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}

	@Override
	public void destroy() {
		try {
			if(conn!=null){
				conn.close();				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
