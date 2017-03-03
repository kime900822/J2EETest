package kime.struts2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookDAO {

	private static Map<String,Integer> books=new LinkedHashMap<String,Integer>();
	protected Connection conn = null;
		
	static{
		books.put("J2EE", 79);
		books.put("VISUAL C#", 89);
		books.put("STRUTS2", 69);
		books.put("ASP", 69);
		books.put("ASP.NET", 79);
		books.put("XML", 65);		
	}
	
	
	public Map<String,Integer> getBooks(String name){
		Map<String,Integer> book=new LinkedHashMap<String,Integer>();
		for(Map.Entry<String, Integer> entry:books.entrySet()){
			if (entry.getKey().toLowerCase().contains(name.toLowerCase().trim())) {
				book.put(entry.getKey(), entry.getValue());
			}						
		}
		return book;
		
	}
	
	
	public Map<String, Integer> getBooksBySql(String name){
			Map<String, Integer> books=new LinkedHashMap<String,Integer>();
		try {
			javax.naming.Context ctx=new javax.naming.InitialContext();
			javax.sql.DataSource ds=(javax.sql.DataSource) ctx.lookup("java:/comp/evn/jdbc/webdb");
		    conn=ds.getConnection();
			PreparedStatement statement=conn.prepareStatement("select * from t_books where lower(name)=?");
			statement.setString(0, name.trim().toLowerCase());
			ResultSet set= statement.executeQuery();

			while(set.next()){
				books.put(set.getString(0), set.getInt(1));				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
				try {			
					if (conn!=null) {
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return books;


		
	}
	
	
}
