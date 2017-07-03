package spring.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Welcome implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("ª∂”≠π‚¡Ÿ±æµÍ");
		
	}
	
}
