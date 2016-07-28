package de.hegmanns.spring.schulung.aufgabe.hallowelt.advice.security;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import de.hegmanns.spring.schulung.aufgabe.hallowelt.CallContext;
import de.hegmanns.spring.schulung.aufgabe.hallowelt.CallUser;

public class SecurityInterceptor implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arguments, Object target) throws Throwable {
		String argument = (String)arguments[0];
		
		CallContext cc = new CallContext();
		CallUser calluser = cc.getCallUser();
		if (calluser != null){
			if (!calluser.getFirstName().equals(argument)){
				throw new RuntimeException("user problem");
			}
		}else{
			throw new RuntimeException("not logged in");
		}
	}

}
