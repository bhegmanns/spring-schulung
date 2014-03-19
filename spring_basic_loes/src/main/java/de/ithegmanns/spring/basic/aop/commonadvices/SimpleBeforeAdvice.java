package de.ithegmanns.spring.basic.aop.commonadvices;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method m, Object[] args, Object target)
			throws Throwable {
		System.out.println("Entering Method " + m + " for target: " + target);
	}

}
