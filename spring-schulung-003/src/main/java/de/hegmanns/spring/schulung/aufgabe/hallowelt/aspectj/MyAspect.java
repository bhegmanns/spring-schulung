package de.hegmanns.spring.schulung.aufgabe.hallowelt.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Pointcut("execution(* de.hegmanns.spring.schulung.aufgabe.hallowelt.aspectj.HelloService.*(..))")
	private void selectAll(){}


	@Before("selectAll()")
	public void everyHello(JoinPoint joinpoint){
		System.out.println(">>> " + joinpoint.getSignature().getName());
	}
	
	@Before("selectAll()")
	public void everyHello01(JoinPoint joinpoint){
		System.out.println(">>> " + joinpoint.getSignature().getName());
	}
	
	@After("execution(* HelloService.*(..))")
//	@After("@annotation(@MySpecialAnnotation)")
	public void sayHello(JoinPoint joinpoint){
		System.out.println(">>> " + joinpoint.getArgs());
	}
}
