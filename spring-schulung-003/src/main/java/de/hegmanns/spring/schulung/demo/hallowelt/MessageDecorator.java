package de.hegmanns.spring.schulung.demo.hallowelt;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Decorator vor der Ausfuehrung");
		Object returnValue = invocation.proceed();
		System.out.println("Decorator nach der Ausfuehrung");
		return returnValue; 
	}

}
