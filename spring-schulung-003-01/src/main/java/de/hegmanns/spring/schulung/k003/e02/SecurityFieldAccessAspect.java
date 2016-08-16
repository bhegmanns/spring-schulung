package de.hegmanns.spring.schulung.k003.e02;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;

@Aspect
public class SecurityFieldAccessAspect {
	
	@Pointcut("@annotation(yourAnnotation)")
	public void security(Security yourAnnotation){}
	
	@Pointcut("execution(* *(..))")
	public void ausfuehrung(){}
	
	@Before("security(yourAnnotation) && ausfuehrung()")
	public void foo(JoinPoint proceedingJoinPoint, Security yourAnnotation){
		System.out.println("Rolle" + (yourAnnotation.value().length==1?" ":"n ") + Arrays.stream(yourAnnotation.value()).collect(Collectors.joining(","))
				+ " benoetigt");
	}
	
}
