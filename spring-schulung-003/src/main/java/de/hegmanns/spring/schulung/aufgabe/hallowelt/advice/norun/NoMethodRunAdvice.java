package de.hegmanns.spring.schulung.aufgabe.hallowelt.advice.norun;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class NoMethodRunAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arguments, Object target) throws Throwable {
		String argument = ((String)arguments[0]).toLowerCase();
		if (argument.contains("bill") || argument.contains("gates")){
			throw new NoGreetException(argument);
		}
	}

}
