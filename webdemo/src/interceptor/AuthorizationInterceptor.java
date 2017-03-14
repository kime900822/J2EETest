package interceptor;

import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

	//用于页面登录时候判断是否已经登录。若未登录则返回login参数，进入配置的登录界面
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context=invocation.getInvocationContext();
		Map session=context.getSession();
		String user=(String)session.get("username");
		if (user!=null && "bill".equals(user)) {
			return invocation.invoke();
		}
		else{
			return Action.LOGIN;
			
		}
	}

}
