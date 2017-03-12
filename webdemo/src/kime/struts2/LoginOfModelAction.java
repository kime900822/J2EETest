package kime.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import kime.model.UserLogin;

public class LoginOfModelAction extends ActionSupport implements ModelDriven<UserLogin>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserLogin model=new UserLogin();
	
	@Override
	public UserLogin getModel() {
		return model;
	}

	@Override
	public String execute() throws Exception {
		if (getModel().getUsername().equals("bill")&&getModel().getPassword().equals("1234")) {
			getModel().setResult("登录成功");
			return SUCCESS;
		}else{
			return ERROR;			
		}
	}
	
	

}
