package kime.struts2;

import java.util.Map;

public class QueryAction {
	private String name;
	private Map<String, Integer> result;
	public Map<String, Integer> getResult() {
		return result;
	}
	public void setResult(Map<String, Integer> result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	public String execute(){
		try {
			BookDAO book=new BookDAO();
			
			Map<String, Integer> books=book.getBooks(name);
			setResult(books);
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
	}
	
	
	
	
}
