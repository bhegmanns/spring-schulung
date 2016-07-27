package de.hegmanns.spring.schulung.demo.proxyfactorybean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeansAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Methode " + method.getName());
	}

}
