package kime.shweb.action;

import java.util.List;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import kime.shweb.control.ProductService;
import kime.shweb.control.ServiceFactory;

public class ShowAllAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		try {
			ProductService ps=ServiceFactory.getServiceInstance();
			List all=ps.queryAllProduct();
			ServletActionContext.getRequest().setAttribute("all", all);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return SUCCESS;		
		
	}
	
	

}
