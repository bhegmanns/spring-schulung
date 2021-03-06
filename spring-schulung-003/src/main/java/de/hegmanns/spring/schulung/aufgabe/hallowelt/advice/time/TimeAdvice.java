package de.hegmanns.spring.schulung.aufgabe.hallowelt.advice.time;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class TimeAdvice implements MethodInterceptor {


	@Override
	public Object invoke(MethodInvocation methodinvocation) throws Throwable {
		System.out.println("" + methodinvocation.getMethod().getName());
		long nanoTimeStart = System.nanoTime();
		Object result = null;
		try{
		result = methodinvocation.proceed();
		}
		catch(Throwable e){
			e.printStackTrace(System.out);
			throw e;
		}
		finally {
			long nanoTimeEnd   = System.nanoTime();
			System.out.println("" + methodinvocation.getMethod().getName() + " in " + (nanoTimeEnd-nanoTimeStart) + "ns");
//			return result;
		}
		
		return result;
		
	}

	
}
