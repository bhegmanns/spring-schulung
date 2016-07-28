package de.hegmanns.spring.schulung.demo.halloweltpointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class HalloWeltPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> arg) {
		return "sayHello".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> c) {
				return c == HalloWeltBean.class;
			}
		};
	}

}
