package kime.struts2;

import com.opensymphony.xwork2.Action;

public class ProductAction implements Action{

	private Product product1;
	private Product product2;
	
	
	public Product getProduct() {
		return product1;
	}



	public void setProduct(Product product1) {
		this.product1 = product1;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}



	public Product getProduct2() {
		return product2;
	}



	public void setProduct2(Product product2) {
		this.product2 = product2;
	}
	
	
}
