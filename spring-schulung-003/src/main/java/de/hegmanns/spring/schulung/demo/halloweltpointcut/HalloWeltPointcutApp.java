package de.hegmanns.spring.schulung.demo.halloweltpointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class HalloWeltPointcutApp {

	public static void main(String [] args){
		HalloWeltBean bean = new HalloWeltBean();
		
		Pointcut pointcut = new HalloWeltPointcut();
		Advice advice     = new MethodAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory proxyfactory = new ProxyFactory();
		proxyfactory.addAdvisor(advisor);
		proxyfactory.setTarget(bean);
		
		HalloWeltBean proxy = (HalloWeltBean) proxyfactory.getProxy();
		
		proxy.sageHallo();
		proxy.sayHello();
	}
}
