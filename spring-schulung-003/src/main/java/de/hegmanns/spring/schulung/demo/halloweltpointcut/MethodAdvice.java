package de.hegmanns.spring.schulung.demo.halloweltpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method methode, Object[] arg, Object target) throws Throwable {
		System.out.println("Methode " + methode.getName() + " wird ausgefuehrt");
	}

}
