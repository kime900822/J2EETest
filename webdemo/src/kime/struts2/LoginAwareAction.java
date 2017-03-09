package kime.struts2;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

public class LoginAwareAction implements Action,ServletRequestAware,ApplicationAware{

	
	private String username;
	private String password;
	private HttpServletRequest request;
	private Map application;
	
	
	
	
	@Override
	public void setApplication(Map application) {
		this.application=application;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	
	private static Map<String, String> users=new HashMap<>();

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

	
	static{
		users.put("bill", "1234");
		users.put("kime", "4321");
		
	}

	@Override
	public String execute() throws Exception {
		try {
			HttpSession session=request.getSession();
			Integer counter=(Integer)application.get("counter");
			session.setAttribute("username", username);
			String pw=users.get(username);
			if (pw==null) {
				request.setAttribute("info", "用户不存在");
				return ERROR;
			}
			else{
				if (pw.equals(password)) {
					if (counter==null) {
						counter=1;
					}else{
						counter++;
					}
					application.put("counter", counter);
					request.setAttribute("info", "登录成功");
					return SUCCESS;
				}else{
					request.setAttribute("info", "密码错误");
					return ERROR;
				}
							
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}





}
