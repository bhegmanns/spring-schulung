package de.ithegmanns.spring.basic.aop.commonadvices;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleMethodInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation inv) throws Throwable
    {
        try {
        	System.out.println("SimpleMethodInterceptor: Call to method: " + inv.getMethod().getName());

			Object[] args = inv.getArguments();
			System.out.println("SimpleMethodInterceptor: args: " + Arrays.toString(args));
			// args[0] = 99;
			
			AccessibleObject ao = inv.getStaticPart();
			System.out.println("SimpleMethodInterceptor: AccessibleObject: " + ao);

			return inv.proceed();
			
		} catch (IllegalStateException e) {
			ArrayList<String> a = new ArrayList<String>();
			
			a.add("Rennboot");
			a.add("Paddelboot");
			
			return a;
		}
    }

}
