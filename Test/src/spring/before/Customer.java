package spring.before;

public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void buy(){
		System.out.println("Customer"+this.name+"buy something!");		
	}
}
