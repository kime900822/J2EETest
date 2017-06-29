package kime.shweb.action;

import com.opensymphony.xwork2.ActionSupport;

import kime.shweb.control.ProductService;
import kime.shweb.control.ServiceFactory;

public class DeleteAction extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		ProductService ps=ServiceFactory.getServiceInstance();
		ps.deleteProduct(id);
		return SUCCESS;
		
	}
	
	
	
}
