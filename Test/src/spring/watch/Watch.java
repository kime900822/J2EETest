package spring.watch;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Watch implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("欢迎光临本店");
		Object buy=arg0.proceed();
		System.out.println("欢迎再次光临本店");
		return buy;
	}

	
}
