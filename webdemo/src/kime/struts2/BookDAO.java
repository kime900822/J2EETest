package kime.struts2;

import java.util.*;

public class BookDAO {

	private static Map<String,Integer> books=new LinkedHashMap<String,Integer>();
	
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
	
	
}
