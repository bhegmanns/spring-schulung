package de.ithegmanns.spring.basic.aop.commonadvices;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class SimpleThrowsAdvice implements ThrowsAdvice {
	
	/*
	 * KEIN ZWANG zur Implementierung einer Methode!!!
	 * 
	 * Die Methodenparameter in "afterThrowing" koennen variieren.
	 * Einzige Bedingung: Throwable (oder eine Unterklasse) muss
	 * enthalten sein.
	 */
	
	public void afterThrowing(Method m, Object[] args, Object target, Throwable e) throws Throwable {
		System.out.println("Exception in Method " + m + " for target: " 
				+ target + ". Ex=" + e);
		}
}
