package kime.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDictionary extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=resp.getWriter();
		try {
			//后去context对象
			javax.naming.Context ctx=new javax.naming.InitialContext();
			javax.sql.DataSource ds=(javax.sql.DataSource) ctx.lookup("java:/comp/env/jdbc/webdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM t_dictionary");
			ResultSet rs=pstmt.executeQuery();
			StringBuilder taBuilder=new StringBuilder();
			taBuilder.append("<table border='1'>");
			taBuilder.append("<tr><td>英文名</td><td>中文名</td></tr>");
			while(rs.next()){
				taBuilder.append("<tr><td>"+rs.getString("english")+"</td><td>"+rs.getString("chinese")+"</td></tr>");				
			}
			taBuilder.append("</table>");
			pw.println(taBuilder.toString());
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
