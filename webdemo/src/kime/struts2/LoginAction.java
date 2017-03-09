package kime.struts2;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

public class LoginAction implements Action {
	
	private String username;
	private String password;
	private static Map<String,String> users=new HashMap<String,String>();
	
	
	
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
		users.put("mike", "4321");				
	}
	

	@Override
	public String execute() throws Exception {
		try {
			ActionContext context=ActionContext.getContext();
			Map application=context.getApplication();
			Map session=context.getSession();
			Integer counter=(Integer)application.get("counter");
			session.put("username", getUsername());
			String pw=users.get(username);
			if (pw==null) {
				context.put("info", "用户不存在");
				return ERROR;
			}
			else{
				if (pw.equals(getPassword())) {
					if (counter==null) {
						counter=1;
					}else{
						counter++;
					}
					application.put("counter", counter);
					context.put("info", "登录成功");
					return SUCCESS;
				}else{
					context.put("info", "密码错误");
					return ERROR;
				}
							
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		
		
	}

}
