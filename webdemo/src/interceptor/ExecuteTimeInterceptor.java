package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExecuteTimeInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Name;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println(getName()+"开始执行");
		Long startTime=System.currentTimeMillis();
		String result=invocation.invoke();
		long endTime=System.currentTimeMillis();
		System.out.println(getName()+"执行方法的时间:"+(endTime-startTime));
		System.out.println(getName()+"执行结束");
		return result;
	}

}
