package de.hegmanns.spring.schulung.demo.hallowelt;

import org.springframework.aop.framework.ProxyFactory;

public class HalloWeltAop {

	public static void main(String[] args){
		MessageWriter messageWriter = new MessageWriter();
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new MessageDecorator());
		proxyFactory.setTarget(messageWriter);
		
		MessageWriter proxyWriter = (MessageWriter) proxyFactory.getProxy();

		messageWriter.writeMessage();
		System.out.println("----");
		proxyWriter.writeMessage();
	}
}
