package spring.watch;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Watch implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("��ӭ���ٱ���");
		Object buy=arg0.proceed();
		System.out.println("��ӭ�ٴι��ٱ���");
		return buy;
	}

	
}
