package kime.struts2;

import org.apache.struts2.convention.annotation.*;

@ParentPackage(value="parents")
@Namespace(value="/mychild")
@Results({@Result(name="success", location="/struts2/success.jsp"),@Result(name="error",location="/struts2/error.jsp")})

public class ChildAction {

	public String execute(){
		try {
			System.out.println("child");
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
		
	}
	
}
