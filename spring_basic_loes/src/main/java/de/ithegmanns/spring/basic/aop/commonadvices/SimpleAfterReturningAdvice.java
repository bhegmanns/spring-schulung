package de.ithegmanns.spring.basic.aop.commonadvices;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object result, Method m, Object[] args,
			Object target) throws Throwable {
		System.out.println("Returning aus Method " + m + " for target: " 
				+ target + " with result: " + result);

	}

}
