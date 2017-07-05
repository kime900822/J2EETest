package kime.sshdemo.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import kime.sshdemo.po.User;
import kime.sshdemo.service.UserService;

public class AddUserAction extends ActionSupport {
	private int id;
	private String username;
	private String password;
	private int age;
	private Date birth;
	private String email;
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setAge(age);
		user.setBirth(birth);
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		if (userService.addUser(user)) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	
	}
	
	
	
	
}
