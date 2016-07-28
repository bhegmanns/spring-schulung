package de.hegmanns.spring.schulung.aufgabe.hallowelt.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/aspectj.xml");
		HelloService greeter = ctx.getBean(HelloService.class);//ctx.getBean("greeter", HelloService.class);
		
		System.out.println("calling hello(\"Bernd\")");
		greeter.hello("Bernd");
		
		System.out.println("calling sayHello()");
		greeter.sayHello();
	}

}
