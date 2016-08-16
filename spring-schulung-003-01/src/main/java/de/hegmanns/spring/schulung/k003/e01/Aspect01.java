package de.hegmanns.spring.schulung.k003.e01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;


import org.aspectj.lang.annotation.After;

@Aspect
public class Aspect01 {

	/**
	 * Pointcut-Definition: Ausfuehrung aller Methoden mit dem Namen main, in allen Klassen, egal mit welchem Parameter.
	 * 
	 */
	@Pointcut("execution(* main(..))")
	public void entryPoint(){}
	
	/**
	 * In der Before-Annotation steht der Methodenname der Pointcut-Annotation.
	 * 
	 * @param joinpoint JoinPoint
	 */
	@Before("entryPoint()")
	public void before(JoinPoint joinpoint){
		System.out.println("Aspect before: " + joinpoint.getSignature().getName());
	}
	
	/**
	 * 
	 * @param joinpoint JoinPoint
	 */
	@After("entryPoint()")
	public void after(JoinPoint joinpoint){
		System.out.println("Aspect after: " + joinpoint.getSignature().getName());
	}
}
