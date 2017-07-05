package kime.sshdemo.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import kime.sshdemo.po.User;
import kime.sshdemo.service.UserService;

public class ShowUserAction extends ActionSupport {
	private int id;
	private UserService userService;


	public void setId(int id) {
		this.id = id;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public String execute() throws Exception {
		User user=(User)userService.queryUserByID(id);
		ServletActionContext.getRequest().setAttribute("user", user);
		return SUCCESS;
	}
	
	
	
}
