package kime.struts2;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private String username;
	private String password;
	private int age;
	private Date birthday;
	private String result;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		setResult("注册成功");
		return SUCCESS;
	}
	
	public String register() throws Exception {
		setResult("注册成功");
		return SUCCESS;
	}
	
	//用于校验数据的validate
	public void validateRegister() {
		if (username==null||username.equals("")||!username.matches("^\\w*$")||username.length()<4||username.length()>20) {
			addFieldError("username", "用户名必须是字母和数字，长度必须介于4和20之间！");
		}
		if (password==null||password.equals("")||password.length()<8||password.length()>30) {
			addFieldError("password", "密码的长度必须介于8和30之间");
		}
		if (age<=0 && age>=200) {
			addFieldError("age", "您必须输入一个有效的年龄");
		}
		if (birthday==null) {
			addFieldError("birthday", "出生日期必须输入");
		}else{
			Calendar enddate= Calendar.getInstance();
			Calendar startdate=Calendar.getInstance();
			startdate.set(1900, 1, 1);
			if (birthday.after(enddate.getTime())||birthday.before(startdate.getTime())) {
				addFieldError("birthday", "出生日期必须在一个有效范围");
			}
			
			
		}
	}
	
	
}
