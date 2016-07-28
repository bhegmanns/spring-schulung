package de.hegmanns.spring.schulung.demo.proxyfactorybean;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

public class BeansAdvice implements MethodBeforeAdvice, MethodInterceptor {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Methode " + method.getName());
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return invocation.proceed();
	}

}
