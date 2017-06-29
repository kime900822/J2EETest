package kime.shweb.action;

import com.opensymphony.xwork2.ActionSupport;

import kime.shweb.control.ProductService;
import kime.shweb.control.ServiceFactory;
import kime.shweb.model.Product;

public class AddAction extends ActionSupport {

	private String id;
	private String name;
	private double price;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String execute() throws Exception {
		ProductService ps=ServiceFactory.getServiceInstance();
		Product p=new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		ps.addProduct(p);
		return SUCCESS;
		
	}

}
